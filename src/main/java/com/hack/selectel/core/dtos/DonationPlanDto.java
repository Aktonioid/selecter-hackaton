package com.hack.selectel.core.dtos;

import java.util.Date;
import java.util.UUID;

import com.hack.selectel.core.models.BloodComponent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DonationPlanDto 
{
    private UUID id;
    private UUID userId;
    private String firstName;
    private String surname;
    private String patronymic;
    private Date visitDate;
    private int donationCenter;
    private BloodComponent bloodComponent;
    private boolean isPayRequired;    
}
