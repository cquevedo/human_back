package upc.edu.pe.humankey.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import upc.edu.pe.humankey.domain.Usuario;
import upc.edu.pe.humankey.domain.UsuarioAsistencia;
import upc.edu.pe.humankey.domain.UsuarioSolicitud;
import upc.edu.pe.humankey.repository.UsuarioAsistenciaRepository;
import upc.edu.pe.humankey.repository.UsuarioRepository;
import upc.edu.pe.humankey.repository.UsuarioSolicitudRepository;
import upc.edu.pe.humankey.service.UsuarioService;

@Service
public class UsuarioServiceImpl  implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioAsistenciaRepository usuarioAsistenciaRepository;
	

	@Autowired
	private UsuarioSolicitudRepository usuarioSolicitudRepository;
	

	@Override
	public Usuario findUserByCodigoPassword(String codigo, String password) {
		Optional<Usuario> usuario = usuarioRepository.getByCodigoAndPassword(codigo, password);
		if(usuario.isPresent()) {
			return usuario.get();
		}
		return null;
	}
	
	@Override
	public Usuario findUserById(String codigo) {
		Optional<Usuario> usuario = usuarioRepository.findById(codigo);
		if(usuario.isPresent()) {
			return usuario.get();
		}
		return null;
	}

	@Override
	public void updatePasswordUser(Usuario usuario) {
		usuarioRepository.save(usuario);		
	}

	@Override
	public List<UsuarioAsistencia> obtenerAsistencia(String codigo) {
		return usuarioAsistenciaRepository.findByCodigo(codigo);
	}

	@Override
	public List<UsuarioSolicitud> obtenerSolicitudes(String codigo) {		
		return usuarioSolicitudRepository.findByCodigo(codigo ,Sort.by(Sort.Direction.DESC, "id"));
	}

	@Override
	public void grabarSolicitud(UsuarioSolicitud solicitud) {
		usuarioSolicitudRepository.save(solicitud);		
	}
	

}