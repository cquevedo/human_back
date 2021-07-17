package upc.edu.pe.humankey.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import lombok.extern.slf4j.Slf4j;
import upc.edu.pe.humankey.config.CoreException;
import upc.edu.pe.humankey.dto.Sede;
import upc.edu.pe.humankey.dto.SedeResponse;
import upc.edu.pe.humankey.dto.UsuarioAsistenciaResponse;
import upc.edu.pe.humankey.dto.UsuarioHumanResponse;
import upc.edu.pe.humankey.dto.UsuarioLoginHumanRequest;
import upc.edu.pe.humankey.dto.UsuarioSolicitudHumanRequest;
import upc.edu.pe.humankey.dto.UsuarioSolicitudHumanResponse;
import upc.edu.pe.humankey.dto.UsuarioUpdatePasswordHumanRequest;
import upc.edu.pe.humankey.facade.UsuarioFacade;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/usuario")
@Slf4j
public class UsuarioRestController {
	
	
	
	@Autowired
	private UsuarioFacade usuarioFacade;

	@CrossOrigin("*")
	@PostMapping("/login")
	public UsuarioHumanResponse login(@RequestBody UsuarioLoginHumanRequest request) {
		log.info("UsuarioRestController::login");
		UsuarioHumanResponse response = usuarioFacade.login(request);
		if(null!=response) {
			return response;
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "usuario y/o contraseña incorrecta");
		}		
	}	
	
	@CrossOrigin("*")
	@PostMapping("/update")
	public void update(@RequestBody UsuarioUpdatePasswordHumanRequest request) {
		log.info("UsuarioRestController::update");
		try {
			usuarioFacade.updatePasswordUser(request);
		} catch (CoreException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	
	@CrossOrigin("*")
	@GetMapping("/asistencia/{codigo}")
	public UsuarioAsistenciaResponse getAsistencia(@PathVariable String codigo) {
		log.info("getAsistencia {}",codigo);
		return usuarioFacade.obtenerAsistencia(codigo);
	}
	
	
	@CrossOrigin("*")
	@PostMapping("/grabarSolicitud")
	public void grabarSolicitud(@RequestBody UsuarioSolicitudHumanRequest request) {
		log.info("UsuarioRestController::grabarSolicitud");
		usuarioFacade.grabarSolicitud(request);		
	}	
	
	@CrossOrigin("*")
	@GetMapping("/solicitud/{codigo}")
	public UsuarioSolicitudHumanResponse getSolicitudes(@PathVariable String codigo) {
		log.info("getSolicitudes {}",codigo);
		return usuarioFacade.obtenerSolicitudes(codigo);
	}
	
	
	@CrossOrigin("*")
	@GetMapping("/sedes")
	public SedeResponse getSedes() {
		log.info("getSedes {}");
		SedeResponse r = new SedeResponse();
		List<Sede> sedes = new ArrayList<>();
		Sede sede1 = new Sede();
		sede1.setCode("SB");
		sede1.setTitulo("Local de San Borja");
		sede1.setDireccion("Schubert, San Borja 15037");
		sede1.setLatitud("-12.101963308109084");
		sede1.setLongitud("-76.99323758552633");
		
		Sede sede2 = new Sede();
		sede2.setCode("IN");
		sede2.setTitulo("Local de Independencia");
		sede2.setDireccion("Av Industrial 3291");
		sede2.setLatitud("-11.999051");
		sede2.setLongitud("-77.058446");		 
		
		sedes.add(sede1);
		sedes.add(sede2);
		r.setSedes(sedes);
		return r;
	}
	
}
