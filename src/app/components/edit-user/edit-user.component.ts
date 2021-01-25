import { Component, OnInit } from '@angular/core';
import {UserService} from '../../services/user.services';
import {User} from '../../models/user';
import {Router} from '@angular/router';
@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css'],
  providers: [UserService]
})
export class EditUserComponent implements OnInit {

	public user: User;

  constructor(
  	private userService : UserService,
  	private router:Router
  	) { 
  	this.user= new User(0,"","","","",[]);
  }

  ngOnInit(): void {
  	this.userService.buscarUser(parseInt(sessionStorage.getItem("ref"))).subscribe(response =>
  	{
  		this.user = response;
  	},error =>
  	{
  		console.log(error);
  	})

  }

  onSubmit(from)
  {

  	this.userService.editUser(this.user).subscribe(response =>
  	{
  		alert("Usuario actualizado con exito");

  	},error =>
  	{
  		console.log(error);
  	})
  }

  eliminar(id: number)
  {
  	this.userService.eliminarUser(id).subscribe(response =>
  	{
  		alert("eliminado con exito");
  		this.router.navigate(["/login"]);
  	},error =>
  	{
  		console.log(error);
  	})
  }

}
