package proyecto.jes.service;

import javax.persistence.EntityManager;

import proyecto.jes.dao.UserDao;
import proyecto.jes.modelo.User;

public class UserService implements UserDao{
	
	public EntityManager entityManager;

	@Override
	public void agregarUser(User user) {
		// TODO Auto-generated method stub
		
		entityManager.persist(user);
		
	}

	@Override
	public void borrarUser(User user) {
		// TODO Auto-generated method stub
	
		entityManager.remove(user);
		
	}

	@Override
	public void actualizarUser(User user) {
		// TODO Auto-generated method stub
		
		
		entityManager.merge(user);
		
	}

	@Override
	public User buscarUser(User user) {
		// TODO Auto-generated method stub
		
		return user;
	}

}
