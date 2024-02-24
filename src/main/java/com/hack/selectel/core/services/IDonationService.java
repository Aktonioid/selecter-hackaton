package com.hack.selectel.core.services;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import com.hack.selectel.core.dtos.DonationDto;

public interface IDonationService 
{
    public CompletableFuture<Boolean> CreateDonationPlan(DonationDto donation);
    public CompletableFuture<Boolean> UpdateDonationPlan(DonationDto donation);    
    public CompletableFuture<List<DonationDto>> GetDonationByUser(String username, int page);
    public CompletableFuture<DonationDto> GetDonationPlanById(UUID id);    
}
