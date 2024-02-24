package com.hack.selectel.infrastucture.services;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hack.selectel.core.dtos.DonationDto;
import com.hack.selectel.core.mappers.DonationMapper;
import com.hack.selectel.core.repositories.IDonaionRepo;
import com.hack.selectel.core.services.IDonationService;

@Service
public class DonationService implements IDonationService
{
    @Autowired
    IDonaionRepo donaionRepo;

    @Override
    public CompletableFuture<Boolean> CreateDonationPlan(DonationDto donation) 
    {
        return CompletableFuture.completedFuture(donaionRepo.CreateDonation(DonationMapper.AsEntity(donation)));
    }

    @Override
    public CompletableFuture<Boolean> UpdateDonationPlan(DonationDto donation) 
    {
        return CompletableFuture.completedFuture(donaionRepo.UpdateDonation(DonationMapper.AsEntity(donation)));
    }

    @Override
    public CompletableFuture<List<DonationDto>> GetDonationByUser(String username, int page) 
    {
        List<DonationDto> donation = donaionRepo.GetDonationByUser(username, page)
                                        .stream()
                                        .map(DonationMapper::AsDto)
                                        .collect(Collectors.toList());


        return CompletableFuture.completedFuture(donation);
    }

    @Override
    public CompletableFuture<DonationDto> GetDonationPlanById(UUID id) 
    {
        return CompletableFuture.completedFuture(DonationMapper.AsDto(donaionRepo.GetDonationById(id)));
    }

    
    
}
