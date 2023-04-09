package com.helovei.restaurant.api.controller;

import com.helovei.restaurant.api.exception.ObjectExistsInBaseException;
import com.helovei.restaurant.api.exception.ObjectNotExistsInBaseException;
import com.helovei.restaurant.api.exception.TableIsReservedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class GlobalControllerExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ObjectExistsInBaseException.class)
    public ResponseEntity<?> handleObjectExistsInBaseException() {
        return ResponseEntity.badRequest().body("Object is Exists in data base");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ObjectNotExistsInBaseException.class)
    public ResponseEntity<?> handleObjectNotExistsInBaseException() {
        return ResponseEntity.badRequest().body("Object is not exists in base");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(TableIsReservedException.class)
    public ResponseEntity<?> handleTableIsReservedException() {
        return ResponseEntity.badRequest().body("Table is reserved");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(TableIsReservedException.class)
    public ResponseEntity<?> handleReservationTimeIsInvalidException() {
        return ResponseEntity.badRequest().body("Reservation time is invalid");
    }
}
