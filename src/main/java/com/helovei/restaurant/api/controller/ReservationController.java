package com.helovei.restaurant.api.controller;

import com.helovei.restaurant.api.dto.OutReservationsDto;
import com.helovei.restaurant.api.dto.ReservationDto;
import com.helovei.restaurant.api.exception.ObjectExistsInBaseException;
import com.helovei.restaurant.api.exception.TableIsReservedException;
import com.helovei.restaurant.api.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/addReservation")
    public ResponseEntity<?> addReservation(@ModelAttribute ReservationDto reservationDTO) throws TableIsReservedException, ObjectExistsInBaseException {
        reservationService.add(reservationDTO.getEntity());
        return ResponseEntity.ok().build();
    }

//    true - совпадений не найдено
//    false - пересечение
    @PostMapping("/check")
    public ResponseEntity<?> check(@ModelAttribute ReservationDto reservationDTO){
        return ResponseEntity.ok(reservationService.check(reservationDTO.getEntity()));
    }

    @GetMapping("/getReservation")
    public ResponseEntity<?> getAll(){
        List<OutReservationsDto> dtoList = new java.util.ArrayList<>();
        reservationService.getAll().forEach(item -> dtoList.add(new OutReservationsDto(item)));
        return ResponseEntity.ok(dtoList);
    }




}
