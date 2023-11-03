package com.codelab.LocalStatus.services;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
@Slf4j
@Service
public class GeoStatusServiceImpl implements GeoStatusService {
    /**
     *Method retrieve Location information
     * @return
     * @throws IOException
     */
    @Override
    public JsonObject  retrieveGeoStatus() throws IOException {
        URL ipapi = new URL("https://ipapi.co/json/");

        URLConnection conn = ipapi.openConnection();
        conn.setRequestProperty("User-Agent", "java-ipapi-v1.02");
        BufferedReader reader =new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();

        String data;
        while ((data = reader.readLine()) != null) {
            response.append(data);
            log.info("GeoStatus =======> {}",data);
        }

        reader.close();
        // Parse the JSON response
        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(response.toString());

        if (jsonElement.isJsonObject()) {
            return jsonElement.getAsJsonObject();
        } else {
            // Handle the case where the response is not a JSON object
            log.error("Invalid JSON response: {}", response.toString());
            return null;
        }
    }
}
