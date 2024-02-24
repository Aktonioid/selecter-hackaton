package com.hack.selectel.core.dtos;

import java.util.Date;
import java.util.UUID;

import com.hack.selectel.core.models.BloodGroup;
import com.hack.selectel.core.models.Gender;
import com.hack.selectel.core.models.KellEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserModelDto 
{
    private UUID id;
    private String username;
    private String firstName;
    private String surname;
    private String patronymic;
    private Date birthDate;
    private Gender gender;
    private int donations;
    private int city;
    private BloodGroup bloodGroup;
    private KellEnum kell;
}
