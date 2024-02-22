package com.taqueriaamigo.booking.client;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

/**
 * Class that simulates a client to consume apis.
 */
public final class HttpClient {

    private HttpClient() {
    }

    /**
     * Method to make request to the apis.
     *
     * @param endpoint
     * @param jsonData
     * @return the HttpResponse
     */
    public static HttpResponse<String> makeRequest(String endpoint, String jsonData) {
        final String API_URL = "http://localhost:9443/booking";
        java.net.http.HttpClient httpClient = java.net.http.HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + endpoint))
                .build();
        if (jsonData != null) {
            httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL + endpoint))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonData, StandardCharsets.UTF_8))
                    .build();
        }

        HttpResponse<String> httpResponse = null;
        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return httpResponse;
    }
}
