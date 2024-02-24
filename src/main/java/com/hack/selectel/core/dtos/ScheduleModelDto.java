package com.hack.selectel.core.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ScheduleModelDto 
{
    private int id;
    private String dow;
    private String start;
    private String end;
    private int centerId;
}
