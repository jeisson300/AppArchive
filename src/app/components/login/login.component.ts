import { Component, OnInit, Output, EventEmitter,Input } from '@angular/core';
import {User} from '../../models/user';
import {UserService} from '../../services/user.services';
import {Router} from '@angular/router';
import {ProjectService} from '../../services/global.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers:[UserService]
})
export class LoginComponent implements OnInit {

	public user:User;
  public mensaje : string;


  constructor(
  		private _userService: UserService,
      private router : Router
     
  	) { 
  	  this.user= new User(0,"","","","",[]);
      
  }

  ngOnInit(): void {
    
    if(localStorage.getItem("se")=="1")
      {
        localStorage.removeItem("se");
        sessionStorage.removeItem("ref");
        this.inicializar();
      }
  }

  onSubmit(form)
  {
    this._userService.validarUser(this.user).subscribe(response =>
    {
      if(response !=null)
      {
        
       this.router.navigate(["/create"]);
       sessionStorage.setItem("ref", response.id_user.toString());
      
    
      }
      else
      {
        alert("La contraseña o el usuario son incorrectos");
      }
    },error =>
    {
      console.log(error);
    })
  }

  inicializar()
    {
      location.reload();
    }


}
