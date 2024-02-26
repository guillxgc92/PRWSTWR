package prw.stwr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prw.stwr.model.Planet;
import prw.stwr.model.Regions;


@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long>{
	
	List<Planet> findByObjRegions(Regions objRegions);
}
