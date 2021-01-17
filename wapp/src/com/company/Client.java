package com.company;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.*;

public class Client {
    private final String response;

    Client(String name) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String APIKey = "8fae25d804682350073f20b2f93cce02";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://api.openweathermap.org/data/2.5/weather?q=" + name + "&appid=" + APIKey))
                .build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        this.response = response.body();
    }

    public String getResponse() {
        return response;
    }
}
