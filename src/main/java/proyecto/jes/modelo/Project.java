package proyecto.jes.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Entity
@Validated
@Data

public class Project implements Serializable {
	
	private static final long serialVersionUID = -493648649254584948L;
	
	
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id ;
	@NotEmpty
	private  String name;
	@NotEmpty
	private String category;

	
	private int year;
	@NotEmpty
	private String ruta;

}
