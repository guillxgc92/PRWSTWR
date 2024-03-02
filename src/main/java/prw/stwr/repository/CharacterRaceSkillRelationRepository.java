package prw.stwr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import prw.stwr.model.CharacterRaceSkillRelation;

@Repository
public interface CharacterRaceSkillRelationRepository extends JpaRepository<CharacterRaceSkillRelation, Long>{
	
	@Query("SELECT characterRaceSkill.idChRaceSkill FROM CharacterRaceSkillRelation rel JOIN rel.characterRaceSkill skill WHERE rel.characterRace.idCharacterRace = :idCharacterRace")
	List<Long> findRelatedCharacterRaceSkillIds(@Param("idCharacterRace") Long idCharacterRace);
	
}
