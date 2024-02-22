package com.taqueriaamigo.booking.persistence;

import com.taqueriaamigo.booking.model.Booking;
import com.taqueriaamigo.booking.utils.BookingCreator;
import com.taqueriaamigo.booking.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to simulate DB calls.
 */
public class BookingPersistence {

    private List<Booking> bookingList;

    public BookingPersistence() {
        bookingList = BookingCreator.createBookings();
    }

    /**
     * Add a booking to the existing list.
     *
     * @param booking
     */
    public void saveBooking(Booking booking) {
        bookingList.add(booking);
    }

    /**
     * Get all bookings for a specific day.
     *
     * @param bookingDay
     * @return a list with all the bookings for a specific day.
     */
    public List<Booking> getBookingByDay(String bookingDay) {
        List<Booking> bookingListByDay = new ArrayList<>();
        for (Booking booking : bookingList) {
            if (booking.getBookingDate().isEqual(DateUtils.createBookingDate(bookingDay))) {
                bookingListByDay.add(booking);
            }
        }
        return bookingListByDay;
    }

    /**
     * Get all bookings.
     *
     * @return a list with all the bookings.
     */
    public List<Booking> getAllBookings() {
        return bookingList;
    }
}
