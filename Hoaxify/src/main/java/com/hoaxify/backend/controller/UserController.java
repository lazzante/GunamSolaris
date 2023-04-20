package com.hoaxify.backend.controller;

import com.hoaxify.backend.entities.User;
import com.hoaxify.backend.errors.ApiError;
import com.hoaxify.backend.repositories.UserRepository;
import com.hoaxify.backend.services.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {

    private final UserService userService;


    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<?> createUser(@RequestBody User user){
        String username = user.getUsername();
        if(username==null || username.isEmpty()){
            ApiError error = new ApiError(400,"Username Can't Be Null !","/api/add");
            Map<String,String> validationErrors = new HashMap<>();
            validationErrors.put("usernameError","Username Can't Be Null !");
            error.setValidationErrors(validationErrors);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
        String displayName = user.getDisplayName();
        if(displayName==null || displayName.isEmpty()){
            ApiError error = new ApiError(400,"Display Name Can't Be Null !","/api/add");
            Map<String,String> validationErrors = new HashMap<>();
            validationErrors.put("displayNameError","Display Name Can't Be Null !");
            error.setValidationErrors(validationErrors);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
        String password = user.getPassword();
        if(password==null||password.isEmpty()){
            ApiError error  = new ApiError(400,"Password Can't Be Null !","/api/add");
            Map<String,String> validationErrors = new HashMap<>();
            validationErrors.put("passwordError","Password Can't Be Null!");
            error.setValidationErrors(validationErrors);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
        String passwordRepeat = user.getPasswordRepeat();
        if(passwordRepeat==null||passwordRepeat.isEmpty()){
            ApiError error = new ApiError(400,"Password Repeat Can't Be Null !","/api/add");
            Map<String,String> validationErrors = new HashMap<>();
            validationErrors.put("passwordRepeatError","Password Repeat Can't Be Null !");
            error.setValidationErrors(validationErrors);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }



        userService.createUser(user);
        return ResponseEntity.ok("User Saved Database Successfully(Backend)");
    }


}
