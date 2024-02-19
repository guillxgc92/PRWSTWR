package prw.stwr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prw.stwr.model.Territory;
import prw.stwr.repository.TerritoryRepository;

@Service
public class TerritoryService {
	
	@Autowired
	private TerritoryRepository territoryRepository;
	
	public List<Territory> getAll(){
		
		return territoryRepository.findAll();
	}
}
