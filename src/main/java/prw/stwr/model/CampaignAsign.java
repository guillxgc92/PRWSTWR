package prw.stwr.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "campaignasign_stwr")
public class CampaignAsign {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CAMPAIGNASIGN_CST")
	private long idCampaignAsigned;
	
	@Column(name = "ID_USER_UST")
	private long idUserAsigned;
	
	@Column(name = "ID_CAMPAIGN_CST")
	private long idCampaign;
	
	@Column(name = "ACTIVEROW_CAMPAIGNASIGN_CST")
	private boolean activerow;
	
	public CampaignAsign() {
		
	}

	public long getIdCampaignAsigned() {
		return idCampaignAsigned;
	}

	public void setIdCampaignAsigned(long idCampaignAsigned) {
		this.idCampaignAsigned = idCampaignAsigned;
	}

	public long getIdUserAsigned() {
		return idUserAsigned;
	}

	public void setIdUserAsigned(long idUserAsigned) {
		this.idUserAsigned = idUserAsigned;
	}

	public long getIdCampaign() {
		return idCampaign;
	}

	public void setIdCampaign(long idCampaign) {
		this.idCampaign = idCampaign;
	}

	public boolean isActiverow() {
		return activerow;
	}

	public void setActiverow(boolean activerow) {
		this.activerow = activerow;
	}
}
