package com.example.filipedev.model;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiConector {

    private Integer cep;
    public JsonObject sendGetRequest(Integer cep) throws Exception {
        String inputLine;

        URL url = new URL("http://viacep.com.br/ws/" + cep + "/json/");
        HttpURLConnection conection = (HttpURLConnection) url.openConnection();
        conection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return JsonParser.parseString(response.toString()).getAsJsonObject();
    }
}
