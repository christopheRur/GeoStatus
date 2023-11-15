package com.codelab.LocalStatus.Controller;

import com.codelab.LocalStatus.services.GeoStatusServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class GeoStatusController {
    private final GeoStatusServiceImpl geoStatusService=new GeoStatusServiceImpl();

    @GetMapping("/status")
    public ResponseEntity<?> getGeoStatus() {
        try {
            if (geoStatusService == null) {

                return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("Too many requests");

            } else {


                return new ResponseEntity<>(geoStatusService.retrieveGeoStatus(), HttpStatus.OK);
            }

        } catch (Exception e) {

            log.info("==>" + e.getLocalizedMessage());

            return ResponseEntity.badRequest().body("Error occurred, unable to FETCH data.");
        }
    }

}

