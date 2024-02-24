package com.hack.selectel.infrastucture.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hack.selectel.core.dtos.CityDto;
import com.hack.selectel.core.mappers.CityModelMapper;
import com.hack.selectel.core.models.City;
import com.hack.selectel.core.services.ICityService;
import com.hack.selectel.infrastucture.repositories.CityRepo;

@Service
public class CityService implements ICityService
{
    @Autowired
    CityRepo cityRepo;

    @Override
    public CompletableFuture<Boolean> CreateCity(CityDto dto) 
    {
        return CompletableFuture.completedFuture(cityRepo.CreateCity(CityModelMapper.AsEntity(dto)));
    }

    @Override
    public CompletableFuture<Boolean> UpdateCity(CityDto dto) 
    {
        return CompletableFuture.completedFuture(cityRepo.UpdateCity(CityModelMapper.AsEntity(dto)));
    }

    @Override
    public CompletableFuture<CityDto> GetCityById(int id) 
    {
        City city = cityRepo.GetCityById(id);
        
        if(city ==  null)
        {
            return CompletableFuture.completedFuture(null);
        }

        return CompletableFuture.completedFuture(CityModelMapper.AsDto(city));
    }

    @Override
    public CompletableFuture<List<CityDto>> GetAllCities(int page) 
    {
        List<CityDto> cities = cityRepo.GetAllCities(page)
                                .stream()
                                .map(CityModelMapper::AsDto)
                                .collect(Collectors.toList());

        return CompletableFuture.completedFuture(cities);
    }

    @Override
    public CompletableFuture<List<CityDto>> FindCityByName(String name) 
    {
        List<CityDto> cities = cityRepo.FindCityByName(name)
                                .stream()
                                .map(CityModelMapper::AsDto)
                                .collect(Collectors.toList());

        return CompletableFuture.completedFuture(cities);
    }
        
}
