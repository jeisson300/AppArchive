package proyecto.jes.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import proyecto.jes.dao.ProjectDao;
import proyecto.jes.modelo.Project;

public class ProjectService implements ProjectDao {
	
	public EntityManager entityManager;

	@Override
	public void agregarProject(Project project) {
		// TODO Auto-generated method stub
		entityManager.persist(project);
		
	}

	@Override
	public void borrarProject(int id) {
		// TODO Auto-generated method stub
		
		Project project = entityManager.find(Project.class, id);
		entityManager.remove(project);
		
	}

	@Override
	public void actualizarProject(int id) {
		// TODO Auto-generated method stub
		Project project = entityManager.find(Project.class, id);
		entityManager.merge(project);
		
		
	}

	@Override
	public Project buscarProject(int id) {
		// TODO Auto-generated method stub
		Project project = entityManager.find(Project.class, id);
		
		return project;
	}

	@Override
	public List<Project> listarProject() {
		// TODO Auto-generated method stub
		
		TypedQuery<Project> q = entityManager.createNamedQuery(Project.LISTAR_PROJECTS,Project.class);
		List<Project> projects = q.getResultList();
		return projects;
	}

}
