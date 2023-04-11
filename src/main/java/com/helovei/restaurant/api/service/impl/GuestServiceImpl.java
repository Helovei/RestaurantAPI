package com.helovei.restaurant.api.service.impl;

import com.helovei.restaurant.api.exception.ObjectExistsInBaseException;
import com.helovei.restaurant.api.exception.ReservationTimeIsInvalidException;
import com.helovei.restaurant.api.exception.TableIsReservedException;
import com.helovei.restaurant.api.model.GuestEntity;
import com.helovei.restaurant.api.repository.GuestRepository;
import com.helovei.restaurant.api.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl extends AbstractService<GuestEntity, GuestRepository> implements GuestService {

    @Autowired
    public GuestServiceImpl(GuestRepository repository) {
        super(repository);
    }

    @Override
    public void add(GuestEntity guest) {
        if (guest.getId() == null && !isExists(guest)){
            repository.save(guest);
        }
    }

    @Override
    public boolean isExists(GuestEntity guestEntity) {
        return repository.existsByFirstNameAndPatronymicAndAndLastName(
                guestEntity.getFirstName(),
                guestEntity.getPatronymic(),
                guestEntity.getLastName()
        );
    }

    @Override
    public GuestEntity getGuestEntityByFirstNameAndPatronymicAndLastName(String firstName, String patronymic, String lastName) {
        return super.repository.getGuestEntityByFirstNameAndPatronymicAndLastName(firstName, patronymic, lastName);
    }
}
