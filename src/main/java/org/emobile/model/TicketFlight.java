package org.emobile.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket_flights", schema = "bookings")
public class TicketFlight {

    @EmbeddedId
    private TicketFlightId id;

    @ManyToOne
    @MapsId("ticketNo")
    @JoinColumn(name = "ticket_no", nullable = false)
    private Ticket ticket;

    @ManyToOne
    @MapsId("flightId")
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    @Column(name = "fare_conditions", length = 10, nullable = false)
    private String fareConditions;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TicketFlight that = (TicketFlight) o;

        if (!id.equals(that.id)) return false;
        if (!ticket.equals(that.ticket)) return false;
        if (!flight.equals(that.flight)) return false;
        if (!fareConditions.equals(that.fareConditions)) return false;
        return amount.equals(that.amount);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + ticket.hashCode();
        result = 31 * result + flight.hashCode();
        result = 31 * result + fareConditions.hashCode();
        result = 31 * result + amount.hashCode();
        return result;
    }

    public TicketFlightId getId() {
        return id;
    }

    public void setId(TicketFlightId id) {
        this.id = id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getFareConditions() {
        return fareConditions;
    }

    public void setFareConditions(String fareConditions) {
        this.fareConditions = fareConditions;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
