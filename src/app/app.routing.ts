import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import { AboutComponent } from './components/about/about.component';
import { ProyectsComponent } from './components/proyects/proyects.component';
import { CreateComponent } from './components/create/create.component';
import { ContactComponent } from './components/contact/contact.component';
import { EditComponent } from './components/edit/edit.component';
import { DetailComponent } from './components/detail/detail.component';
import { ErrorComponent } from './components/error/error.component';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { HeaderComponent } from './components/header/header.component';
import {EditUserComponent} from './components/edit-user/edit-user.component';

const appRoutes: Routes = [

{path:'', component:AboutComponent},
{path:'about', component:AboutComponent},
{path:'proyects', component:ProyectsComponent},
{path:'create', component:CreateComponent},
{path:'contact', component:ContactComponent},
{path:'edit/:id', component:EditComponent},
{path:'detail/:id', component:DetailComponent},
{path:'login', component:LoginComponent},
{path:'register', component: RegisterComponent},
{path:'header',component:HeaderComponent},
{path:'edit-user', component:EditUserComponent},
{path:'**', component:ErrorComponent},


];

export const appRoutingProviders: any[]=[];
export const routing: ModuleWithProviders<any> = RouterModule.forRoot(appRoutes);