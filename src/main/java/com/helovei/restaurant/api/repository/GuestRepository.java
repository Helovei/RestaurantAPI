package com.helovei.restaurant.api.repository;

import com.helovei.restaurant.api.model.GuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<GuestEntity, Long> {

    boolean existsByFirstNameAndPatronymicAndAndLastName(String firstName, String patronymic, String lastName);
    GuestEntity getGuestEntityByFirstNameAndPatronymicAndLastName(String firstName, String patronymic, String lastName);

}
