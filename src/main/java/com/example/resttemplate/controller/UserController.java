package com.example.resttemplate.controller;

import com.example.resttemplate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class UserController {
    public RestTemplate restTemplate;
    public HttpHeaders headers;
    static final String URL_USERS = "http://91.241.64.178:7081/api/users";
    static final String DELETE_URL_USERS = "http://91.241.64.178:7081/api/users/{id}";


    @Autowired
    public UserController(RestTemplate restTemplate, HttpHeaders headers) {
        this.restTemplate = restTemplate;
        this.headers = headers;
        this.headers.set("Cookie", String.join(";", Objects.requireNonNull(restTemplate.headForHeaders(URL_USERS)
                .get("Set-Cookie"))));
    }

    public ResponseEntity<String> getAllUsers() {
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        return restTemplate.exchange(URL_USERS, HttpMethod.GET, entity, String.class);

    }

    public ResponseEntity<String> addUser(User user) {
        HttpEntity<User> entity = new HttpEntity<>(user, headers);
        return restTemplate.exchange(URL_USERS, HttpMethod.POST, entity, String.class);
    }

    public ResponseEntity<String> updateUser(User userUpdate) {
        HttpEntity<User> entity = new HttpEntity<>(userUpdate, headers);
        return restTemplate.exchange(URL_USERS, HttpMethod.PUT, entity, String.class);

    }

    public ResponseEntity<String> deleteUser(Map<String, Long> params) {
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(DELETE_URL_USERS, HttpMethod.DELETE, entity, String.class,params);
    }
}
