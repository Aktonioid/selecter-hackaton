package com.hack.selectel.core.mappers;

import com.hack.selectel.core.dtos.ScheduleModelDto;
import com.hack.selectel.core.models.DonationCenter;
import com.hack.selectel.core.models.ScheduleModel;

public class ScheduleModelMapper 
{
    public static ScheduleModel AsEntity(ScheduleModelDto dto)
    {
        return new ScheduleModel(
            dto.getId(),
            dto.getDow(),
            dto.getStart(),
            dto.getEnd(),
            new DonationCenter(dto.getCenterId()));
    }

    public static ScheduleModelDto AsDto(ScheduleModel model)
    {
        return new ScheduleModelDto(
            model.getId(),
            model.getDow(),
            model.getStart(),
            model.getEnd(),
            model.getCenterId().getId()
        );
    }
}
