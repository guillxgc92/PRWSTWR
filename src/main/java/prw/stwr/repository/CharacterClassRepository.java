package prw.stwr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prw.stwr.model.CharacterClass;

@Repository
public interface CharacterClassRepository extends JpaRepository<CharacterClass, Long>{
	
}
