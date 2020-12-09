package com.microservice.consume.controler;

import com.microservice.consume.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class ConsumeWebService {

    List<Car> carList;

    @Autowired
    RestTemplate restTemplate;

    // Get
    @RequestMapping(value = "/test")
    public String getCarList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("http://localhost:8081/cars", HttpMethod.GET, entity, String.class).getBody();
    }


    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String createCar(@RequestBody Car car) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Car> entity = new HttpEntity<Car>(car,headers);

        return restTemplate.exchange("http://localhost:8081/cars", HttpMethod.POST, entity, String.class).getBody();
    }

    @RequestMapping(value = "/test/{id}", method = RequestMethod.PUT)
    public String updateCar(@PathVariable("id") int id, @RequestBody Car car) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Car> entity = new HttpEntity<Car>(car,headers);

        return restTemplate.exchange("http://localhost:8081/cars/"+id, HttpMethod.PUT, entity, String.class).getBody();
    }

    @RequestMapping(value = "/test/{id}", method = RequestMethod.DELETE)
    public String deleteCar(@PathVariable("id") int id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Car> entity = new HttpEntity<Car>(headers);

        return restTemplate.exchange(
                "http://localhost:8081/cars/"+id, HttpMethod.DELETE, entity, String.class).getBody();
    }

    @RequestMapping(value = "/test/{id}")
    public String getCarById(@PathVariable("id") int id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("http://localhost:8081/cars/"+id, HttpMethod.GET, entity, String.class).getBody();
    }

}
