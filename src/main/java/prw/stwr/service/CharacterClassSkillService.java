package prw.stwr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prw.stwr.model.CharacterClassSkill;
import prw.stwr.repository.CharacterClassSkillRepository;

@Service
public class CharacterClassSkillService {
	
	@Autowired
	private CharacterClassSkillRepository characterClassSkillRepository;
	
	public List<CharacterClassSkill> getAll() {
		
		return characterClassSkillRepository.findAll();
	}
}
