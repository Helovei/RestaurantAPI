package com.helovei.restaurant.api.exception;

public class ReservationTimeIsInvalidException extends Exception{

    public ReservationTimeIsInvalidException() {
        super("Time is invalid");
    }
}
