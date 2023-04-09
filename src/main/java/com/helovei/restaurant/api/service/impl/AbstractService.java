package com.helovei.restaurant.api.service.impl;

import com.helovei.restaurant.api.exception.ObjectExistsInBaseException;
import com.helovei.restaurant.api.exception.ObjectNotExistsInBaseException;
import com.helovei.restaurant.api.exception.ReservationTimeIsInvalidException;
import com.helovei.restaurant.api.exception.TableIsReservedException;
import com.helovei.restaurant.api.model.AbstractEntity;
import com.helovei.restaurant.api.service.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class AbstractService<T extends AbstractEntity, R extends JpaRepository<T, Long>> implements Service<T> {

    protected final R repository;

    public AbstractService(R repository) {
        this.repository = repository;
    }

    @Override
    public T getById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public void add(T t) throws ObjectExistsInBaseException, TableIsReservedException, ReservationTimeIsInvalidException {
        if (t.getId() == null && !isExists(t)){
                repository.save(t);
            } else throw new ObjectExistsInBaseException();
    }

    @Override
    public void remove(T t) {
        repository.delete(t);
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public void update(T t) throws ObjectNotExistsInBaseException {
        if (repository.existsById(t.getId())){
            repository.save(t);
        } else throw new ObjectNotExistsInBaseException();
    }

    @Override
    public boolean isExists(T t) {
        return repository.existsById(t.getId());
    }
}
