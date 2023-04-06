package com.helovei.restaurant.api.service.impl;

import com.helovei.restaurant.api.exception.ObjectExistsInBaseException;
import com.helovei.restaurant.api.exception.TableIsReservedException;
import com.helovei.restaurant.api.model.ReservationEntity;
import com.helovei.restaurant.api.repository.ReservationRepository;
import com.helovei.restaurant.api.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl extends AbstractService<ReservationEntity, ReservationRepository> implements ReservationService {
    @Autowired
    public ReservationServiceImpl(ReservationRepository repository) {
        super(repository);
    }

    @Override
    public void add(ReservationEntity reservationEntity) throws ObjectExistsInBaseException, TableIsReservedException {
        if (check(reservationEntity)) {
            super.add(reservationEntity);
        } else throw new TableIsReservedException();

    }

    @Override
    public boolean check(ReservationEntity reservationEntity) {
        return super.getAll().stream()
                .filter(existReservation -> checkIntersection(existReservation, reservationEntity))
                .findFirst().isEmpty();
    }

    private boolean checkIntersection(ReservationEntity oldReserved, ReservationEntity newReserved) {
        long startOldReserved = oldReserved.getStartReservation().getTime();
        long endOldReserved = oldReserved.getEndReservation().getTime();
        long startNewReserved = newReserved.getStartReservation().getTime();
        long endNewReserved = newReserved.getEndReservation().getTime();
        return (startOldReserved - endNewReserved) * (startNewReserved - endOldReserved) > 0;
    }
}
