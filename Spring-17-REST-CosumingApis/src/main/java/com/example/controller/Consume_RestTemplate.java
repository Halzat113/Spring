package com.example.controller;

import com.example.dto.User;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/users")
public class Consume_RestTemplate {

    private final String URI = "https://jsonplaceholder.typicode.com/users";

    private final RestTemplate restTemplate;

    public Consume_RestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public User[] readAllUsers(){
        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity(URI,User[].class);

        return responseEntity.getBody();
    }

    @GetMapping("{id}")
    public Object readUser(@PathVariable("id") Integer id){
        String URL = URI + "/{id}";
        return restTemplate.getForObject(URL,Object.class,id);
    }

    @GetMapping("/test")
    public ResponseEntity<Object> consumeFromDummyApi(){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.set("app-id","6599c49b8b3a76d80a554467");

        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Object> response =restTemplate.exchange("https://dummyapi.io/data/v1/user?limit=10",
                HttpMethod.GET,entity,Object.class);

        return response;
    }
}
