import {Injectable,Output,EventEmitter} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Project} from '../models/project';
import {global} from './global';
import {User} from '../models/user';


@Injectable()

export class UserService
{

	public url: string;
	

	constructor(
		private _http :HttpClient
		)
	{ 
		this.url = global.url;
		
	}



	saveUser(user:User ):Observable<any>
	{

		return this._http.post(this.url+"GuardarUser",user);
	}

	validarUser(user: User): Observable<any>
	{
		return this._http.post(this.url+"validarL",user);
	}

	listProjects (id:number):Observable<any>
	{
		return this._http.get(this.url+"listProject/"+id);
	}

	saveUserProject(id: number, project: Project):Observable<any>
	{
		return this._http.post(this.url+"guardarUserProject/"+id,project);
	}

	buscarUser(id: number):Observable<any>
	{
		return this._http.get(this.url+"buscarUser/"+id);
	}

	editUser(user: User):Observable<any>
	{
		return this._http.put(this.url+"actualizar/"+user.id_user, user);
	}

	eliminarUser(id: number):Observable<any>
	{
		return this._http.delete(this.url+"eliminarUser/"+id);
	}
}