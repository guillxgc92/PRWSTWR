package prw.stwr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prw.stwr.model.CharacterRace;
import prw.stwr.repository.CharacterRaceRepository;

@Service
public class CharacterRaceService {

	@Autowired
	private CharacterRaceRepository characterRaceRepository;
	
	public List<CharacterRace> getAll(){
		
		return characterRaceRepository.findAll();
	}
	
}
