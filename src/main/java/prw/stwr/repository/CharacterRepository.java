package prw.stwr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prw.stwr.model.GameCharacter;

@Repository
public interface CharacterRepository extends JpaRepository<GameCharacter, Long>{

}
