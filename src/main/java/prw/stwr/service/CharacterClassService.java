package prw.stwr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prw.stwr.model.CharacterClass;
import prw.stwr.repository.CharacterClassRepository;

@Service
public class CharacterClassService {

	@Autowired
	private CharacterClassRepository characterClassRepository;
	
	public List<CharacterClass> getAll(){
		
		return characterClassRepository.findAll();
	}
}
