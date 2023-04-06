package com.helovei.restaurant.api.exception;

public class ObjectNotExistsInBaseException extends Throwable{

    public ObjectNotExistsInBaseException() {
        super("Update: Object is not exists in base");
    }
}
