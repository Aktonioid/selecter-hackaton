package com.hack.selectel.infrastucture.controllers;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hack.selectel.core.dtos.UserModelDto;
import com.hack.selectel.infrastucture.services.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/user")
public class UserController 
{
    @Autowired
    UserService service;
    
    @PutMapping("/")
    public ResponseEntity<String> UpdateUser(@RequestBody UserModelDto userModelDto) throws InterruptedException, ExecutionException
    {
        if(!service.UpdateUser(userModelDto).get())
        {
            return new ResponseEntity<>(HttpStatus.INSUFFICIENT_STORAGE);
        }

        return ResponseEntity.ok("updated");
    }

    @GetMapping("/")
    public ResponseEntity<UserModelDto> GetUserByUserName(String username) throws InterruptedException, ExecutionException
    {
        return ResponseEntity.ok(service.GetUserByUsername(username).get());
    }

}
