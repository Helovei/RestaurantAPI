package com.helovei.restaurant.api.dto;

import com.helovei.restaurant.api.model.GuestEntity;
import lombok.Data;

@Data
public class RegistrationDto {

    private String firstName;
    private String lastName;
    private String patronymic;
    private String phoneNumber;


    public GuestEntity getEntity() {
        return new GuestEntity(
                firstName,
                lastName,
                patronymic,
                phoneNumber
        );
    }
}
