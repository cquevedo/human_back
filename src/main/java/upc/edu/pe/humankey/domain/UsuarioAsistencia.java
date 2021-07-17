package upc.edu.pe.humankey.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "human_asistencia")
public class UsuarioAsistencia implements Serializable {
	
	private static final long serialVersionUID = 391269573157547336L;

	@Id
    @Column(name = "id")
    private Integer id;	
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "fecha")
    private String fecha;
    @Column(name = "entrada")
    private String entrada;
    @Column(name = "laborable")
    private boolean laborable;
    @Column(name = "tardanza")
    private boolean tardanza;
    @Column(name = "tipo")
    private String tipo;
  
	
}
