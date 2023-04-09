package com.helovei.restaurant.api.service;

import com.helovei.restaurant.api.exception.ObjectExistsInBaseException;
import com.helovei.restaurant.api.exception.ObjectNotExistsInBaseException;
import com.helovei.restaurant.api.exception.ReservationTimeIsInvalidException;
import com.helovei.restaurant.api.exception.TableIsReservedException;

import java.util.List;

public interface Service<T> {

    T getById(Long id);

    void add(T t) throws ObjectExistsInBaseException, TableIsReservedException, ReservationTimeIsInvalidException;

    void remove(T t);

    void update(T t) throws ObjectNotExistsInBaseException;
    List<T> getAll();

    boolean isExists(T t);



}
