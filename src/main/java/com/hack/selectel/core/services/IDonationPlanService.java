package com.hack.selectel.core.services;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import com.hack.selectel.core.dtos.DonationPlanDto;


public interface IDonationPlanService 
{
    public CompletableFuture<Boolean> CreateDonationPlan(DonationPlanDto donationPlanDto);
    public CompletableFuture<Boolean> UpdateDonationPlan(DonationPlanDto donationPlanDto);    
    public CompletableFuture<List<DonationPlanDto>> GetDonationByUser(String username, int page);
    public CompletableFuture<DonationPlanDto> GetDonationPlanById(UUID id);
}
