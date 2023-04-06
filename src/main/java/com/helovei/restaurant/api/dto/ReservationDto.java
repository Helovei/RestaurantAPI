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
public class ReservationDto implements Dto<ReservationEntity>{

    private GuestEntity guest;
    private TableEntity table;
    private String startReservation;
    private String endReservation;
    private final ReservationEntity entity;

    public ReservationDto(GuestEntity guest, TableEntity table, String startReservation, String endReservation) throws ParseException {
        DateFormatter dateFormatter = new DateFormatter("dd-MM-yyyy HH:mm");
        this.guest = guest;
        this.table = table;
        this.startReservation = startReservation;
        this.endReservation = endReservation;
        this.entity = new ReservationEntity(
                this.guest,
                this.table,
                dateFormatter.parse(startReservation, Locale.ENGLISH),
                dateFormatter.parse(endReservation, Locale.ENGLISH)
        );
    }

    public ReservationEntity getEntity() {
        return entity;
    }



}
