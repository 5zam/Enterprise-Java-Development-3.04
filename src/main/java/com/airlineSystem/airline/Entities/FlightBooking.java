package com.airlineSystem.airline.Entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tbl_flightBooking")
public class FlightBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private Customer customerId;

    @ManyToOne
    @JoinColumn(name = "flightId", referencedColumnName = "flightId")
    private Flight flightId;


    public FlightBooking() {
    }

    @Override
    public String toString() {
        return "FlightBooking{" +
                "bookingId=" + bookingId +
                ", customerId=" + customerId +
                ", flightId=" + flightId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightBooking that = (FlightBooking) o;
        return bookingId == that.bookingId && Objects.equals(customerId, that.customerId) && Objects.equals(flightId, that.flightId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, customerId, flightId);
    }

    public FlightBooking(int bookingId, Customer customerId, Flight flightId) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.flightId = flightId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Flight getFlightId() {
        return flightId;
    }

    public void setFlightId(Flight flightId) {
        this.flightId = flightId;
    }
}
