package com.helovei.restaurant.api.dto;

import com.helovei.restaurant.api.model.TableEntity;
import lombok.Data;

@Data
public class NewTableDto implements Dto<TableEntity> {

    private Integer tableNumber;

    private Integer availableSeats;

    @Override
    public TableEntity getEntity() {
        return new TableEntity(
                tableNumber,
                availableSeats
        );
    }
}
