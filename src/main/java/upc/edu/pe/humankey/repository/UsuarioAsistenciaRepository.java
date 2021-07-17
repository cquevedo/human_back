package upc.edu.pe.humankey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import upc.edu.pe.humankey.domain.UsuarioAsistencia;


@Repository
public interface UsuarioAsistenciaRepository extends JpaRepository<UsuarioAsistencia, Integer>,  JpaSpecificationExecutor<UsuarioAsistencia> {
	
	
	 List<UsuarioAsistencia> findByCodigo(String codigo);
	
} 