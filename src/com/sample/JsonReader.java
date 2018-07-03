package com.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.dto.RestResponseDTO;

public class JsonReader {

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	public static void main(String[] args) throws IOException, JSONException {

		/**
		 * 1st way of doing using Jackson objectMapping
		 * 
		 * 
		 */
		
		JSONObject json = readJsonFromUrl("http://services.groupkt.com/country/get/all");
		ObjectMapper mapper = new ObjectMapper();
		RestResponseDTO response = mapper.readValue(json.toString(), RestResponseDTO.class);
		System.out.println(response);
		
		/**
		 * 2nd way of doing 
		 * we use the object
		 *  
		 */
		/*JSONObject jsons = (JSONObject) json.get("RestResponse");
		JSONArray ja = (JSONArray) jsons.get("result");

		for (int i = 0; i < ja.length(); i++) {
			JSONObject objects = ja.getJSONObject(i);
			System.out.println("name >>> " + objects.get("name"));
		}*/

	}
}
