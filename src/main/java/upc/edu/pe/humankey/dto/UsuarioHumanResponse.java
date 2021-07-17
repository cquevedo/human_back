package upc.edu.pe.humankey.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioHumanResponse implements Serializable {
		
	private static final long serialVersionUID = -4418102032959897829L;
	
	private String codigo;
	private String estado;

}