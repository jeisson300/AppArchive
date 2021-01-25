package proyecto.jes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import proyecto.jes.modelo.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	

}
