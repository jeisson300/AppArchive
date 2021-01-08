import { Component, OnInit } from '@angular/core';
import {ProjectService} from '../../services/global.service';
import {Project} from '../../models/project';
@Component({
  selector: 'app-proyects',
  templateUrl: './proyects.component.html',
  styleUrls: ['./proyects.component.css'],
  providers: [ProjectService]
})
export class ProyectsComponent implements OnInit {
	public projects : Project[];
	public project : Project;
  public project2 : Project;
  public project3 : Project;
  constructor(
  	private _projectService: ProjectService
  	) {
  	this.project = new Project(112,"ajedrez","videojuego","Maz 2021","imagen");
    this.project2 = new Project(112,"appnaria","aplicacion web","Ene 2021","imagen");
    this.project3 = new Project(112,"firewar","videojuego","Oct 2025","imagen");
  	this.projects = [this.project,this.project2,this.project3];
  	 }

  ngOnInit(): void {

  }

}
