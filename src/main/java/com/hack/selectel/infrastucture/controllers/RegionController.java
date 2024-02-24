package com.hack.selectel.infrastucture.controllers;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hack.selectel.core.dtos.RegionDto;
import com.hack.selectel.infrastucture.services.RegionService;

@RestController
@RequestMapping("/region")
public class RegionController 
{
    @Autowired
    RegionService regionService;

    @GetMapping("/{id}")
    public ResponseEntity<RegionDto> GetRegionById(@PathVariable("id") int id) throws InterruptedException, ExecutionException
    {
        return ResponseEntity.ok(regionService.GetRegionById(id).get());
    }

    @GetMapping("/")
    public ResponseEntity<List<RegionDto>> GetAllRegions(int page) throws InterruptedException, ExecutionException
    {
        return ResponseEntity.ok(regionService.GetAllRegions(page).get());
    } 

}
