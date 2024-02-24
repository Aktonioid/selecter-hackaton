package com.hack.selectel.core.mappers;

import java.util.stream.Collectors;


import com.hack.selectel.core.dtos.DonationCenterDto;
import com.hack.selectel.core.models.DonationCenter;
import com.hack.selectel.core.models.DonationCenterPhones;

public class DonationCenterModelMapper 
{
    public static DonationCenter AsEntity(DonationCenterDto dto)
    {
        return new DonationCenter(
            dto.getId(),
            CityModelMapper.AsEntity(dto.getCity()),
            dto.getTitle(),
            dto.getAddress(),
            dto.getSite(),
            null, //пока так, так как пока что нет ситуаций, когда надо было бы обновлять инфу клиник
            dto.getSchedule()
                .stream()
                .map(ScheduleModelMapper::AsEntity)
                .collect(Collectors.toSet()),
            dto.getO_plus(),
            dto.getO_minus(),
            dto.getA_plus(),
            dto.getA_minus(),
            dto.getB_plus(),
            dto.getB_minus(),
            dto.getAb_plus(),
            dto.getAb_minus(),
            dto.getBlood(),
            dto.getPlasma(),
            dto.getPlatelets(),
            dto.getErythrocytes(),
            dto.getLeukocytes()
        );
    }

    public static DonationCenterDto AsDto(DonationCenter model)
    {
        return new DonationCenterDto(
        model.getId(),
        CityModelMapper.AsDto(model.getCity()),
        model.getTitle(),
        model.getAddress(),
        model.getSite(),
        model.getPhoneNumbers()
                .stream()
                .map(DonationCenterPhones::getPhone)
                .collect(Collectors.toList()),
        model.getSchedule()
            .stream()
            .map(ScheduleModelMapper::AsDto)
            .collect(Collectors.toList()),
        model.getO_plus(),
        model.getO_minus(),
        model.getA_plus(),
        model.getA_minus(),
        model.getB_plus(),
        model.getB_minus(),
        model.getAb_plus(),
        model.getAb_minus(),
        model.getBlood(),
        model.getPlasma(),
        model.getPlatelets(),
        model.getErythrocytes(),
        model.getLeukocytes());
    }
}
