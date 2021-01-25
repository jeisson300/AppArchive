import { Component, OnInit } from '@angular/core';
import {ProjectService} from '../../services/global.service';
import {User} from '../../models/user';
import {UserService} from '../../services/user.services';
import {Router} from '@angular/router';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  providers:[UserService]
})
export class RegisterComponent implements OnInit {

	public user:User;

  constructor(
  	private _userService:UserService,
    private router:Router
  	) {
  	this.user= new User(0,"","","","",[]);
   }

  ngOnInit(): void {
  }

  onSubmit(from)
  {
    this._userService.saveUser(this.user).subscribe(response =>
    {
      
      if(response == true)
      {
        alert("Error, el usuario ya tiene un correo asociado");
      }
      else{
        alert("El usuario se registro con exito");
         this.router.navigate(["/login"]);
      }

    },error =>
    {
      console.log(error);

    });
  }

}
