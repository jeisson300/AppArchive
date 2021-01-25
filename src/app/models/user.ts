import{Project} from './project';
 export class  User {

	constructor(
		
		public  id_user:number,
		public  username:string,
		public  name:string,
		public  password:string,
		public email: string,
		public listaArchivos: Project[]
	
		)
	{}

}