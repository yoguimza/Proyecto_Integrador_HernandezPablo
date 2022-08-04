import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginUsuario } from 'src/app/model/login-usuario';
import { AuthService } from 'src/app/service/auth.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
isLogged=false;
isLogginDail=false;
loginUsuario!: LoginUsuario;
nombreUsuario!: string;
password!: string;
roles: string[]=[];
errMsj!:string;

  constructor(private tokenService:TokenService,private authService:AuthService,private router:Router) { }

  ngOnInit(): void {
    
  }

}
