package com.hack.selectel.core.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.hack.selectel.core.dtos.DonationCenterDto;
import com.hack.selectel.core.models.BloodGroup;

public interface IDonationCenterService 
{
    public CompletableFuture<List<DonationCenterDto>> GetDonationCentersByUserBlood(BloodGroup group,
                                                             int cityId);
    public CompletableFuture<List<DonationCenterDto>> GetCentersByCityId(int cityId, int page);
    public CompletableFuture<DonationCenterDto> DonationCenterById(int cneterId);
    
}
