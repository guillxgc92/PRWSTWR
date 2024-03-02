package prw.stwr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prw.stwr.model.GameCharacter;
import prw.stwr.repository.CharacterRepository;

@Service
public class CharacterService {

	@Autowired
	private CharacterRepository characterRepository;
	
	public List<GameCharacter> getAll(){
		
		return characterRepository.findAll();
	}

	
	
}
