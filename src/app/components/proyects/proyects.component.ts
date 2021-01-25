import { Component, OnInit,SecurityContext } from '@angular/core';
import {UserService} from '../../services/user.services';
import {Project} from '../../models/project';

@Component({
  selector: 'app-proyects',
  templateUrl: './proyects.component.html',
  styleUrls: ['./proyects.component.css'],
  providers: [UserService]
})
export class ProyectsComponent implements OnInit {
	public projects : Project[];
 
  constructor(
  	private userService: UserService) 
  {
    
    
  }

  ngOnInit(): void {
    
     this.userService.listProjects(parseInt(sessionStorage.getItem("ref"))).subscribe(response=>
     {
       this.projects = response;
     }, error =>
     {
       console.log(error);
     })
        
  }

 


  

}
