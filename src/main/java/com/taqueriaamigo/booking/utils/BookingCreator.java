package com.taqueriaamigo.booking.utils;

import com.taqueriaamigo.booking.model.Booking;
import com.taqueriaamigo.booking.model.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to add some data to the start values.
 */
public final class BookingCreator {

    private BookingCreator() {
    }

    /**
     * Creates a default booking list.
     *
     * @return default booking list to tests.
     */
    public static List<Booking> createBookings() {
        List<Booking> bookingList = new ArrayList<>();
        bookingList.add(createBooking("Jairo", "Benitez", "2024-02-22",
                "19:00", 4));
        bookingList.add(createBooking("Pedro", "Pascal", "2024-02-22",
                "19:00", 3));
        bookingList.add(createBooking("Julio", "Hernandez", "2024-02-22",
                "19:00", 2));
        bookingList.add(createBooking("Ely", "Escamilla", "2024-02-22",
                "19:00", 1));
        bookingList.add(createBooking("Jose", "Marin", "2024-02-22",
                "21:00", 3));
        bookingList.add(createBooking("Alicia", "Lopez", "2024-02-23",
                "17:00", 2));

        return bookingList;
    }

    /**
     * Method to creates bookings.
     *
     * @param customerName
     * @param customerLastName
     * @param bookingDate
     * @param bookingTime
     * @param numberAttendees
     * @return a booking
     */
    private static Booking createBooking(String customerName, String customerLastName, String bookingDate,
                                        String bookingTime, int numberAttendees) {
        Customer customer = new Customer(customerName, customerLastName);
        return new Booking(customer, DateUtils.createBookingDate(bookingDate), DateUtils.createBookingTime(bookingTime),
                numberAttendees);
    }
}
