package proyecto.jes.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Validated
@Entity
@Data
@NamedQueries({
	@NamedQuery(name =User.LISTAR_EMAIL, query="select u from User u where u.email = :email"),
	@NamedQuery(name =User.LOGIN, query="select u from User u where u.username = :username and u.password = :password")
})
public class User implements Serializable{

	
	private static final long serialVersionUID = 8852172331746181893L;
	
	//consultas jpql
	public static final  String LISTAR_EMAIL ="LISTAR_EMAIL"; 
	public static final String LOGIN ="LOGIN";
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_user;
	@NotEmpty
	private String username;
	@NotEmpty
	private String name;
	@NotEmpty
	private String  password;
	@NotEmpty
	private  String email;
	
	@OneToMany
	@JoinColumn(name="id_user")
	private List<Project> listaArchivos;


}
