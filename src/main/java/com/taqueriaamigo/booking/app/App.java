package com.taqueriaamigo.booking.app;

import com.taqueriaamigo.booking.client.BookingPage;
import com.taqueriaamigo.booking.server.MuServer;

/**
 * Class to tests.
 */
public class App {

    /**
     * Main method to init the app.
     * @param args
     */
    public static void main(final String[] args) {
        MuServer.initServer();
        BookingPage.createBooking();
    }

}
