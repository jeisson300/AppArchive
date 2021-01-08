import { Component, OnInit } from '@angular/core';
import {ProjectService} from '../../services/global.service';
import {User} from '../../models/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers:[ProjectService]
})
export class LoginComponent implements OnInit {

	public user:User;



  constructor(
  		private _projectService: ProjectService
  	) { 
  	this.user = new User ("","","","");
  }

  ngOnInit(): void {
  }

  onSubmit(form)
  {

  }


}
