package org.emobile.model;

import jakarta.persistence.*;

@Entity
@Table(name = "seats", schema = "bookings")
public class Seat {

    @EmbeddedId
    private SeatId id;

    @ManyToOne
    @MapsId("aircraftCode")
    @JoinColumn(name = "aircraft_code", nullable = false)
    private Aircraft aircraft;

    @Column(name = "fare_conditions", length = 10, nullable = false)
    private String fareConditions;

    public SeatId getId() {
        return id;
    }

    public void setId(SeatId id) {
        this.id = id;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public String getFareConditions() {
        return fareConditions;
    }

    public void setFareConditions(String fareConditions) {
        this.fareConditions = fareConditions;
    }
}
