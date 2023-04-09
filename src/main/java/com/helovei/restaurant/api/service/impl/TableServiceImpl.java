package com.helovei.restaurant.api.service.impl;

import com.helovei.restaurant.api.model.TableEntity;
import com.helovei.restaurant.api.repository.TablesRepository;
import com.helovei.restaurant.api.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableServiceImpl extends AbstractService<TableEntity, TablesRepository> implements TableService {
    @Autowired
    public TableServiceImpl(TablesRepository repository) {
        super(repository);
    }

    @Override
    public boolean isExists(TableEntity tableEntity) {
        return repository.existsByTableNumber(tableEntity.getTableNumber());
    }

}
