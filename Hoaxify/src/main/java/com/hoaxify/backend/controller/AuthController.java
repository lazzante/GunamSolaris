package com.hoaxify.backend.controller;

import com.hoaxify.backend.errors.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {


    @PostMapping("/api/auth")
    ResponseEntity<Object> handleAuthentication(@RequestHeader(name = "Authorization",required = false)String auth){

}
