package com.example.filipedev.application;

import com.example.filipedev.application.model.FilteredResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;

public class App {

	public static void main(String[] args) {

		String inputLine;

		try {
			URL url = new URL("http://viacep.com.br/ws/72010040/json/");

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			JsonObject jsonResponse = JsonParser.parseString(response.toString()).getAsJsonObject();

			JsonObject filteredResponse = FilteredResponse.formatCPF(jsonResponse);

			System.out.println(filteredResponse.toString());

			connection.disconnect();
		} catch (Exception e) {
          e.printStackTrace();
      }
   }
}
