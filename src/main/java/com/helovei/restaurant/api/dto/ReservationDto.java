package com.helovei.restaurant.api.dto;

import com.helovei.restaurant.api.model.GuestEntity;
import com.helovei.restaurant.api.model.ReservationEntity;
import com.helovei.restaurant.api.model.TableEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.datetime.DateFormatter;

import java.text.ParseException;
import java.util.Locale;

@Getter
@Setter
public class ReservationDto {

    private GuestEntity guest;
    private Integer tableNumber;
    private String dateReservation;
    private String startReservation;
    private String endReservation;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String phoneNumber;

    public ReservationDto(GuestEntity guest, Integer tableNumber, String dateReservation, String startReservation, String endReservation, String firstName, String lastName, String patronymic, String phoneNumber) {
        this.guest = guest;
        this.tableNumber = tableNumber;
        this.dateReservation = dateReservation;
        this.startReservation = startReservation;
        this.endReservation = endReservation;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
    }
}
