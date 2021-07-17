package upc.edu.pe.humankey.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioAsistenciaResponse implements Serializable {
		
	private static final long serialVersionUID = -4418102032959897829L;
	
	private List<UsuarioAsistenciaDTO> asistencia;

}