package proyecto.jes.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Entity
@Validated
@Data

@NamedQueries({
	@NamedQuery(name=Project.LISTAR_PROJECTS, query="SELECT *FROM PROJECT")
})
public class Project implements Serializable {
	
	private static final long serialVersionUID = -493648649254584948L;
	
	//consultas sql
	public static final String LISTAR_PROJECTS="LISTAR_PROJECTS";
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id ;
	@NotEmpty
	private  String name;
	@NotEmpty
	private String category;
	@NotEmpty
	private int year;
	@NotEmpty
	private String ruta;

}
