package org.emobile.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "bookings", schema = "bookings")
public class Booking {

    @Id
    @Column(name = "book_ref", length = 6)
    private String bookRef;

    @Column(name = "book_date", nullable = false)
    private LocalDateTime bookDate;

    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    @OneToMany(mappedBy = "booking")
    private Set<Ticket> tickets;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booking booking = (Booking) o;

        if (!bookRef.equals(booking.bookRef)) return false;
        if (!bookDate.equals(booking.bookDate)) return false;
        if (!totalAmount.equals(booking.totalAmount)) return false;
        return tickets.equals(booking.tickets);
    }

    @Override
    public int hashCode() {
        int result = bookRef.hashCode();
        result = 31 * result + bookDate.hashCode();
        result = 31 * result + totalAmount.hashCode();
        result = 31 * result + tickets.hashCode();
        return result;
    }

    public String getBookRef() {
        return bookRef;
    }

    public void setBookRef(String bookRef) {
        this.bookRef = bookRef;
    }

    public LocalDateTime getBookDate() {
        return bookDate;
    }

    public void setBookDate(LocalDateTime bookDate) {
        this.bookDate = bookDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
