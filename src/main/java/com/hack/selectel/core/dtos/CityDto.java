package com.hack.selectel.core.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CityDto 
{
    private int id;
    private String title;
    private RegionDto region;    
}
