package upc.edu.pe.humankey.facade.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pe.com.mascarga.util.GenericUtil;
import upc.edu.pe.humankey.config.CoreException;
import upc.edu.pe.humankey.domain.Usuario;
import upc.edu.pe.humankey.domain.UsuarioAsistencia;
import upc.edu.pe.humankey.domain.UsuarioSolicitud;
import upc.edu.pe.humankey.dto.UsuarioAsistenciaDTO;
import upc.edu.pe.humankey.dto.UsuarioAsistenciaResponse;
import upc.edu.pe.humankey.dto.UsuarioHumanResponse;
import upc.edu.pe.humankey.dto.UsuarioLoginHumanRequest;
import upc.edu.pe.humankey.dto.UsuarioSolicitudDTO;
import upc.edu.pe.humankey.dto.UsuarioSolicitudHumanRequest;
import upc.edu.pe.humankey.dto.UsuarioSolicitudHumanResponse;
import upc.edu.pe.humankey.dto.UsuarioUpdatePasswordHumanRequest;
import upc.edu.pe.humankey.facade.UsuarioFacade;
import upc.edu.pe.humankey.service.UsuarioService;

@Component
@Slf4j
public class UsuarioFacadeImpl implements UsuarioFacade {
	
	@Autowired
	private UsuarioService usuarioService;
	

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public UsuarioHumanResponse login(UsuarioLoginHumanRequest request) {
		log.info("UsuarioFacadeImpl::{}","login");				
		String usuario = request.getCodigo().toUpperCase();
		String password = request.getPassword().trim();
		Usuario usuarioDatabase = usuarioService.findUserById(usuario);		
		
		if(null!=usuarioDatabase) {
			if(passwordEncoder.matches(password, usuarioDatabase.getPassword())) {
				UsuarioHumanResponse response = new UsuarioHumanResponse();
				response.setCodigo(usuarioDatabase.getCodigo());
				response.setEstado(usuarioDatabase.getEstado());
				return response;
			}
		}
		return null;
	}

	@Override
	public void updatePasswordUser(UsuarioUpdatePasswordHumanRequest request) {
		log.info("UsuarioFacadeImpl::{}","updatePasswordUser");
		Usuario usuarioDatabase = usuarioService.findUserById(request.getCodigo());
		if(null != usuarioDatabase) {
			if(passwordEncoder.matches(request.getPassword(), usuarioDatabase.getPassword())) {
				usuarioDatabase.setPassword(passwordEncoder.encode(request.getNewPassword()));
				usuarioService.updatePasswordUser(usuarioDatabase);
			}else {
				throw new CoreException("403", "Contraseñas actual es incorrecta");
			}
		}else {
			throw new CoreException("404", "Usuario no econtrado");
		}
	}

	@Override
	public UsuarioAsistenciaResponse obtenerAsistencia(String codigo) {
		log.info("UsuarioFacadeImpl::{}::{}","obtenerAsistencia",codigo);
		UsuarioAsistenciaResponse response = new UsuarioAsistenciaResponse();
		List<UsuarioAsistenciaDTO> asistencia = new ArrayList<>();
		List<UsuarioAsistencia> asistenciaBD = usuarioService.obtenerAsistencia(codigo);
		if(GenericUtil.isNotEmpty(asistenciaBD)) {
			asistenciaBD.stream().forEach(e->{
				UsuarioAsistenciaDTO a = new UsuarioAsistenciaDTO();
				a.setCodigo(e.getCodigo());
				a.setEntrada(e.getEntrada());
				a.setFecha(e.getFecha());
				a.setId(e.getId());
				a.setLaborable(e.isLaborable());
				a.setTardanza(e.isTardanza());
				a.setTipo(e.getTipo());
				asistencia.add(a);
			});
			response.setAsistencia(asistencia);
		}
		return response;
	}

	@Override
	public UsuarioSolicitudHumanResponse obtenerSolicitudes(String codigo) {
		log.info("UsuarioFacadeImpl::{}::{}","obtenerSolicitudes",codigo);
		UsuarioSolicitudHumanResponse response = new UsuarioSolicitudHumanResponse();
		List<UsuarioSolicitudDTO> solicitudes = new ArrayList<>();
		List<UsuarioSolicitud> solicitudesBD = usuarioService.obtenerSolicitudes(codigo);
		if(GenericUtil.isNotEmpty(solicitudesBD)) {
			solicitudesBD.stream().forEach(e->{
				UsuarioSolicitudDTO a = new UsuarioSolicitudDTO();
				a.setCodigo(e.getCodigo());
				a.setComision(e.getComision());
				a.setCuenta(e.getCuenta());
				a.setEstado(e.getEstado());
				a.setFecha(e.getFecha());
				a.setMonto(e.getMonto());
				solicitudes.add(a);
			});
			response.setSolicitudes(solicitudes);
		}
		return response;
	}

	@Override
	public void grabarSolicitud(UsuarioSolicitudHumanRequest request) {	
		log.info("UsuarioFacadeImpl::{}::{}","grabarSolicitud");
		UsuarioSolicitud solicitud = new UsuarioSolicitud();
		solicitud.setCodigo(request.getCodigo());
		solicitud.setComision(request.getComision());
		solicitud.setCuenta(request.getCuenta());
		solicitud.setEstado("Pendiente");		
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());		
		solicitud.setFecha(date);
		solicitud.setMonto(request.getMonto());
		usuarioService.grabarSolicitud(solicitud);
	}

}
