package prw.stwr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import prw.stwr.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findByUsername(String username);
	Usuario findByIdUser(long idUser);

	@Modifying
    @Query("DELETE FROM Usuario u WHERE u.idUser = :idUser")
    void deleteByIdUser(@Param("idUser") long idUser);
}