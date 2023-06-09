package com.helovei.restaurant.api.controller;

import com.helovei.restaurant.api.dto.RegistrationDto;
import com.helovei.restaurant.api.exception.ObjectExistsInBaseException;
import com.helovei.restaurant.api.exception.ReservationTimeIsInvalidException;
import com.helovei.restaurant.api.exception.TableIsReservedException;
import com.helovei.restaurant.api.model.GuestEntity;
import com.helovei.restaurant.api.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GuestController {
    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody RegistrationDto registrationDto) throws ObjectExistsInBaseException, TableIsReservedException, ReservationTimeIsInvalidException {
        guestService.add(registrationDto.getEntity());
        return ResponseEntity.ok(guestService.getGuestEntityByFirstNameAndPatronymicAndLastName(
                registrationDto.getFirstName(),
                registrationDto.getPatronymic(),
                registrationDto.getLastName()
        ));
    }

    @GetMapping("/getGuests")
    public ResponseEntity<?> getGuests(){
        return ResponseEntity.ok().body(guestService.getAll());
    }
}
