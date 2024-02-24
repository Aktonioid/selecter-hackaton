package com.hack.selectel.infrastucture.services;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hack.selectel.core.dtos.DonationPlanDto;
import com.hack.selectel.core.mappers.DonationPlanMapper;
import com.hack.selectel.core.repositories.IDonationPlanRepo;
import com.hack.selectel.core.services.IDonationPlanService;

@Service
public class DonationPlanService implements IDonationPlanService
{
    @Autowired
    IDonationPlanRepo donationPlanRepo;

    @Override
    public CompletableFuture<Boolean> CreateDonationPlan(DonationPlanDto donation) 
    {
        return CompletableFuture.completedFuture(donationPlanRepo.CreateDonationPlan(DonationPlanMapper.AsEntity(donation)));
    }

    @Override
    public CompletableFuture<Boolean> UpdateDonationPlan(DonationPlanDto donation) 
    {
        return CompletableFuture.completedFuture(donationPlanRepo.UpdateDonationPlan(DonationPlanMapper.AsEntity(donation)));
    }

    @Override
    public CompletableFuture<List<DonationPlanDto>> GetDonationByUser(String username, int page) 
    {
        List<DonationPlanDto> donation = donationPlanRepo.GetDonationByUser(username, page)
                                        .stream()
                                        .map(DonationPlanMapper::AsDto)
                                        .collect(Collectors.toList());


        return CompletableFuture.completedFuture(donation);
    }

    @Override
    public CompletableFuture<DonationPlanDto> GetDonationPlanById(UUID id) 
    {
        return CompletableFuture.completedFuture(DonationPlanMapper.AsDto(donationPlanRepo.GetDonationById(id)));
    }
    
}
