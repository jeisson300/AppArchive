package proyecto.jes.service;

import java.io.File;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyecto.jes.dao.ProjectDao;
import proyecto.jes.modelo.Project;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	public ProjectDao projectDao;
	
	@PersistenceContext
	public EntityManager entityManager;

	@Override
	@Transactional
	public Project buscar(int id) {
		// TODO Auto-generated method stub
		return projectDao.findById(id).get();
		
	}

	@Override
	@Transactional
	public void agregar(Project project) {
		// TODO Auto-generated method stub
		projectDao.save(project);
		
	}

	@Override
	@Transactional
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		Project project = projectDao.findById(id).orElse(null);
		File file = new File("D:\\JOSE-JEISSON\\RESPALDO_INFO\\estudio-programacion\\ANGULAR\\proyecto-angular1\\src\\assets\\img\\"+project.getRuta());
		file.delete();
		projectDao.delete(project);
		
	}

	@Override
	@Transactional
	public Project actualizar(Project project) {
		// TODO Auto-generated method stub
		return entityManager.merge(project);
	}

	@Override
	@Transactional
	public List<Project> listar() {
		// TODO Auto-generated method stub
		
		return projectDao.findAll();
	}
	

}
