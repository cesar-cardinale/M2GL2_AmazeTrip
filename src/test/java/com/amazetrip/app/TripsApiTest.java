package com.amazetrip.app;

import com.amazetrip.app.model.Trip;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = AmazeTripApplication.class)
public class TripsApiTest {

    @Test
    public void testPutTrips(){
        Trip tripTest = new Trip();
        tripTest.setCreationDate(new java.util.Date());
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api/trips";
        HttpEntity<Trip> request = new HttpEntity<>(tripTest);
        var m = restTemplate.postForObject(url, request, Trip.class);
        assertNotNull(m);
        assertEquals(m.getId(),4);
    }

    @Test
    public void testGetTrips(){
        Trip tripTest = new Trip();
        tripTest.setCreationDate(new java.util.Date());
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api/trips";
        ResponseEntity<Iterable> response
                = restTemplate.getForEntity(url, Iterable.class);
        System.out.println(response.getBody().toString());
        assertEquals(response.getStatusCodeValue(), 200);
    }

    @Test
    public void testGetTripById(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api/trips/"+1;
        var m = restTemplate.getForEntity(url,Trip.class);
        System.out.println(m.getBody().getId());
        assertEquals(m.getBody().getId(),1);
    }
}
