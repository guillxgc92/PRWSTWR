package prw.stwr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import prw.stwr.model.CharacterRaceSkillRelation;
import prw.stwr.repository.CharacterRaceSkillRelationRepository;

@Service
public class CharacterRaceSkillRelationService {
	
	@Autowired
	private CharacterRaceSkillRelationRepository characterRaceSkillRelationRepository;
	
	public List<CharacterRaceSkillRelation> getAll(){
		return characterRaceSkillRelationRepository.findAll();
	}
	
	@Transactional
	public List<Long> getRelatedCharacterRaceSkillIds(Long characterRaceId) {
        return characterRaceSkillRelationRepository.findRelatedCharacterRaceSkillIds(characterRaceId);
    }
}
