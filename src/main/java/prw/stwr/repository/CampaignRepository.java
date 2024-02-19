package prw.stwr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prw.stwr.model.Campaign;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Integer>{

}
