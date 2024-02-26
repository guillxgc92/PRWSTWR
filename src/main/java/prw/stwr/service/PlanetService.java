package prw.stwr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prw.stwr.model.Planet;
import prw.stwr.model.Regions;
import prw.stwr.repository.PlanetRepository;

@Service
public class PlanetService {
	
	@Autowired
	private PlanetRepository planetRepository;
	
	public List<Planet> getAll(){
		
		return planetRepository.findAll();
	}
	
	public List<Planet> getPlanetsByRegion(Regions objRegions){
		return planetRepository.findByObjRegions(objRegions);
	}
}
