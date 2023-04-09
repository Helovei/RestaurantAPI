package com.helovei.restaurant.api.controller;

import com.helovei.restaurant.api.dto.NewTableDto;
import com.helovei.restaurant.api.exception.ObjectExistsInBaseException;
import com.helovei.restaurant.api.exception.ReservationTimeIsInvalidException;
import com.helovei.restaurant.api.exception.TableIsReservedException;
import com.helovei.restaurant.api.model.TableEntity;
import com.helovei.restaurant.api.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TableController {

    private final TableService tableService;

    @Autowired
    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping("/getTables")
    public ResponseEntity<?> getTables(){
        return ResponseEntity.ok().body(tableService.getAll());
    }

    @PostMapping("/addTable")
    public ResponseEntity<?> addTable(@ModelAttribute NewTableDto newTableDto) throws ObjectExistsInBaseException, TableIsReservedException, ReservationTimeIsInvalidException {
        tableService.add(newTableDto.getEntity());
        return ResponseEntity.ok("adding table is success");
    }

}
