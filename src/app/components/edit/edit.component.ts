import { Component, OnInit } from '@angular/core';
import {ProjectService} from '../../services/global.service';
import {Router, ActivatedRoute, Params} from '@angular/router';
import {Project} from '../../models/project';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css'],
  providers:[ProjectService]
})
export class EditComponent implements OnInit {

	public ruta :string;
	public project: Project;
  public id: number;
  public category: string;

  constructor(
  	private _router:Router,
  	private _service:ProjectService,
  	private _route: ActivatedRoute
  	) { 

  	this.ruta= "";
    this.id  = 0;
    this.category = "";
  	this.project = new Project(0, "","","","");
  }

  ngOnInit(): void {
  	this._route.params.subscribe(params =>
  	{	
      var value = params.id;
      var values = value.split("-");
  		this.ruta = values[0];
      this.id = parseInt(values [1],10);
      this.category = values[2];
  	});
  }

  onSubmit(form)
  {
    this.project.ruta =this.ruta;
    this.project.id = this.id;
    this.project.category = this.category;
    console.log(this.project);
    this._service.editar(this.project).subscribe(response=>
    {
      
      this._router.navigate(["/proyects"]);
    },error=>
    {
      console.log(error);
    });


  }




}
