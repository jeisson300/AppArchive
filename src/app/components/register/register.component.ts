import { Component, OnInit } from '@angular/core';
import {ProjectService} from '../../services/global.service';
import {User} from '../../models/user';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  providers:[ProjectService]
})
export class RegisterComponent implements OnInit {

	public username:User;

  constructor(
  	private _projectService:ProjectService
  	) {
  	this.username= new User("","","","");
   }

  ngOnInit(): void {
  }

  onSubmit(from)
  {

  }

}
