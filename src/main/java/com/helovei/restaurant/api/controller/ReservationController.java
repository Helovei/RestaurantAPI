package com.helovei.restaurant.api.controller;

import com.helovei.restaurant.api.dto.OutReservationsDto;
import com.helovei.restaurant.api.dto.ReservationDto;
import com.helovei.restaurant.api.exception.ObjectExistsInBaseException;
import com.helovei.restaurant.api.exception.ReservationTimeIsInvalidException;
import com.helovei.restaurant.api.exception.TableIsReservedException;
import com.helovei.restaurant.api.model.ReservationEntity;
import com.helovei.restaurant.api.service.GuestService;
import com.helovei.restaurant.api.service.ReservationService;
import com.helovei.restaurant.api.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
public class ReservationController {

    private final ReservationService reservationService;
    private final TableService tableService;
    private final GuestService guestService;

    @Autowired
    public ReservationController(ReservationService reservationService, TableService tableService, GuestService guestService) {
        this.reservationService = reservationService;
        this.tableService = tableService;
        this.guestService = guestService;
    }

    @PostMapping("/addReservation")
    public ResponseEntity<?> addReservation(@RequestBody ReservationDto reservationDTO) throws TableIsReservedException, ObjectExistsInBaseException, ParseException, ReservationTimeIsInvalidException {
        reservationService.add(getEntity(reservationDTO));
        return ResponseEntity.ok().build();
    }

    //    true - совпадений не найдено
//    false - пересечение
    @PostMapping("/check")
    public ResponseEntity<?> check(@RequestBody ReservationDto reservationDTO) throws ParseException {
        return ResponseEntity.ok(reservationService.check(getEntity(reservationDTO)));
    }

    @GetMapping("/getReservations")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(reservationService.getAll());
    }

    @GetMapping("/getReservationsByDate")
    public ResponseEntity<?> getReservationsByDate(@RequestParam String date) throws ParseException {
        List<OutReservationsDto> dtoList = new java.util.ArrayList<>();
        reservationService.getReservationsByDate(date).forEach(item -> dtoList.add(new OutReservationsDto(item)));
        return ResponseEntity.ok(dtoList);
    }

    private ReservationEntity getEntity(ReservationDto reservationDto) throws ParseException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm");
        return new ReservationEntity(
                guestService.getGuestEntityByFirstNameAndPatronymicAndLastName(
                        reservationDto.getFirstName(),
                        reservationDto.getPatronymic(),
                        reservationDto.getLastName()),
                tableService.getTableEntityByTableNumber(reservationDto.getTableNumber()),
                dateFormatter.parse(reservationDto.getDateReservation()),
                timeFormatter.parse(reservationDto.getStartReservation()),
                timeFormatter.parse(reservationDto.getEndReservation()));
    }

}
