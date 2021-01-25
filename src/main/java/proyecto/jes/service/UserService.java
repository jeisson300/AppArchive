package proyecto.jes.service;


import java.util.List;

import org.springframework.stereotype.Service;

import proyecto.jes.modelo.Project;
import proyecto.jes.modelo.User;

@Service
public interface UserService {
	
		public void agregar(User user);
		
		public User actualizar(User user);
		
		public void eliminar(int id);
		
		public List<User> listarUser();
		
		public User listarUserEmail(String email);
		
		public User validarLogin(String username, String password);
		
		public List<Project> listarUserProjects(int id);
		
		public void agregarUserProject(int id, Project project);
		
		public User buscarUser(int id );
	
}
