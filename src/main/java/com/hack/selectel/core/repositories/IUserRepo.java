package com.hack.selectel.core.repositories;

import com.hack.selectel.core.models.UserModel;

public interface IUserRepo 
{
    public boolean CreateUser(UserModel model);
    public UserModel GetUserByUserName(String username);    
    public boolean UpdateUser(UserModel model);
}
