package prw.stwr.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "campaignasign_stwr")
public class CampaignAsign {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CAMPAIGNASIGN_CST")
	private long idCampaignAsigned;
	
	@ManyToOne
	@JoinColumn(name = "ID_USER_UST", referencedColumnName = "ID_USER_UST")
	private Usuario idUserAsigned;
	
	@ManyToOne
	@JoinColumn(name = "ID_CAMPAIGN_CST", referencedColumnName = "ID_CAMPAIGN_CST")
	private Campaign idCampaign;
	
	@Column(name = "ACTIVEROW_CAMPAIGNASIGN_CST")
	private boolean activerow;
	
	public CampaignAsign() {
		
	}
	
	public CampaignAsign(long idCampaignAsigned, Usuario idUserAsigned, 
			Campaign idCampaign, boolean activerow) {
		this.idCampaignAsigned = idCampaignAsigned;
		this.idUserAsigned = idUserAsigned;
		this.idCampaign = idCampaign;
		this.activerow = activerow;
	}

	public long getIdCampaignAsigned() {
		return idCampaignAsigned;
	}

	public void setIdCampaignAsigned(long idCampaignAsigned) {
		this.idCampaignAsigned = idCampaignAsigned;
	}

	public Usuario getIdUserAsigned() {
		return idUserAsigned;
	}

	public void setIdUserAsigned(Usuario idUserAsigned) {
		this.idUserAsigned = idUserAsigned;
	}

	public Campaign getIdCampaign() {
		return idCampaign;
	}

	public void setIdCampaign(Campaign idCampaign) {
		this.idCampaign = idCampaign;
	}

	public boolean isActiverow() {
		return activerow;
	}

	public void setActiverow(boolean activerow) {
		this.activerow = activerow;
	}
}
