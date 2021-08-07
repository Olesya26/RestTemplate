//package com.example.resttemplate;
//
//import com.example.resttemplate.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.*;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Arrays;
//
//
//public class Controller {
//    static final String URL_USERS = "http://91.241.64.178:7081/api/users";
//    static final String URL_USERS_DELETE = "http://91.241.64.178:7081/api/users/{id}";
//
//
//    public String allUsers(){
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
//
//        ResponseEntity<String> responseEntity = restTemplate.exchange(URL_USERS, HttpMethod.GET, entity, String.class);
//
//        HttpHeaders cookie = responseEntity.getHeaders();
////        return cookie.getFirst("Set-Cookie");
//    }
//    public void createUser(String cookie){
//        RestTemplate restTemplate = new RestTemplate();
//        User user = new User(3L,"James", "Brown", (byte)30);
//
//        HttpHeaders headers2 = new HttpHeaders();
//        headers2.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        headers2.set("Cookie", cookie);
//        HttpEntity<User> entity = new HttpEntity<>(user, headers2);
//
//
//        ResponseEntity<String> responseEntity = restTemplate.exchange(URL_USERS, HttpMethod.POST, entity, String.class);
//        System.out.println(responseEntity);
//    }
//}
