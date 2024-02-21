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
@Table(name = "user_stwr")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USER_UST")
	private long idUser;
	
	@ManyToOne
	@JoinColumn(name = "ID_ROL_UST", referencedColumnName = "ID_ROL_RST")
	private RolUsuario idRolUser; //CUANDO TENEMOS UNA FK HACEMOS REFERENCIA MEDIANTE EL OBJETO NO EL IDENTIFICADOR ASI NOS DEVUELVE EL OBJETO RELACIONADO COMPLETO DE LA BASE DE DATOS
	
	@Column(name = "USER_TAGNAME_UST")
	private String usertag;
	
	@Column(name = "USER_PASSWORD_UST")
	private String password;
	
	@Column(name = "NAME_UST")
	private String name;
	
	@Column(name = "FIRSTSURNAME_UST")
	private String firstSurName;
	
	@Column(name = "SECONDSURNAME_UST")
	private String secondSurName;
	
	@Column(name = "EMAIL_UST")
	private String email;
	
	@Column(name = "ACTIVEROW_UST")
	private boolean activerow;
	
	public Usuario() {
		
	}

	public Usuario(long idUser, RolUsuario idRolUser, String usertag, 
				   String password, String name, String firstSurName,
				   String secondSurName, String email, boolean activerow) {
		this.idUser = idUser;
		this.idRolUser = idRolUser;
		this.usertag = usertag;
		this.password = password;
		this.name = name;
		this.firstSurName = firstSurName;
		this.secondSurName = secondSurName;
		this.email = email;
		this.activerow = activerow;
	}

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public RolUsuario getIdRolUser() {
		return idRolUser;
	}

	public void setIdRolUser(RolUsuario idRolUser) {
		this.idRolUser = idRolUser;
	}

	public String getUsertag() {
		return usertag;
	}

	public void setUsertag(String usertag) {
		this.usertag = usertag;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pass) {
		this.password = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstSurName() {
		return firstSurName;
	}

	public void setFirstSurName(String firstSurname) {
		this.firstSurName = firstSurname;
	}

	public String getSecondSurName() {
		return secondSurName;
	}

	public void setSecondSurName(String secondSurname) {
		this.secondSurName = secondSurname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActiverow() {
		return activerow;
	}

	public void setActiverow(boolean activerow) {
		this.activerow = activerow;
	}
}
