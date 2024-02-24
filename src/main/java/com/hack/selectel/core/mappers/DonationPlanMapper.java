package com.hack.selectel.core.mappers;

import com.hack.selectel.core.dtos.DonationPlanDto;
import com.hack.selectel.core.models.DonationCenter;
import com.hack.selectel.core.models.DonationPlan;
import com.hack.selectel.core.models.UserModel;

public class DonationPlanMapper 
{
    public static DonationPlan AsEntity(DonationPlanDto dto)
    {
        return new DonationPlan(
            dto.getId(),
            new UserModel(dto.getUserId()),
            dto.getSurname(),
            dto.getFirstName(),
            dto.getSurname(),
            dto.getPatronymic(),
            new DonationCenter(dto.getDonationCenter()),
            dto.getVisitDate(),
            dto.getBloodComponent(),
            dto.isPayRequired()
            );
    }

    public static DonationPlanDto AsDto(DonationPlan model)
    {
        return new DonationPlanDto(
            model.getId(),
            model.getUserId().getId(),
            model.getFirstName(),
            model.getSurname(),
            model.getPatronymic(),
            model.getVisitDate(),
            model.getDonationCenter().getId(),
            model.getBloodComponent(),
            model.isPayRequired()
        );
    }    
}
