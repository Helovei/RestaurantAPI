package com.helovei.restaurant.api.repository;

import com.helovei.restaurant.api.model.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TablesRepository extends JpaRepository<TableEntity, Long> {

    boolean existsByTableNumber(Integer tableNumber);

}
