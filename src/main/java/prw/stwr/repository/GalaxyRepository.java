package prw.stwr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prw.stwr.model.Galaxy;

@Repository
public interface GalaxyRepository extends JpaRepository<Galaxy, Long>{
	
}
