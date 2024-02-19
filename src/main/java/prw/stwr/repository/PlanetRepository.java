package prw.stwr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prw.stwr.model.Planet;


@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long>{
	
	
}
