package upc.edu.pe.humankey.service;

import java.util.List;

import upc.edu.pe.humankey.domain.Usuario;
import upc.edu.pe.humankey.domain.UsuarioAsistencia;
import upc.edu.pe.humankey.domain.UsuarioSolicitud;

public interface UsuarioService {
	
	Usuario findUserById(String codigo);
	
	Usuario findUserByCodigoPassword(String codigo,String password);
	
	void updatePasswordUser(Usuario usuario);
	
	List<UsuarioAsistencia> obtenerAsistencia(String codigo);
	
	List<UsuarioSolicitud> obtenerSolicitudes(String codigo);
	
	void grabarSolicitud(UsuarioSolicitud solicitud);
}
