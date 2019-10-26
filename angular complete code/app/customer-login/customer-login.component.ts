import { Component, OnInit } from '@angular/core';

import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { JarvisService } from '../jarvis.service';
import { Router, ActivatedRoute } from '@angular/router';
import { first } from 'rxjs/operators';
import { Userprofile } from '../userprofile';


@Component({
  selector: 'app-customer-login',
  templateUrl: './customer-login.component.html',
  styleUrls: ['./customer-login.component.css']
})
export class CustomerLoginComponent implements OnInit {


  userProfile : Userprofile;
  userName :string;
  userPass: string;
  loginForm: FormGroup;
  submitted = false;
  invalidLogin = false;
  
  constructor(private formBuilder: FormBuilder,private _jarvisService : JarvisService,private _router:Router,private _activatedRouter:ActivatedRoute) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      userName: ['', Validators.required],
      userPass: ['', Validators.required]
    });
  }
 

  onSubmit(){

    this.submitted = true;
    if (this.loginForm.invalid) {
      return;
    }
    this._jarvisService.userlogin(this.userName, this.userPass)
    .pipe(first())
    .subscribe(
      userProfile => {
        this. userProfile =  userProfile;
         
            this._router.navigate(['/customer']);
        },
        error => {
          this.invalidLogin = true;
        });

  }

}
