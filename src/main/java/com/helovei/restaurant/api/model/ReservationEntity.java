package com.helovei.restaurant.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "reservation")
public class ReservationEntity extends AbstractEntity {

    public ReservationEntity() {
    }

    public ReservationEntity(GuestEntity guest, TableEntity table, Date startReservation, Date endReservation) {
        this.guest = guest;
        this.table = table;
        this.startReservation = startReservation;
        this.endReservation = endReservation;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "guest_id", nullable = false)
    private GuestEntity guest;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "table_id", nullable = false)
    private TableEntity table;
    @Column(name = "start_reservation", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startReservation;

    @Column(name = "end_reservation", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endReservation;

    @Column(name = "date_reservation", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateReservation;

}
