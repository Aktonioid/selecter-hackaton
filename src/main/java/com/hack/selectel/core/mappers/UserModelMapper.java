package com.hack.selectel.core.mappers;

import com.hack.selectel.core.dtos.UserModelDto;
import com.hack.selectel.core.models.City;
import com.hack.selectel.core.models.UserModel;

public class UserModelMapper 
{
    public static UserModel AsEntity(UserModelDto dto)
    {
        return new UserModel(
            dto.getId(),
            dto.getUsername(),
            dto.getFirstName(),
            dto.getSurname(),
            dto.getPatronymic(),
            dto.getBirthDate(),
            dto.getGender(),
            dto.getDonations(),
            new City(dto.getCity()),
            dto.getBloodGroup(),
            dto.getKell()
        );
    }
    
    public static UserModelDto AsDto(UserModel model)
    {
        return new UserModelDto(
            model.getId(),
            model.getUsername(),
            model.getFirstName(),
            model.getSurname(),
            model.getPatronymic(),
            model.getBirthDate(),
            model.getGender(),
            model.getDonations(),
            model.getCity().getId(),
            model.getBloodGroup(),
            model.getKell()
        );
    }
}
