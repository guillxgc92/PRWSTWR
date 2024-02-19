package prw.stwr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prw.stwr.model.Regions;
import prw.stwr.repository.RegionsRepository;

@Service
public class RegionsService {
	
	@Autowired
	private RegionsRepository regionsRepository;
	
	public List<Regions> getAll(){
		
		return regionsRepository.findAll();
	}
}
