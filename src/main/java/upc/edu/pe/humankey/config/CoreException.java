package upc.edu.pe.humankey.config;

import org.slf4j.Logger;
 
 
public class CoreException extends RuntimeException {

	
	private static final long serialVersionUID = 2958771822623649398L;

	public String codigo;
	public String mensaje;

	public CoreException(String codigo,String mensaje) {
		this.codigo = codigo;
		this.mensaje= mensaje;
	}


	public CoreException(Logger logger, Exception e) {
		logger.error(e.getMessage(), e);
	
		
	}
	

}
