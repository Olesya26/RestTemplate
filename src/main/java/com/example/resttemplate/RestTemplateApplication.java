package com.example.resttemplate;

import com.example.resttemplate.controller.UserController;
import com.example.resttemplate.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.ResponseEntity;
;

@SpringBootApplication
public class RestTemplateApplication {

    public static void main(String[] args) {
        getCookie(args);
    }

    public static void getCookie(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RestTemplateApplication.class, args);
        UserController userController = context.getBean("userController", UserController.class);
        ResponseEntity<String> allUsers = userController.getAllUsers();
        System.out.println(allUsers);

        ResponseEntity<String> responseEntity = userController.addUser();
        String text = responseEntity.getBody();
        ResponseEntity<String> responseEntity1 = userController.updateUser();
        text += responseEntity1.getBody();
        ResponseEntity<String> responseEntity2 = userController.deleteUser();
        text += responseEntity2.getBody();
        System.out.println(text);
    }


}
