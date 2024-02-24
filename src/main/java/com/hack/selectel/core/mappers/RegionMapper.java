package com.hack.selectel.core.mappers;

import com.hack.selectel.core.dtos.RegionDto;
import com.hack.selectel.core.models.Region;

public class RegionMapper 
{
    public static RegionDto AsDto(Region model)
    {
        return new RegionDto(model.getId(), model.getTitle());
    }   
    public static Region AsEntity(RegionDto dto)
    {
        return new Region(dto.getId(), dto.getTitle());
    } 
}
