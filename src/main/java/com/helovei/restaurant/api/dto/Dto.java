package com.helovei.restaurant.api.dto;

import java.text.ParseException;

public interface Dto<T> {

    T getEntity() throws ParseException;

}
