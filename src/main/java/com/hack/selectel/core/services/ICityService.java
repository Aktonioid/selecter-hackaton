package com.hack.selectel.core.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.hack.selectel.core.dtos.CityDto;

public interface ICityService 
{
    
    public CompletableFuture<Boolean> CreateCity(CityDto dto);
    public CompletableFuture<Boolean> UpdateCity(CityDto dto);
    public CompletableFuture<CityDto> GetCityById(int id);
    public CompletableFuture<List<CityDto>> GetAllCities(int page);
    public CompletableFuture<List<CityDto>> FindCityByName (String name);


}
