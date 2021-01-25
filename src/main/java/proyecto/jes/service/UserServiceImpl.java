package proyecto.jes.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyecto.jes.dao.UserDao;
import proyecto.jes.modelo.Project;
import proyecto.jes.modelo.User;


@Service
public class UserServiceImpl implements UserService{
	
	@PersistenceContext
	public EntityManager entityManager;
	
	@Autowired
	public UserDao userDao;

	@Override
	@Transactional
	public void agregar(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
		
	}

	@Override
	@Transactional
	public User actualizar(User user) {
		// TODO Auto-generated method stub
		return entityManager.merge(user);
	}

	@Override
	@Transactional
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		User user = userDao.findById(id).orElse(null);
		userDao.delete(user);
		
	}

	@Override
	@Transactional
	public List<User> listarUser() {
		// TODO Auto-generated method stub
		List<User> users = userDao.findAll();
		
		return users;
	}
	
	

	@Override
	@Transactional
	public User listarUserEmail(String email) {
		// TODO Auto-generated method stub
		User user = new User();
		try {
			TypedQuery<User> q = entityManager.createNamedQuery(User.LISTAR_EMAIL, User.class);
			q.setParameter("email", email);
			user = q.getSingleResult();
			
		}catch(Exception m)
		{
			user = null;
		}
		return user;
	}
	
	
	@Override
	@Transactional
	public User validarLogin(String username, String password)
	{
		User user = new User();
		try {
			
			TypedQuery<User> q = entityManager.createNamedQuery(User.LOGIN, User.class);
			q.setParameter("username", username);
			q.setParameter("password", password);
			user = q.getSingleResult();
		}catch(Exception e)
		{
			user = null;
	
		}
		return user;
		
	}

	@Override
	@Transactional
	public List<Project> listarUserProjects(int id) {
		// TODO Auto-generated method stub
		User user = entityManager.find(User.class, id);
		List<Project> proyects = user.getListaArchivos();
		return proyects;
	}

	@Override
	@Transactional
	public void agregarUserProject(int id, Project project) {
		// TODO Auto-generated method stub
		User user = entityManager.find(User.class, id);
		user.getListaArchivos().add(project);
		
	}

	@Override
	@Transactional
	public User buscarUser(int id) {
		// TODO Auto-generated method stub
		User user = entityManager.find(User.class, id);
		return user;
	}
	
	
	

}
