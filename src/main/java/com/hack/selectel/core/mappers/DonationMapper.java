package com.hack.selectel.core.mappers;

import com.hack.selectel.core.dtos.DonationDto;
import com.hack.selectel.core.models.Donation;
import com.hack.selectel.core.models.DonationCenter;
import com.hack.selectel.core.models.UserModel;

public class DonationMapper 
{
    public static Donation AsEntity(DonationDto dto)
    {
        return new Donation(
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

    public static DonationDto AsDto(Donation model)
    {
        return new DonationDto(
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
