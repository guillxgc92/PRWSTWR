package prw.stwr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prw.stwr.model.CharacterRace;

@Repository
public interface CharacterRaceRepository extends JpaRepository<CharacterRace, Long> {

	CharacterRace findByIdCharacterRace(long idCharacterRace);
}
