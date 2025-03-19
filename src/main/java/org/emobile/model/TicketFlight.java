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
