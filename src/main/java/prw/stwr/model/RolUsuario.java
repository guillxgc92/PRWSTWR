package prw.stwr.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rol_stwr")
public class RolUsuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ROL_RST")
	private long idRolUser;
	
	@Column(name = "ROLCODE_RST")
	private String rolcode;
	
	@Column(name = "ROLNAME_RST")
	private String rolname;
	
	@Column(name = "ACTIVEROW_RST")
	private boolean activerow;
	
	public RolUsuario() {
		
	}

	public RolUsuario(long idRolUser, String rolcode, 
					  String rolname, boolean activerow) {
		this.idRolUser = idRolUser;
		this.rolcode = rolcode;
		this.rolname = rolname;
		this.activerow = activerow;
	}

	public long getIdRolUser() {
		return idRolUser;
	}

	public void setIdRolUser(long idRolUser) {
		this.idRolUser = idRolUser;
	}

	public String getRolcode() {
		return rolcode;
	}

	public void setRolcode(String rolcode) {
		this.rolcode = rolcode;
	}

	public String getRolname() {
		return rolname;
	}

	public void setRolname(String rolname) {
		this.rolname = rolname;
	}

	public boolean isActiverow() {
		return activerow;
	}

	public void setActiverow(boolean activerow) {
		this.activerow = activerow;
	}
}
