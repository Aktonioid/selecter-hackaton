package com.hack.selectel.core.repositories;

import java.util.List;
import java.util.UUID;

import com.hack.selectel.core.models.DonationPlan;

public interface IDonationPlanRepo 
{
    public boolean CreateDonationPlan(DonationPlan donation);
    public boolean UpdateDonationPlan(DonationPlan donation);
    public List<DonationPlan> GetDonationByUser(String username, int page);
    public DonationPlan GetDonationById(UUID id);    
}
