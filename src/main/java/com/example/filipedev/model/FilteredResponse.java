package com.example.filipedev.model;

import com.google.gson.JsonObject;

public class FilteredResponse {
    public static JsonObject formatResponse(JsonObject jsonResponse) {
        JsonObject filteredResponse = new JsonObject();

        filteredResponse.addProperty("cep", jsonResponse.get("cep").getAsString());
        filteredResponse.addProperty("uf", jsonResponse.get("uf").getAsString());
        filteredResponse.addProperty("bairro", jsonResponse.get("bairro").getAsString());

        return filteredResponse;
    }
}
