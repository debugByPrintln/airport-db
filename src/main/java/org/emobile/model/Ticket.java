package org.emobile.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tickets", schema = "bookings")
public class Ticket {

    @Id
    @Column(name = "ticket_no", length = 13)
    private String ticketNo;

    @ManyToOne
    @JoinColumn(name = "book_ref", nullable = false)
    private Booking booking;

    @Column(name = "passenger_id", length = 20, nullable = false)
    private String passengerId;

    @Column(name = "passenger_name", nullable = false)
    private String passengerName;

    @Column(name = "contact_data")
    private String contactData;

    @OneToMany(mappedBy = "ticket")
    private Set<TicketFlight> ticketFlights;

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getContactData() {
        return contactData;
    }

    public void setContactData(String contactData) {
        this.contactData = contactData;
    }

    public Set<TicketFlight> getTicketFlights() {
        return ticketFlights;
    }

    public void setTicketFlights(Set<TicketFlight> ticketFlights) {
        this.ticketFlights = ticketFlights;
    }
}
