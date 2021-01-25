import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms'
import {routing, appRoutingProviders} from './app.routing';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
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
import { EditUserComponent } from './components/edit-user/edit-user.component';

@NgModule({
  declarations: [
    AppComponent,
    AboutComponent,
    ProyectsComponent,
    CreateComponent,
    ContactComponent,
    EditComponent,
    DetailComponent,
    ErrorComponent,
    RegisterComponent,
    LoginComponent,
    HeaderComponent,
    EditUserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    routing,
    HttpClientModule,
    FormsModule,
    FontAwesomeModule
  
  ],
  providers: [appRoutingProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
