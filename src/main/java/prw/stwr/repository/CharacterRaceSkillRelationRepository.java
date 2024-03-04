package prw.stwr.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prw.stwr.model.CharacterRaceSkillRelation;

@Repository
public interface CharacterRaceSkillRelationRepository extends JpaRepository<CharacterRaceSkillRelation, Long>{
	

}
