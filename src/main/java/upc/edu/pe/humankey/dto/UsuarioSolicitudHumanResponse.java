package upc.edu.pe.humankey.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioSolicitudHumanResponse implements Serializable {
		
	private static final long serialVersionUID = -4418642032949897829L;
	
	private List<UsuarioSolicitudDTO> solicitudes;

}