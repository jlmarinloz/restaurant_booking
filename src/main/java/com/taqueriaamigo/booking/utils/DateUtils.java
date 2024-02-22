package com.taqueriaamigo.booking.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility class related to dates.
 */
public final class DateUtils {

    private DateUtils() {}

    /**
     * Creates a LocalDate from String.
     *
     * @param date
     * @return bookingDate
     */
    public static LocalDate createBookingDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    /**
     * Creates a LocalTime from String.
     *
     * @param time
     * @return bookingTime
     */
    public static LocalTime createBookingTime(String time) {
        return LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
    }

}
