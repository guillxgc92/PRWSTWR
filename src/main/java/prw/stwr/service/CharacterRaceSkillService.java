package prw.stwr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prw.stwr.model.CharacterRaceSkill;
import prw.stwr.repository.CharacterRaceSkillRepository;

@Service
public class CharacterRaceSkillService {

	@Autowired
	private CharacterRaceSkillRepository characterRaceSkillRepository;
	
	public List<CharacterRaceSkill> getAll(){
		
		return characterRaceSkillRepository.findAll();
	}
}
