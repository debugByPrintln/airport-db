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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aircraft aircraft = (Aircraft) o;

        if (!aircraftCode.equals(aircraft.aircraftCode)) return false;
        if (!model.equals(aircraft.model)) return false;
        if (!range.equals(aircraft.range)) return false;
        return seats.equals(aircraft.seats);
    }

    @Override
    public int hashCode() {
        int result = aircraftCode.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + range.hashCode();
        result = 31 * result + seats.hashCode();
        return result;
    }

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
