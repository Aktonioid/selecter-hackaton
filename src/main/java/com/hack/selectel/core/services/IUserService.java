package com.hack.selectel.core.services;

import java.util.concurrent.CompletableFuture;

import com.hack.selectel.core.dtos.UserModelDto;

public interface IUserService 
{
    public CompletableFuture<Boolean> CreateUser(UserModelDto userModelDto);
    public CompletableFuture<Boolean> UpdateUser(UserModelDto userModelDto);
    public CompletableFuture<UserModelDto> GetUserByUsername(String username);
        
}
