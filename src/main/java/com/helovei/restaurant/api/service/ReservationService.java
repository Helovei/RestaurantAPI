package com.helovei.restaurant.api.service;

import com.helovei.restaurant.api.model.ReservationEntity;

public interface ReservationService extends Service<ReservationEntity> {

    boolean check(ReservationEntity reservationEntity);

}
