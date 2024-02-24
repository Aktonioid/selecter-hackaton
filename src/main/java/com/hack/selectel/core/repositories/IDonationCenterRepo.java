package com.hack.selectel.core.repositories;

import java.util.List;

import com.hack.selectel.core.models.BloodGroup;
import com.hack.selectel.core.models.DonationCenter;

public interface IDonationCenterRepo 
{
    public List<DonationCenter> GetDonationCentersByUserBlood(BloodGroup group,
                                                             int cityId);
    public DonationCenter DonationCenterById(int cneterId);
    public List<DonationCenter> GetByCityId(int cityId, int page); 
}
