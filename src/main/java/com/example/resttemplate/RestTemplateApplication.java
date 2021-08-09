package com.example.resttemplate;

import com.example.resttemplate.controller.UserController;
import com.example.resttemplate.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.ResponseEntity;
;import java.util.HashMap;
import java.util.Map;

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

        User user = new User(3L,"James", "Brown", (byte)30);
        ResponseEntity<String> responseEntity = userController.addUser(user);
        String text = responseEntity.getBody();

        User userUpdate = new User(3L, "Thomas", "Shelby", (byte) 40);
        ResponseEntity<String> responseEntity1 = userController.updateUser(userUpdate);
        text += responseEntity1.getBody();

        Map<String, Long> params = new HashMap<>();
        params.put("id", 3L);
        ResponseEntity<String> responseEntity2 = userController.deleteUser(params);
        text += responseEntity2.getBody();

        System.out.println(text);
    }


}
