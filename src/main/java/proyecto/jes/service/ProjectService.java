package proyecto.jes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import proyecto.jes.modelo.Project;

@Service
public interface ProjectService  {
	
	public Project buscar(int id);
	
	public void agregar(Project project);
	
	public void eliminar(int id);
	
	public Project actualizar(Project project);
	
	public List<Project> listar();

}
