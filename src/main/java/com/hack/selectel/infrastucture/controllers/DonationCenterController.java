package com.hack.selectel.infrastucture.controllers;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hack.selectel.core.dtos.DonationCenterDto;
import com.hack.selectel.core.models.BloodGroup;
import com.hack.selectel.core.services.IDonationCenterService;

@RestController
@RequestMapping("/donation_center")
public class DonationCenterController 
{
    @Autowired
    IDonationCenterService donationCenterService;

    @GetMapping("/user")
    public ResponseEntity<List<DonationCenterDto>> GetByParams(int cityId, BloodGroup bloodGroup) throws InterruptedException, ExecutionException
    {
        return ResponseEntity.ok(donationCenterService.GetDonationCentersByUserBlood(bloodGroup, cityId).get());
    }

    @GetMapping("/{id}/")
    public ResponseEntity<DonationCenterDto> GetById(@PathVariable("id") int id) throws InterruptedException, ExecutionException
    {
        return ResponseEntity.ok(donationCenterService.DonationCenterById(id).get());
    }

    @GetMapping("/{page}")
    public ResponseEntity<List<DonationCenterDto>> GetByCity(@PathVariable("page") int page, int cityId) throws InterruptedException, ExecutionException
    {
        return ResponseEntity.ok(donationCenterService.GetCentersByCityId(cityId, page).get());
    }
}
