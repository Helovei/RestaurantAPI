package com.helovei.restaurant.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "guests")
public class GuestEntity extends AbstractEntity {

    public GuestEntity() {
    }

    public GuestEntity(String firstName, String lastName, String patronymic, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

}
