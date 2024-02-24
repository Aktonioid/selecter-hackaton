package com.hack.selectel.infrastucture.controllers;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hack.selectel.core.dtos.DonationDto;
import com.hack.selectel.core.services.IDonationService;

@RestController
@RequestMapping("/donation")
public class DonationController 
{
    @Autowired
    IDonationService donationService;


    @GetMapping("/{id}")
    public ResponseEntity<DonationDto> GetDonation(UUID id) throws InterruptedException, ExecutionException
    {
        return ResponseEntity.ok(donationService.GetDonationPlanById(id).get());
    }

    @GetMapping("/")
    public ResponseEntity<List<DonationDto>> GetDonationByUser(String username, int page) throws InterruptedException, ExecutionException
    {
        return ResponseEntity.ok(donationService.GetDonationByUser(username, page).get());
    }

    public ResponseEntity<String> CreateDonation(DonationDto donation) throws InterruptedException, ExecutionException
    {
        if(!donationService.CreateDonationPlan(donation).get())
        {
            return new ResponseEntity<>(HttpStatus.INSUFFICIENT_STORAGE);
        }

        return ResponseEntity.ok("ok");
    }

    public ResponseEntity<String> UpdateDonation(DonationDto donation) throws InterruptedException, ExecutionException
    {
        if(!donationService.UpdateDonationPlan(donation).get())
        {
            return new ResponseEntity<>(HttpStatus.INSUFFICIENT_STORAGE);
        }

        return ResponseEntity.ok("ok");
        
    }    
}
