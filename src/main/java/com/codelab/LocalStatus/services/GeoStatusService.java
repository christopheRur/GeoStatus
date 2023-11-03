package com.codelab.LocalStatus.services;

import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public interface GeoStatusService {

    public JsonObject retrieveGeoStatus() throws IOException;
}
