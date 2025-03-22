package org.emobile.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class TicketFlightId implements Serializable {

    @Column(name = "ticket_no")

    private String ticketNo;
    @Column(name = "flight_id")
    private Integer flightId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TicketFlightId that = (TicketFlightId) o;

        if (!ticketNo.equals(that.ticketNo)) return false;
        return flightId.equals(that.flightId);
    }

    @Override
    public int hashCode() {
        int result = ticketNo.hashCode();
        result = 31 * result + flightId.hashCode();
        return result;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }
}
