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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seat seat = (Seat) o;

        if (!id.equals(seat.id)) return false;
        if (!aircraft.equals(seat.aircraft)) return false;
        return fareConditions.equals(seat.fareConditions);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + aircraft.hashCode();
        result = 31 * result + fareConditions.hashCode();
        return result;
    }

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
