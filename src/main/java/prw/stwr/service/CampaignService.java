package prw.stwr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import prw.stwr.model.Campaign;
import prw.stwr.repository.CampaignRepository;

public class CampaignService {
	
	@Autowired
	private CampaignRepository campaignRepository;
	
	//Devuelve todos los registros de campañas
	public List<Campaign> getAll(){
		
		return campaignRepository.findAll();
	}
}
