package com.taqueriaamigo.booking.client;

import com.taqueriaamigo.booking.model.Booking;
import com.taqueriaamigo.booking.model.Customer;
import com.taqueriaamigo.booking.utils.DateUtils;
import org.json.JSONObject;

import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Class to simulate an application interface.
 */
public final class BookingPage {

    private BookingPage() {}

    /**
     * Method to simulate a page to create a booking.
     */
    public static String createBooking() {
        System.out.println("Welcome to Taquería El Amigo!");
        System.out.println("Please enter the following information to add a booking:");

        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();
        Booking booking = new Booking();

        System.out.println("Customer name:");
        customer.setName(scanner.nextLine());

        System.out.println("Customer last name:");
        customer.setLastName(scanner.nextLine());

        System.out.println("Date of booking (yyyy-MM-dd):");
        LocalDate bookingDate = DateUtils.createBookingDate(scanner.nextLine());
        booking.setBookingDate(bookingDate);
        HttpResponse<String> availableResponse = HttpClient.makeRequest("/available/" + bookingDate.toString(),
                null);
        System.out.println("Available timetables for booking selection: " + availableResponse.body());

        System.out.println("Enter your booking time (HH:mm):");
        booking.setBookingTime(DateUtils.createBookingTime(scanner.nextLine()));

        System.out.println("Number of attendees:");
        booking.setNumberAttendees(Integer.parseInt(scanner.nextLine()));

        booking.setCustomer(customer);

        HttpResponse<String> saveResponse = HttpClient.makeRequest("/save", new JSONObject(booking).toString());
        System.out.println(saveResponse.body());

        System.out.println("Booking date to be consulted (yyyy-MM-dd):");
        String bookingDateToConsult = scanner.nextLine();
        HttpResponse<String> bookingDateConsultResponse = HttpClient.makeRequest("/" + bookingDateToConsult,
                null);
        System.out.println("Bookings from " + bookingDateToConsult + ": " + bookingDateConsultResponse.body());

        HttpResponse<String> allBookingResponse = HttpClient.makeRequest("/all", null);
        System.out.println("All bookings: " + allBookingResponse.body());

        return "Process successfully completed";
    }
}
