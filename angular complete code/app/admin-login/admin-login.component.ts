import { Component, OnInit } from '@angular/core';
import { Admin } from '../admin';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { JarvisService } from '../jarvis.service';
import { Router, ActivatedRoute } from '@angular/router';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  admin : Admin;
  adminName :string;
  adminPass: string;
  loginForm: FormGroup;
  submitted = false;
  invalidLogin = false;
  
  constructor(private formBuilder: FormBuilder,private _jarvisService : JarvisService,private _router:Router,private _activatedRouter:ActivatedRoute) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      adminName: ['', Validators.required],
      adminPass: ['', Validators.required]
    });
  }

  onSubmit(){

    this.submitted = true;
    if (this.loginForm.invalid) {
      return;
    }
    this._jarvisService.login(this.adminName, this.adminPass)
    .pipe(first())
    .subscribe(
        admin => {
        this.admin = admin;
         
            this._router.navigate(['/admin']);
        },
        error => {
          this.invalidLogin = true;
        });

  }

}
