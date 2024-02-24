package com.hack.selectel.infrastucture.controllers;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hack.selectel.core.dtos.DonationPlanDto;
import com.hack.selectel.core.services.IDonationPlanService;

@RestController
@RequestMapping("/donations_plans")
public class DonationPlanController 
{
    @Autowired
    IDonationPlanService donationPlanService;

    public ResponseEntity<DonationPlanDto> GetDonationPlan(UUID id) throws InterruptedException, ExecutionException
    {
        return ResponseEntity.ok(donationPlanService.GetDonationPlanById(id).get());
    }

    public ResponseEntity<List<DonationPlanDto>> GetDonationByUser(String username, int page) throws InterruptedException, ExecutionException
    {
        return ResponseEntity.ok(donationPlanService.GetDonationByUser(username, page).get());
    }

    public ResponseEntity<String> CreateDonationPlan(DonationPlanDto donation) throws InterruptedException, ExecutionException
    {
        if(!donationPlanService.CreateDonationPlan(donation).get())
        {
            return new ResponseEntity<>(HttpStatus.INSUFFICIENT_STORAGE);
        }

        return ResponseEntity.ok("ok");
    }

    public ResponseEntity<String> UpdateDonationPlan(DonationPlanDto donation) throws InterruptedException, ExecutionException
    {
        if(!donationPlanService.UpdateDonationPlan(donation).get())
        {
            return new ResponseEntity<>(HttpStatus.INSUFFICIENT_STORAGE);
        }

        return ResponseEntity.ok("ok");
        
    }
}
