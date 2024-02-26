package prw.stwr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prw.stwr.model.CampaignInfoSave;
import prw.stwr.repository.CampaignInfoSaveRepository;

@Service
public class CampaignInfoService {
	
	@Autowired
	private CampaignInfoSaveRepository campaignInfoSaveRepository;
	
	@SuppressWarnings("null")
	public CampaignInfoSave addRegistroCampaign (CampaignInfoSave campaignInfoSave) {
		
		return campaignInfoSaveRepository.save(campaignInfoSave); //Guardar registro de IDs de campaña y "lugares"
	}
}
