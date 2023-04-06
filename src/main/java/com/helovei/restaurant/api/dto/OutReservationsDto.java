package com.helovei.restaurant.api.dto;

import com.helovei.restaurant.api.model.ReservationEntity;
import com.helovei.restaurant.api.model.TableEntity;
import lombok.Data;

import java.util.Date;

@Data
public class OutReservationsDto {

    private TableEntity table;
    private Date startReservation;
    private Date endReservation;

    public OutReservationsDto(ReservationEntity entity) {
        this.table = entity.getTable();
        this.startReservation = entity.getStartReservation();
        this.endReservation = entity.getEndReservation();
    }

}
