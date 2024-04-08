package com.example.filipedev.application;

import com.example.filipedev.model.ApiConector;
import com.example.filipedev.model.FilteredResponse;
import com.google.gson.JsonObject;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        JsonObject filteredResponse;

        try {
            System.out.print("Digite o CEP que você quer consultar: ");
            String cep = sc.next().replace("-", "").replace(".", "").replace(",", "");

            ApiConector apiConector = new ApiConector();
            JsonObject jsonResponse = apiConector.sendGetRequest(Integer.valueOf(cep));

            FilteredResponse formatter = new FilteredResponse();
            filteredResponse = formatter.formatResponse(jsonResponse);
            System.out.println(filteredResponse.toString());
        } catch (Exception error) {
            System.out.println("CEP Inválido!");
        }

        sc.close();
    }
}
