package com.helovei.restaurant.api.exception;

public class ObjectExistsInBaseException extends Throwable{
    public ObjectExistsInBaseException() {
        super("Create: Object is Exists in data base");
    }
}
