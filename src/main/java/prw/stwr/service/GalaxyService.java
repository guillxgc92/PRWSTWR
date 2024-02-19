package prw.stwr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prw.stwr.model.Galaxy;
import prw.stwr.repository.GalaxyRepository;

@Service
public class GalaxyService {
	
	@Autowired
	private GalaxyRepository galaxyRepository;
	
	public List<Galaxy> getAll(){
		
		return galaxyRepository.findAll();
	}
}
