package com.codelab.LocalStatus;

import com.codelab.LocalStatus.Controller.GeoStatusController;
import com.codelab.LocalStatus.services.GeoStatusServiceImpl;
import com.google.gson.JsonObject;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class LocalStatusApplicationTests {

	@Mock
	private GeoStatusServiceImpl geosStatusService;
	@InjectMocks
	private GeoStatusController controller;

	@Test
	public void testBadRequestLocalStatus() throws IOException {

		Mockito.when(geosStatusService.retrieveGeoStatus()).thenReturn(new JsonObject());
		ResponseEntity<?> response = controller.getGeoStatus();
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}
//	@Test
//	public void testLocalStatus() throws IOException {
//
//
//		Mockito.when(geosStatusService.retrieveGeoStatus()).thenReturn(new JsonObject());
//		ResponseEntity<?> response = controller.getGeoStatus();
//		assertEquals(HttpStatus.OK, response.getStatusCode());
//	}

	@Test
	void contextLoads() {
	}



}
