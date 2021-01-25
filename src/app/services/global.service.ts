import {Injectable, EventEmitter} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Project} from '../models/project';
import {User} from '../models/user';
import {global} from './global';

@Injectable()

	export class ProjectService{ 

		public url:string;
		public correo :string;

		constructor(
			private _http: HttpClient
			)
		{
			this.url = global.url;
			this.correo = "";
		}

		


		/*----------------------------------------------*/

		ListProject(): Observable<any>
		{
			
			return this._http.get(this.url+"list");
		}
		
		saveProject(file: File, id: number):Observable<any>
		{
			/*var headers = new HttpHeaders().set("multipart/form-data");*/
			const formData: FormData = new FormData();
			formData.append('file', file);
			return this._http.post(this.url+"upload/"+id,formData);
		}

		buscar(id):Observable<any>
		{
			return this._http.get(this.url+"buscarProject/"+id);
		}

		eliminar(id):Observable<any>
		{
			return this._http.delete(this.url+"eliminarArchivo/"+id);
		}

		editar(project: Project):Observable<any>
		{
			
			return this._http.put(this.url+"actualizarProject/"+project.id,project);

		}
}