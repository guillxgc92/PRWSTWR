package prw.stwr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import prw.stwr.model.Galaxy;
import prw.stwr.model.Regions;
import prw.stwr.repository.RegionsRepository;

@Service
public class RegionsService {
	
	@Autowired
	private RegionsRepository regionsRepository;
	
	public List<Regions> getAll(){
		
		return regionsRepository.findAll();
	}
	
	public List<Regions> getRegionsByGalaxy(Galaxy objGalaxy){
		System.out.println("SERVICE REGION ObjGalaxy: " + objGalaxy);
		return regionsRepository.findByObjGalaxy(objGalaxy);
	}
	
	public Regions getRegionById(@NonNull Long regionId) {
        return regionsRepository.findById(regionId).orElse(null);
    }
}
