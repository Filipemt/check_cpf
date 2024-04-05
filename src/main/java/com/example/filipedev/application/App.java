package com.example.filipedev.application;

import com.example.filipedev.model.ApiConector;
import com.example.filipedev.model.FilteredResponse;
import com.google.gson.JsonObject;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Digite o CEP que você quer consultar: ");
		int cep = sc.nextInt();

		try {
			ApiConector apiConector = new ApiConector();
			JsonObject jsonResponse = apiConector.sendGetRequest(cep);

			FilteredResponse formatter = new FilteredResponse();
			JsonObject filteredResponse = formatter.formatResponse(jsonResponse);

			System.out.println(filteredResponse.toString());

		} catch (Exception e) {
          e.printStackTrace();
      }
		sc.close();
   }
}
