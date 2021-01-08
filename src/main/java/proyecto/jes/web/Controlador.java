package proyecto.jes.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import proyecto.jes.modelo.Project;
import proyecto.jes.modelo.User;
import proyecto.jes.service.ProjectService;
import proyecto.jes.service.UserService;

@Controller
public class Controlador {
	
	@Autowired
	public ProjectService projectService;
	
	@Autowired
	public UserService userService;
	
	
	@PostMapping("/subirProject")
	public void agregar(Project project)
	{
		projectService.agregarProject(project);
	}
	
	
	@PostMapping("/GuardarUser")
	public void agregarUser(User user)
	{
		userService.agregarUser(user);
	}
	
	@DeleteMapping("/eliminarUser/{id}")
	public void eliminarUser(User user)
	{
		userService.borrarUser(user);	
	}
	
	@PutMapping("/actualizar/{id}")
	public void actualizarUser(User user)
	{
		userService.actualizarUser(user);
	}
	
	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) throws IOException
	{
		if(file == null || file.isEmpty())
		{
			attributes.addFlashAttribute("message", "por favor seleccione un archivo");
		}
		
		StringBuilder builder = new StringBuilder();
		
		builder.append(File.separator);
		builder.append("D:\\JOSE-JEISSON\\RESPALDO_INFO\\estudio-programacion\\Recursos\\UploadJes");
		builder.append(file.getOriginalFilename());
		
		byte[] fileBytes = file.getBytes();
		Path path = Paths.get(builder.toString());
		Files.write(path, fileBytes);
		
		attributes.addFlashAttribute("message", "archivo cargado correctamente");
		return null;
	}
	
	
	

}
