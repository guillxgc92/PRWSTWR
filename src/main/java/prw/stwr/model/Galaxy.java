package prw.stwr.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "galaxy_stwr")
public class Galaxy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_GALAXY_GST")
	private long idGalaxy;
	
	@Column(name = "GALAXY_NAME_GST")
	private String galaxyName;
	
	@Column(name = "GALAXY_DESCRIPTION")
	private String galaxyDescription;
	
	@Column(name = "ACTIVEROW_GST")
	private boolean activerow;
	
	public Galaxy() {
		
	}

	public Galaxy(long idGalaxy, String galaxyName, String galaxyDescription, boolean activerow) {
		this.idGalaxy = idGalaxy;
		this.galaxyName = galaxyName;
		this.galaxyDescription = galaxyDescription;
		this.activerow = activerow;
	}

	public long getIdGalaxy() {
		return idGalaxy;
	}

	public void setIdGalaxy(long idGalaxy) {
		this.idGalaxy = idGalaxy;
	}

	public String getGalaxyName() {
		return galaxyName;
	}

	public void setGalaxyName(String galaxyName) {
		this.galaxyName = galaxyName;
	}

	public String getGalaxyDescription() {
		return galaxyDescription;
	}

	public void setGalaxyDescription(String galaxyDescription) {
		this.galaxyDescription = galaxyDescription;
	}

	public boolean isActiverow() {
		return activerow;
	}

	public void setActiverow(boolean activerow) {
		this.activerow = activerow;
	}
}
