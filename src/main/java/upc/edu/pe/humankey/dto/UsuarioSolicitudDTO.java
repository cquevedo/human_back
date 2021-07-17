package upc.edu.pe.humankey.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioSolicitudDTO implements Serializable {
		
	private static final long serialVersionUID = -4415102032959897829L;
		
	private String codigo;  
    private String fecha;   
    private String estado;  
    private String monto;
    private String comision;
    private String cuenta;

}