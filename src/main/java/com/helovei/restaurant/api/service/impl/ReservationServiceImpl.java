package com.helovei.restaurant.api.service.impl;

import com.helovei.restaurant.api.exception.ObjectExistsInBaseException;
import com.helovei.restaurant.api.exception.ReservationTimeIsInvalidException;
import com.helovei.restaurant.api.exception.TableIsReservedException;
import com.helovei.restaurant.api.model.ReservationEntity;
import com.helovei.restaurant.api.repository.ReservationRepository;
import com.helovei.restaurant.api.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class ReservationServiceImpl extends AbstractService<ReservationEntity, ReservationRepository> implements ReservationService {
    @Autowired
    public ReservationServiceImpl(ReservationRepository repository) {
        super(repository);
    }

    @Override
    public void add(ReservationEntity reservationEntity) throws ObjectExistsInBaseException, TableIsReservedException, ReservationTimeIsInvalidException {
        if (checkTime(reservationEntity)){
            if (check(reservationEntity)) {
                super.add(reservationEntity);
            } else throw new TableIsReservedException();
        } else throw new ReservationTimeIsInvalidException();


    }

//    to do
    @Override
    public boolean check(ReservationEntity reservationEntity) {
        return true;

    }

    private boolean checkTime(ReservationEntity entity) {
        return entity.getStartReservation().before(entity.getEndReservation());
    }

    private boolean checkIntersection(ReservationEntity oldReserved, ReservationEntity newReserved) {
        long startOldReserved = oldReserved.getStartReservation().getTime();
        long endOldReserved = oldReserved.getEndReservation().getTime();
        long startNewReserved = newReserved.getStartReservation().getTime();
        long endNewReserved = newReserved.getEndReservation().getTime();
        return (startOldReserved - endNewReserved) * (startNewReserved - endOldReserved) > 0;
    }

    @Override
    public List<ReservationEntity> getReservationsByDate(String date) throws ParseException {
        DateFormatter dateFormatter = new DateFormatter("dd.MM.yyyy");
        return super.repository.getReservationEntitiesByDateReservation(dateFormatter.parse(date, Locale.GERMAN));
    }

    @Override
    public boolean isExists(ReservationEntity entity) {
        return super.repository.existsByDateReservationAndStartReservationAndEndReservationAndGuestAndTable(
                entity.getDateReservation(),
                entity.getStartReservation(),
                entity.getEndReservation(),
                entity.getGuest(),
                entity.getTable()
        );
    }
}
