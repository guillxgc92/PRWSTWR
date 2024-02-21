package prw.stwr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prw.stwr.model.CampaignInfoSave;

@Repository
public interface CampaignInfoSaveRepository extends JpaRepository<CampaignInfoSave, Long>{

}
