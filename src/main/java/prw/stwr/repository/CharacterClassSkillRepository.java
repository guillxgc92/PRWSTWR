package prw.stwr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prw.stwr.model.CharacterClassSkill;

@Repository
public interface CharacterClassSkillRepository extends JpaRepository<CharacterClassSkill, Long>{

}
