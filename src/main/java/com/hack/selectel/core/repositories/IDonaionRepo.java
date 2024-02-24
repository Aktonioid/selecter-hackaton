package com.hack.selectel.core.repositories;

import java.util.List;
import java.util.UUID;

import com.hack.selectel.core.models.Donation;

public interface IDonaionRepo 
{
    public boolean CreateDonation(Donation donation);
    public boolean UpdateDonation(Donation donation);
    public List<Donation> GetDonationByUser(String username, int page);
    public Donation GetDonationById(UUID id);
}
