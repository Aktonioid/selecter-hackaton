package com.hack.selectel.infrastucture.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hack.selectel.core.dtos.RegionDto;
import com.hack.selectel.core.mappers.RegionMapper;
import com.hack.selectel.core.models.Region;
import com.hack.selectel.core.repositories.IRegionRepo;
import com.hack.selectel.core.services.IRegionService;

@Service
public class RegionService implements IRegionService
{
    @Autowired
    IRegionRepo regionRepo;

    @Override
    public CompletableFuture<Boolean> CreateRegion(RegionDto dto) 
    {
        return CompletableFuture.completedFuture(regionRepo.CreateRegion(RegionMapper.AsEntity(dto)));
    }

    @Override
    public CompletableFuture<Boolean> UpdateRegion(RegionDto dto) 
    {
        return CompletableFuture.completedFuture(regionRepo.UpdateRegion(RegionMapper.AsEntity(dto)));
    }

    @Override
    public CompletableFuture<List<RegionDto>> GetAllRegions(int page) 
    {
        List<RegionDto> regionDtos = regionRepo.GetAllRegions(page)
                                        .stream()
                                        .map(RegionMapper::AsDto)
                                        .collect(Collectors.toList());

        return CompletableFuture.completedFuture(regionDtos);
    }

    @Override
    public CompletableFuture<RegionDto> GetRegionById(int id) 
    {
        Region region = regionRepo.GetRegionById(id);

        if(region == null)
        {
            return CompletableFuture.completedFuture(null);
        }

        return CompletableFuture.completedFuture(RegionMapper.AsDto(region));
    }

}
