package com.hack.selectel.core.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.hack.selectel.core.dtos.RegionDto;

public interface IRegionService 
{
    
    public CompletableFuture<Boolean> CreateRegion(RegionDto dto);
    public CompletableFuture<Boolean> UpdateRegion(RegionDto dto);
    public CompletableFuture<List<RegionDto>> GetAllRegions(int page);
    public CompletableFuture<RegionDto> GetRegionById(int id);

}
