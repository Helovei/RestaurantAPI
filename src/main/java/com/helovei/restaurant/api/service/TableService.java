package com.helovei.restaurant.api.service;

import com.helovei.restaurant.api.exception.ObjectNotExistsInBaseException;
import com.helovei.restaurant.api.model.TableEntity;

public interface TableService extends Service<TableEntity>{
        TableEntity getTableEntityByTableNumber(Integer tableNumber) throws ObjectNotExistsInBaseException;
}
