package upc.edu.pe.humankey.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioUpdatePasswordHumanRequest implements Serializable {
		
	private static final long serialVersionUID = -8448102032959897829L;
	
	private String codigo;
	private String password;
	private String newPassword;

}