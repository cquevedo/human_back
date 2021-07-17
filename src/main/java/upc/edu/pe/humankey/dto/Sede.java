package upc.edu.pe.humankey.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Sede implements Serializable {
		
	private static final long serialVersionUID = -4318102032959851829L;
	
	private String code;
	private String titulo;
	private String direccion;
	private String latitud;
	private String longitud;

}