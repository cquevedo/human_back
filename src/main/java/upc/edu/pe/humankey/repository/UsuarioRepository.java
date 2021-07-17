package upc.edu.pe.humankey.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import upc.edu.pe.humankey.domain.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>,  JpaSpecificationExecutor<Usuario> {
	
	@Query("SELECT t FROM  Usuario t WHERE t.codigo=:codigo and t.password=:password and t.estado='A'")
	Optional<Usuario> getByCodigoAndPassword(String codigo, String password);
	
} 