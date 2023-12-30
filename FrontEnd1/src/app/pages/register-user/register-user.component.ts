import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']  // Fix the styleUrl to styleUrls
})
export class RegisterUserComponent implements OnInit {
  signupUsers: any[] = [];
  username: string = '';
  email: string = '';
  password: string = '';

  constructor(private httpClient: HttpClient, private router: Router) { }
  
  ngOnInit(): void {
    const localData = localStorage.getItem('signUpUsers');
    if (localData != null) {
      this.signupUsers = JSON.parse(localData);
    }
  }

  onSignUp() {
    let bodyData = {
      "username": this.username,
      "email": this.email,
      "password": this.password
    };

    this.httpClient.post("http://localhost:8080/user/register", bodyData, { responseType: 'text' })
      .subscribe((resultData: any) => {
        console.log(resultData);
        alert("Registered Successfully");
      });
  }

  onLogin() {
    let bodyData = {
      email: this.email,
      password: this.password,
    };

    this.httpClient.post("http://localhost:8080/user/login", bodyData)
      .subscribe((resultData: any) => {
        console.log(resultData);

        if (resultData.message == "Email not exists") {
          alert("Email not exists");
        } else if (resultData.message == "Login Success") {
          this.router.navigateByUrl('/menu');
        } else {
          alert("Incorrect Email or Password");
        }
      });
  }
}