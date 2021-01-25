import { Component, OnInit } from '@angular/core';
import {ProjectService} from '../../services/global.service';
import {Router, ActivatedRoute, Params} from '@angular/router';
import {Project} from '../../models/project';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css'],
  providers:[ProjectService]
})
export class DetailComponent implements OnInit {

	public project : Project;
  

  constructor(
  	private _router: Router,
  	private servicio: ProjectService,
  	private _route: ActivatedRoute
  	) {
  	this.project = new Project(0,"","","","");
   
  	 }

  ngOnInit(): void {
  	this._route.params.subscribe(params =>
  	{
  		let id = params.id;

  		this.buscarProject(id);
  	});
  }

  buscarProject(id)
  {
  	this.servicio.buscar(id).subscribe(
  		response=>
  		{	
  			this.project = response;
  			

  		}, error =>
  		{
  			console.log(error);
  		});
  }

  eliminar(id)
  {
  	this.servicio.eliminar(id).subscribe(
  		response =>
  		{
  			this._router.navigate(["/proyects"]);

  		},error=>
  		{
  			console.log(error);
  		})
  }

  editar(ruta, id)
  {
    
  	this._router.navigate(["/edit/"+ruta+"-"+id+"-"+this.project.category]);
  }

}
