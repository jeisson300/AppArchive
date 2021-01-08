import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Project} from '../models/project';
import {global} from './global';

@Injectable()

	export class ProjectService{ 

		public url:string;

		constructor(
			private _http: HttpClient
			)
		{
			this.url = global.url;
		}

		saveProject(project: Project): Observable<any>
		{
			let params = JSON.stringify(project);
			let headers = new HttpHeaders().set("Content-Type","application/json");
			return this._http.post(this.url+"about", params, {headers: headers});
		}
		
		searchProject(project: Project):Observable<any>
		{
			let params = JSON.stringify(project);
			let headers = new HttpHeaders().set("Content-Type","application/json");
			return this._http.get(this.url+"detail/+id", {headers: headers});
		

		}
}