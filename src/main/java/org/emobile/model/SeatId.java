package org.emobile.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class SeatId implements Serializable {

    @Column(name = "aircraft_code")

    private String aircraftCode;
    @Column(name = "seat_no")
    private String seatNo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeatId seatId = (SeatId) o;

        if (!aircraftCode.equals(seatId.aircraftCode)) return false;
        return seatNo.equals(seatId.seatNo);
    }

    @Override
    public int hashCode() {
        int result = aircraftCode.hashCode();
        result = 31 * result + seatNo.hashCode();
        return result;
    }

    public String getAircraftCode() {
        return aircraftCode;
    }

    public void setAircraftCode(String aircraftCode) {
        this.aircraftCode = aircraftCode;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }
}
