package proyecto.jes.dao;

import proyecto.jes.modelo.User;

public interface UserDao {
	
	public void agregarUser(User user);
	
	public void borrarUser(User user);
	
	public void actualizarUser (User user);
	
	public User buscarUser(User id);

}
