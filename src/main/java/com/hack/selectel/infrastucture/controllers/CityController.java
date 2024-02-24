package com.hack.selectel.infrastucture.controllers;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hack.selectel.core.dtos.CityDto;
import com.hack.selectel.core.services.ICityService;

@RequestMapping("/city")
@RestController
public class CityController 
{
    @Autowired
    ICityService cityService;

    public ResponseEntity<List<CityDto>> GetUserByList(String cityName) throws InterruptedException, ExecutionException
    {
        return ResponseEntity.ok(cityService.FindCityByName(cityName).get());
    } 
}
