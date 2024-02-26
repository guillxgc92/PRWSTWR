package prw.stwr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prw.stwr.model.Galaxy;
import prw.stwr.model.Regions;

@Repository
public interface RegionsRepository extends JpaRepository<Regions, Long>{
	
	List<Regions> findByObjGalaxy(Galaxy idGalaxyRegion);
	
}
