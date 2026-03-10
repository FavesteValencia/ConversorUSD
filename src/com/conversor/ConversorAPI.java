package com.conversor;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConversorAPI {
    public static double obtenerTasa(String base, String destino) {

        String apiKey = "e400a5a4c38b2b9af5d07759";

        String url = "https://v6.exchangerate-api.com/v6/" + apiKey +
                "/pair/" + base + "/" + destino;

        try {

            HttpClient cliente = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    cliente.send(request, HttpResponse.BodyHandlers.ofString());

            JsonElement elemento = JsonParser.parseString(response.body());

            JsonObject objeto = elemento.getAsJsonObject();

            return objeto.get("conversion_rate").getAsDouble();

        } catch (Exception e) {

            System.out.println("Error al obtener datos de la API");

            return 0;
        }
    }
}

