package com.helovei.restaurant.api.repository;

import com.helovei.restaurant.api.model.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

    List<ReservationEntity> getReservationEntitiesByDateReservation(Date date);

}
