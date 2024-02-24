package com.hack.selectel.infrastucture.services;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hack.selectel.core.dtos.UserModelDto;
import com.hack.selectel.core.mappers.UserModelMapper;
import com.hack.selectel.core.models.UserModel;
import com.hack.selectel.core.repositories.IUserRepo;
import com.hack.selectel.core.services.IUserService;

@Service
public class UserService implements IUserService
{
    @Autowired
    IUserRepo userRepo;

    @Override
    public CompletableFuture<Boolean> CreateUser(UserModelDto userModelDto) 
    {
        return CompletableFuture.completedFuture(userRepo.CreateUser(UserModelMapper.AsEntity(userModelDto)));
    }

    @Override
    public CompletableFuture<Boolean> UpdateUser(UserModelDto userModelDto) 
    {
        return CompletableFuture.completedFuture(userRepo.UpdateUser(UserModelMapper.AsEntity(userModelDto)));
    }

    @Override
    public CompletableFuture<UserModelDto> GetUserByUsername(String username) 
    {
        UserModel userModel = userRepo.GetUserByUserName(username);

        if(userModel == null)
        {
            return CompletableFuture.completedFuture(null);
        }

        return CompletableFuture.completedFuture(UserModelMapper.AsDto(userModel));
    }

}
