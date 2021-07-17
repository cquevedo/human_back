package upc.edu.pe.humankey.facade;

import upc.edu.pe.humankey.dto.UsuarioAsistenciaResponse;
import upc.edu.pe.humankey.dto.UsuarioHumanResponse;
import upc.edu.pe.humankey.dto.UsuarioLoginHumanRequest;
import upc.edu.pe.humankey.dto.UsuarioSolicitudHumanRequest;
import upc.edu.pe.humankey.dto.UsuarioSolicitudHumanResponse;
import upc.edu.pe.humankey.dto.UsuarioUpdatePasswordHumanRequest;

public interface UsuarioFacade {
	
	
	UsuarioHumanResponse login(UsuarioLoginHumanRequest request);
	
	void updatePasswordUser(UsuarioUpdatePasswordHumanRequest request);
	
	
	UsuarioAsistenciaResponse obtenerAsistencia(String codigo);
	
	
	UsuarioSolicitudHumanResponse obtenerSolicitudes(String codigo);
	
	void grabarSolicitud(UsuarioSolicitudHumanRequest request);
	
}
