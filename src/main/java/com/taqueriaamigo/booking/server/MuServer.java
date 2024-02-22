package com.taqueriaamigo.booking.server;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.taqueriaamigo.booking.resource.BookingResource;
import io.muserver.MuServerBuilder;
import io.muserver.rest.RestHandlerBuilder;

/**
 * Class to manage the MuServer.
 */
public final class MuServer {

    private MuServer() {}

    /**
     * Configure and start the server in the 9443 port.
     */
    public static void initServer() {
        MuServerBuilder.httpServer()
                .withHttpPort(9443)
                .addHandler(RestHandlerBuilder.restHandler(new BookingResource())
                        .addCustomWriter(new JacksonJaxbJsonProvider())
                        .addCustomReader(new JacksonJaxbJsonProvider())
                )
                .start();
    }
}
