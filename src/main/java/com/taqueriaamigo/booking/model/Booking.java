package com.taqueriaamigo.booking.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Model of a booking.
 */
public class Booking {

    private Customer customer;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate bookingDate;
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    @JsonSerialize(using = LocalTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime bookingTime;
    private int numberAttendees;

    public Booking() {
    }

    public Booking(Customer customer, LocalDate bookingDate, LocalTime bookingTime, int numberAttendees) {
        this.customer = customer;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.numberAttendees = numberAttendees;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public int getNumberAttendees() {
        return numberAttendees;
    }

    public void setNumberAttendees(int numberAttendees) {
        this.numberAttendees = numberAttendees;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Booking{");
        sb.append("customer=").append(customer);
        sb.append(", bookingDate=").append(bookingDate);
        sb.append(", bookingTime=").append(bookingTime);
        sb.append(", numberAttendees=").append(numberAttendees);
        sb.append('}');
        return sb.toString();
    }
}
