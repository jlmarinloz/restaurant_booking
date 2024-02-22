package com.taqueriaamigo.booking.resource;

import com.taqueriaamigo.booking.model.Booking;
import com.taqueriaamigo.booking.service.BookingService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Class to manage the Booking with apis.
 *
 */
@Path("/booking")
public class BookingResource {

    BookingService bookingService = new BookingService();

    /**
     * Create a new booking.
     *
     * @param booking
     * @return a confirmation message.
     */
    @POST
    @Path("/save")
    @Consumes("application/json")
    @Produces("text/plain")
    public String saveBooking(Booking booking) {
        bookingService.saveBooking(booking);
        return "Your booking has been successfully saved!!!";
    }

    /**
     * Get the available times for booking.
     *
     * @param bookingDay
     * @return a list with the available times for booking.
     */
    @GET
    @Path("/available/{bookingDay}")
    @Produces("application/json")
    public List<String> getAvailableDayBookings(@PathParam("bookingDay") String bookingDay) {
        return bookingService.getAvailableDayBookings(bookingDay);
    }

    /**
     * Get all bookings for a specific day.
     *
     * @param bookingDay
     * @return a list with all the bookings for a specific day.
     */
    @GET
    @Path("/{bookingDay}")
    @Produces("application/json")
    public List<Booking> getBookingByDay(@PathParam("bookingDay") String bookingDay) {
        return bookingService.getBookingByDay(bookingDay);
    }

    /**
     * Get all bookings.
     *
     * @return a list with all the bookings.
     */
    @GET
    @Path("/all")
    @Produces("application/json")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }
}
