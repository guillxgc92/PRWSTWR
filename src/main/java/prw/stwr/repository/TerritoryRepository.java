package prw.stwr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prw.stwr.model.Planet;
import prw.stwr.model.Territory;

@Repository
public interface TerritoryRepository extends JpaRepository<Territory, Long>{
	
	List<Territory> findByObjPlanet(Planet objPlanet);
}
