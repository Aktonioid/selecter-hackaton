package com.hack.selectel.core.dtos;

import java.util.List;

import com.hack.selectel.core.models.BloodComponentsStatus;
import com.hack.selectel.core.models.BloodGroupStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DonationCenterDto 
{
    private int id;

    private CityDto city;
    private String title;
    private String address;
    private String site;
    private List<String> phones;
    private List<ScheduleModelDto> schedule;
    //резусы и т.д
    BloodGroupStatus o_plus;
    BloodGroupStatus o_minus;
    BloodGroupStatus a_plus;
    BloodGroupStatus a_minus;
    BloodGroupStatus b_plus;
    BloodGroupStatus b_minus;
    BloodGroupStatus ab_plus;
    BloodGroupStatus ab_minus;
    //принимаемые компоненты
    BloodComponentsStatus blood;
    BloodComponentsStatus plasma;
    BloodComponentsStatus platelets;
    BloodComponentsStatus erythrocytes;
    BloodComponentsStatus leukocytes;
}
