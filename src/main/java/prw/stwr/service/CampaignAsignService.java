package prw.stwr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prw.stwr.model.CampaignAsign;
import prw.stwr.repository.CampaignAsignRepository;

@Service
public class CampaignAsignService {
	
	@Autowired
	private CampaignAsignRepository campaignAsignRepository;
	
	@SuppressWarnings("null")
	public CampaignAsign addCampaignAsign(CampaignAsign campaignAsign) {
		
		return campaignAsignRepository.save(campaignAsign);
	}
}
