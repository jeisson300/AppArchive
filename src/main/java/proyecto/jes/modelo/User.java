package proyecto.jes.modelo;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Validated
@Entity
@Data
public class User implements Serializable{

	
	private static final long serialVersionUID = 8852172331746181893L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty
	private String user;
	@NotEmpty
	private String name;
	@NotEmpty
	private String  password;
	@NotEmpty
	private  String email;


}
