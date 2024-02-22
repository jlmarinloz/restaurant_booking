package com.taqueriaamigo.booking.service;

import com.taqueriaamigo.booking.model.Booking;
import com.taqueriaamigo.booking.persistence.BookingPersistence;
import com.taqueriaamigo.booking.model.BookingSchedule;
import com.taqueriaamigo.booking.utils.BookingConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class to add logic to the processes.
 */
public class BookingService {

    BookingPersistence bookingPersistence = new BookingPersistence();

    /**
     * Create a new booking.
     *
     * @param booking
     */
    public void saveBooking(Booking booking) {
        bookingPersistence.saveBooking(booking);
    }

    /**
     * Get the available times for booking.
     * 4 tables are considered for booking as well as 4 times from 17:00 for booking.
     *
     * @param bookingDay
     * @return a list with the available times for booking.
     */
    public List<String> getAvailableDayBookings(String bookingDay) {
        List<String> availableBookings = new ArrayList<>();
        List<Booking> allDayBookings = bookingPersistence.getBookingByDay(bookingDay);

        Map<BookingSchedule, Integer> bookingsBySchedule = new HashMap<>();
        for (BookingSchedule bookingSchedule : BookingSchedule.values()) {
            bookingsBySchedule.put(bookingSchedule, 0);
        }

        for (Booking booking : allDayBookings) {
            BookingSchedule bookingSchedule = BookingSchedule.getBySchedule(booking.getBookingTime().toString());
            if (bookingSchedule != null) {
                bookingsBySchedule.put(bookingSchedule, bookingsBySchedule.get(bookingSchedule) + 1);
            }
        }

        for (BookingSchedule bookingSchedule : BookingSchedule.values()) {
            int totalBookings = bookingsBySchedule.get(bookingSchedule);
            if (totalBookings != BookingConstants.NUMBER_OF_TABLES) {
                availableBookings.add(bookingSchedule.getSchedule());
            }
        }

        return availableBookings;
    }

    /**
     * Get all bookings for a specific day.
     *
     * @param bookingDay
     * @return a list with all the bookings for a specific day.
     */
    public List<Booking> getBookingByDay(String bookingDay) {
        return bookingPersistence.getBookingByDay(bookingDay);
    }

    /**
     * Get all bookings.
     *
     * @return a list with all the bookings.
     */
    public List<Booking> getAllBookings() {
        return bookingPersistence.getAllBookings();
    }
}
