package com.helovei.restaurant.api.service;

import com.helovei.restaurant.api.model.GuestEntity;

public interface GuestService extends Service<GuestEntity>{

    GuestEntity getGuestEntityByFirstNameAndPatronymicAndLastName(String firstName, String patronymic, String lastName);

}
