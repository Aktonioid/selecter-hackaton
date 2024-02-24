package com.hack.selectel.core.repositories;


import java.util.List;

import com.hack.selectel.core.models.Region;

public interface IRegionRepo 
{
    public boolean CreateRegion(Region region);
    public boolean UpdateRegion(Region region);
    public List<Region> GetAllRegions(int page);
    public Region GetRegionById(int id); 
}
