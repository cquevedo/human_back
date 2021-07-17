package upc.edu.pe.humankey.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "human_solicitud")
public class UsuarioSolicitud implements Serializable {
	
	private static final long serialVersionUID = 391269573157547336L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;	
    @Column(name = "codigo")
    private String codigo;    
    
    @Column(name = "fecha")
    private String fecha;    
    @Column(name = "estado")
    private String estado;   
    @Column(name = "monto")
    private String monto;
    @Column(name = "comision")
    private String comision;
    @Column(name = "cuenta")
    private String cuenta;
  
	
}
