package proyecto.jes.dao;

import java.util.List;

import proyecto.jes.modelo.Project;

public interface ProjectDao {
	
	public void agregarProject(Project project);
	
	public void borrarProject(int id);
	
	public void actualizarProject (int id);
	
	public Project buscarProject(int id);
	
	public List<Project> listarProject();

}
