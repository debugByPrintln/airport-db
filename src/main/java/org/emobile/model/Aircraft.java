package org.emobile.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "aircrafts", schema = "bookings")
public class Aircraft {

    @Id
    @Column(name = "aircraft_code", length = 3)
    private String aircraftCode;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "range", nullable = false)
    private Integer range;

    @OneToMany(mappedBy = "aircraft")
    private Set<Seat> seats;

    public String getAircraftCode() {
        return aircraftCode;
    }

    public void setAircraftCode(String aircraftCode) {
        this.aircraftCode = aircraftCode;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }
}
