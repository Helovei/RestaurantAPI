package com.helovei.restaurant.api.repository;

import com.helovei.restaurant.api.model.GuestEntity;
import com.helovei.restaurant.api.model.ReservationEntity;
import com.helovei.restaurant.api.model.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

    List<ReservationEntity> getReservationEntitiesByDateReservation(Date date);
    boolean existsByDateReservationAndStartReservationAndEndReservationAndGuestAndTable(
            Date dateReservation,
            Date startReservation,
            Date endReservation,
            GuestEntity guest,
            TableEntity table
    );
}
