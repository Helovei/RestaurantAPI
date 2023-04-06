package com.helovei.restaurant.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "rest_tables")
@Setter
@Getter
public class TableEntity extends AbstractEntity {

    public TableEntity() {
    }

    public TableEntity(Integer tableNumber, Integer availableSeats) {
        this.tableNumber = tableNumber;
        this.availableSeats = availableSeats;
        this.isReserved = false;
    }

    @Column(name = "table_number", nullable = false)
    private Integer tableNumber;

    @Column(name = "available_seats", nullable = false)
    private Integer availableSeats;

    @Column(name = "isReserved", nullable = false)
    private Boolean isReserved;

}
