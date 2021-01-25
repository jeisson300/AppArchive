import { Component, OnInit, Input } from '@angular/core';
import {Project} from '../../models/project';
import {ProjectService} from '../../services/global.service';
import {UserService} from '../../services/user.services';
import {Router,ActivatedRoute, Params} from '@angular/router';
@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css'],
  providers: [ProjectService,UserService]
})
export class CreateComponent implements OnInit {

	public title: string;
	public res : boolean;
	public file: File;


	  constructor(
	  		private _projectService: ProjectService,
	  		private  router:Router,
  			private route: ActivatedRoute,
  			private userService: UserService
	  	) {
	  		this.title = "Subir Archivo";
	  		this.res = false;
	  		
	  	 }


	  ngOnInit(): void {
	  	
	  		 if(localStorage.getItem("se")==null)
	  		{
	  			this.inicializar();
	  		}
	  		
  	  	}

	  	

	  onSubmit(form)
	  {
	  	if(this.file== undefined) alert("Seleccione un archivo");
	  	else{
	  	this._projectService.saveProject(this.file).subscribe(
		response=>
		{
			
		var mens = "";
		if(response == null)
		{
			mens = "Error el archivo ya se encuentra registrado";
		}
		else
		{
			mens = "El archivo se subio con exito";
			this.userService.saveUserProject(parseInt(sessionStorage.getItem("ref")),response).subscribe(
				response=>
				{
					console.log(response);
				},error=>
				{
					console.log(error);
				})
		}
			alert(mens);

		},error =>{
			console.log(<any>error);
			
		});

	  	}

	  	
	  }

	  fileChangeEvent(event)
	  {
	  	this.file =event.target.files[0];
	  
	  }


	  inicializar()
	  {
	  	localStorage.setItem("se","1");
	  	location.reload();
	  }

}
