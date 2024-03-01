package prw.stwr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prw.stwr.model.CharacterRaceSkill;

@Repository
public interface CharacterRaceSkillRepository extends JpaRepository<CharacterRaceSkill, Long> {

	CharacterRaceSkill findByCharacterRaceSkill(Long idChRaceSkill);
	
}
