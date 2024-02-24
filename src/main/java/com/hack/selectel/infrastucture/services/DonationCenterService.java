package com.hack.selectel.infrastucture.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hack.selectel.core.dtos.DonationCenterDto;
import com.hack.selectel.core.mappers.DonationCenterModelMapper;
import com.hack.selectel.core.models.BloodGroup;
import com.hack.selectel.core.models.DonationCenter;
import com.hack.selectel.core.repositories.IDonationCenterRepo;
import com.hack.selectel.core.services.IDonationCenterService;

@Service
public class DonationCenterService implements IDonationCenterService
{

    @Autowired
    IDonationCenterRepo donationCenterRepo; 

    @Override
    public CompletableFuture<List<DonationCenterDto>> GetDonationCentersByUserBlood(BloodGroup group, int cityId) 
    {
        List<DonationCenterDto> centers = donationCenterRepo.GetDonationCentersByUserBlood(group, cityId)
                                            .stream()
                                            .map(DonationCenterModelMapper::AsDto)
                                            .collect(Collectors.toList());
        return CompletableFuture.completedFuture(centers);
    }

    @Override
    public CompletableFuture<List<DonationCenterDto>> GetCentersByCityId(int cityId, int page) 
    {
        List<DonationCenterDto> centers = donationCenterRepo.GetByCityId(cityId, page)
                                            .stream()
                                            .map(DonationCenterModelMapper::AsDto)
                                            .collect(Collectors.toList());
        return CompletableFuture.completedFuture(centers);
    }

    @Override
    public CompletableFuture<DonationCenterDto> DonationCenterById(int cneterId) 
    {
        DonationCenter center = donationCenterRepo.DonationCenterById(cneterId);

        if(center == null)
        {
            return CompletableFuture.completedFuture(null);
        }

        return CompletableFuture.completedFuture(DonationCenterModelMapper.AsDto(center));

    }
}
