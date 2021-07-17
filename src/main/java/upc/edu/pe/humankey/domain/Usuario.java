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
@Table(name = "human_user")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 391269273157547336L;

	@Id
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "password")
    private String password;
    @Column(name = "estado")
    private String estado;
  
	
}
