package proyecto.jes.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import proyecto.jes.modelo.Project;
import proyecto.jes.modelo.User;
import proyecto.jes.service.ProjectService;
import proyecto.jes.service.UserService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class Controlador {
	
	@Autowired
	public ProjectService projectService;
	
	@Autowired
	public UserService userService;
	
	
	
	@PostMapping("/upload/{id_user}")
	public Project uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes, @ModelAttribute User user) throws IOException
	{
		if(file == null || file.isEmpty())
		{
			attributes.addFlashAttribute("message", "por favor seleccione un archivo");
		}
		
		StringBuilder builder = new StringBuilder();
	//	builder.append(System.getProperty("user.home"));
		builder.append("D:\\JOSE-JEISSON\\RESPALDO_INFO\\estudio-programacion\\ANGULAR\\proyecto-angular1\\src\\assets\\img");
//		builder.append(File.separator);
//		builder.append("recursos");
		builder.append(File.separator);
		builder.append(file.getOriginalFilename());
		
		byte[] fileBytes = file.getBytes();
		Path path = Paths.get(builder.toString());
		Files.write(path, fileBytes);
		
		attributes.addFlashAttribute("message", "archivo cargado correctamente");
		
		Project project = new Project();
		String fileName = file.getOriginalFilename();
		project.setRuta(fileName);
		String []position = fileName.split("\\.");
		String fe = "";
		int i = fileName.lastIndexOf('.');
		if (i > 0) {
		    fe = fileName.substring(i+1);
		}
		
		project.setName(position [0]);
		
		if(fe.equalsIgnoreCase("png")||fe.equalsIgnoreCase("jpg")||fe.equalsIgnoreCase("jpeg"))
		{
			project.setCategory("imagen");
		}
		else {
			project.setCategory("archivo");
		}
		Calendar ca = Calendar.getInstance();
		
		String year = String.valueOf(ca.get(Calendar.YEAR));
		project.setYear(Integer.parseInt(year));
		
		
		boolean validar = agregarProject(project, user);
		if(validar ==false)
		{
			return project;
		}
		else
		{
			return null;
		}
		
	}
	
	public boolean verificar(Project project, User user)
	{
		
		List<Project> projects = userService.listarUserProjects(user.getId_user());
		boolean validar = false;
		for (Project p : projects) {
			if(p.getRuta().equalsIgnoreCase(project.getRuta()))
			{
				validar = true;
			}
		}	
		return validar;
	}
	
	public boolean agregarProject(Project project, User user)
	{
		boolean validar = verificar(project, user);
		
		
		if(validar == false)
		{
			projectService.agregar(project);
			
		}
		
		return validar;
	}
	
	@DeleteMapping("/eliminarArchivo/{id}")
	public void borrarProject(Project project)
	{
		projectService.eliminar(project.getId());
		
	}
	
	@PutMapping("/actualizarProject/{id}")
	public void actualizarProject(@RequestBody Project project)
	{
		projectService.actualizar(project);
	}
	
	@GetMapping("/buscarProject/{id}")
	public Project buscarProject(Project project)
	{
		return projectService.buscar(project.getId()); 
	}
	
	@GetMapping("/list")
	public List<Project> listarProject()
	{
		
		return  projectService.listar();
		 
	}
	
	
	
	//----------- metodos del user----------//
	
	//----------- metodo para validar user----//
	

	
	
	@PostMapping("/GuardarUser")
	public boolean agregarUser(@RequestBody User user)
	{
		boolean validar = true;
		User u = userService.listarUserEmail(user.getEmail());
		if(u == null)
		{	
			validar = false;
			userService.agregar(user);
		}
		
		return validar;
		
	}
	
	@DeleteMapping("/eliminarUser/{id_user}")
	public void eliminarUser(User user)
	{
		userService.eliminar(user.getId_user());	
	}
	
	@PutMapping("/actualizar/{id_user}")
	public void actualizarUser(@RequestBody User user)
	{
		userService.actualizar(user);
	}
	
	@PostMapping("/validarL")
	public User determinarLoguin(@RequestBody User user)
	{
		
		user = userService.validarLogin(user.getUsername(), user.getPassword());
		return user;
	}
	
	@GetMapping("/listProject/{id_user}")
	public List<Project> listarProjectUser(User user)
	{
		List<Project> projects = userService.listarUserProjects(user.getId_user());
		return projects;
	}
	
	@PostMapping("/guardarUserProject/{id_user}")
	public  void agregarUserProject(User user, @RequestBody Project project)
	{
		userService.agregarUserProject(user.getId_user(), project);
		
	}
	
	@GetMapping("/buscarUser/{id_user}")
	public User buscarUser(User user)
	{
		return userService.buscarUser(user.getId_user());
	}
	
	

}
