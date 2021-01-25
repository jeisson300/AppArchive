import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

public validar : string;

  constructor() { 
  	this.validar = "";
  }

  ngOnInit(): void {
  	this.validar = localStorage.getItem("se");
  
  }

}
