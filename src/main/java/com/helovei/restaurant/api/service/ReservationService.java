package com.helovei.restaurant.api.service;

import com.helovei.restaurant.api.model.ReservationEntity;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface ReservationService extends Service<ReservationEntity> {

    boolean check(ReservationEntity reservationEntity);

    List<ReservationEntity> getReservationsByDate(String date) throws ParseException;

}
