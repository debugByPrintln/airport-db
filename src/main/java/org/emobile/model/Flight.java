package org.emobile.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "flights", schema = "bookings")
public class Flight {

    @Id
    @Column(name = "flight_id", nullable = false)
    private Integer flightId;

    @Column(name = "flight_no", length = 6, nullable = false)
    private String flightNo;

    @Column(name = "scheduled_departure", nullable = false)
    private LocalDateTime scheduledDeparture;

    @Column(name = "scheduled_arrival", nullable = false)
    private LocalDateTime scheduledArrival;

    @ManyToOne
    @JoinColumn(name = "departure_airport", nullable = false)
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport", nullable = false)
    private Airport arrivalAirport;

    @Column(name = "status", length = 20, nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "aircraft_code", nullable = false)
    private Aircraft aircraft;

    @Column(name = "actual_departure")
    private LocalDateTime actualDeparture;

    @Column(name = "actual_arrival")
    private LocalDateTime actualArrival;

    @OneToMany(mappedBy = "flight")
    private Set<TicketFlight> ticketFlights;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (!flightId.equals(flight.flightId)) return false;
        if (!flightNo.equals(flight.flightNo)) return false;
        if (!scheduledDeparture.equals(flight.scheduledDeparture)) return false;
        if (!scheduledArrival.equals(flight.scheduledArrival)) return false;
        if (!departureAirport.equals(flight.departureAirport)) return false;
        if (!arrivalAirport.equals(flight.arrivalAirport)) return false;
        if (!status.equals(flight.status)) return false;
        if (!aircraft.equals(flight.aircraft)) return false;
        if (!Objects.equals(actualDeparture, flight.actualDeparture))
            return false;
        if (!Objects.equals(actualArrival, flight.actualArrival))
            return false;
        return ticketFlights.equals(flight.ticketFlights);
    }

    @Override
    public int hashCode() {
        int result = flightId.hashCode();
        result = 31 * result + flightNo.hashCode();
        result = 31 * result + scheduledDeparture.hashCode();
        result = 31 * result + scheduledArrival.hashCode();
        result = 31 * result + departureAirport.hashCode();
        result = 31 * result + arrivalAirport.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + aircraft.hashCode();
        result = 31 * result + (actualDeparture != null ? actualDeparture.hashCode() : 0);
        result = 31 * result + (actualArrival != null ? actualArrival.hashCode() : 0);
        result = 31 * result + ticketFlights.hashCode();
        return result;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public LocalDateTime getScheduledDeparture() {
        return scheduledDeparture;
    }

    public void setScheduledDeparture(LocalDateTime scheduledDeparture) {
        this.scheduledDeparture = scheduledDeparture;
    }

    public LocalDateTime getScheduledArrival() {
        return scheduledArrival;
    }

    public void setScheduledArrival(LocalDateTime scheduledArrival) {
        this.scheduledArrival = scheduledArrival;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public LocalDateTime getActualDeparture() {
        return actualDeparture;
    }

    public void setActualDeparture(LocalDateTime actualDeparture) {
        this.actualDeparture = actualDeparture;
    }

    public LocalDateTime getActualArrival() {
        return actualArrival;
    }

    public void setActualArrival(LocalDateTime actualArrival) {
        this.actualArrival = actualArrival;
    }

    public Set<TicketFlight> getTicketFlights() {
        return ticketFlights;
    }

    public void setTicketFlights(Set<TicketFlight> ticketFlights) {
        this.ticketFlights = ticketFlights;
    }
}