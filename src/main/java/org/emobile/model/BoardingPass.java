package org.emobile.model;

import jakarta.persistence.*;

@Entity
@Table(name = "boarding_passes", schema = "bookings")
public class BoardingPass {

    @EmbeddedId
    private BoardingPassId id;

    @ManyToOne
    @MapsId("ticketNo")
    @JoinColumn(name = "ticket_no", nullable = false)
    private Ticket ticket;

    @ManyToOne
    @MapsId("flightId")
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    @Column(name = "boarding_no", nullable = false)
    private Integer boardingNo;

    @Column(name = "seat_no", length = 4, nullable = false)
    private String seatNo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoardingPass that = (BoardingPass) o;

        if (!id.equals(that.id)) return false;
        if (!ticket.equals(that.ticket)) return false;
        if (!flight.equals(that.flight)) return false;
        if (!boardingNo.equals(that.boardingNo)) return false;
        return seatNo.equals(that.seatNo);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + ticket.hashCode();
        result = 31 * result + flight.hashCode();
        result = 31 * result + boardingNo.hashCode();
        result = 31 * result + seatNo.hashCode();
        return result;
    }

    public BoardingPassId getId() {
        return id;
    }

    public void setId(BoardingPassId id) {
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

    public Integer getBoardingNo() {
        return boardingNo;
    }

    public void setBoardingNo(Integer boardingNo) {
        this.boardingNo = boardingNo;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }
}
