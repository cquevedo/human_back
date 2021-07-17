package upc.edu.pe.humankey.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import upc.edu.pe.humankey.domain.UsuarioSolicitud;


@Repository
public interface UsuarioSolicitudRepository extends JpaRepository<UsuarioSolicitud, Integer>,  JpaSpecificationExecutor<UsuarioSolicitud> {
	
	
	 List<UsuarioSolicitud> findByCodigo(String codigo, Sort sort);
	
} 