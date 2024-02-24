package com.hack.selectel.core.mappers;

import com.hack.selectel.core.dtos.CityDto;
import com.hack.selectel.core.models.City;

public class CityModelMapper 
{
    public static City AsEntity(CityDto dto)
    {   
        if(dto == null)
        {
            return null;
        }

        return new City(
        dto.getId(),
        dto.getTitle(),
        RegionMapper.AsEntity(dto.getRegion())
        );
    }   
    public static CityDto AsDto(City city)
    {
        if(city == null)
        {
            return null;
        }

        return new CityDto(
            city.getId(),
            city.getTitle(),
            RegionMapper.AsDto(city.getRegion())
        );
    } 
}
