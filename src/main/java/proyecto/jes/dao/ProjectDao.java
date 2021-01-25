package proyecto.jes.dao;


import org.springframework.data.jpa.repository.JpaRepository;


import proyecto.jes.modelo.Project;

public interface ProjectDao extends JpaRepository<Project, Integer> {


}
