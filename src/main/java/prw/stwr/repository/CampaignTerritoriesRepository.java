package prw.stwr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prw.stwr.model.CampaignTerritories;

@Repository
public interface CampaignTerritoriesRepository extends JpaRepository<CampaignTerritories, Long>{

	
}
