package com.hack.selectel.core.repositories;

import java.util.List;

import com.hack.selectel.core.models.City;

public interface ICityRepo 
{
    public boolean CreateCity(City city);
    public boolean UpdateCity(City city);
    public City GetCityById(int id);
    public List<City> GetAllCities(int page);
    public List<City> FindCityByName(String name);
}
