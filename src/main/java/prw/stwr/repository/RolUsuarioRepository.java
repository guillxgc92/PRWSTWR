package prw.stwr.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prw.stwr.model.RolUsuario;

@Repository
public interface RolUsuarioRepository extends JpaRepository<RolUsuario, Long>{
	

}
