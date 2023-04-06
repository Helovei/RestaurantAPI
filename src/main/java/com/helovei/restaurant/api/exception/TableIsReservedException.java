package com.helovei.restaurant.api.exception;

public class TableIsReservedException extends Throwable{

    public TableIsReservedException() {
        super("Table is reserved");
    }
}
