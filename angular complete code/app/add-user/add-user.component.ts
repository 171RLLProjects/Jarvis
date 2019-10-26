import { Component, OnInit } from '@angular/core';
import { Userprofile } from '../userprofile';
import { JarvisService } from '../jarvis.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {
  userProfile= new Userprofile;
 
  constructor(private _jarvisservice: JarvisService, private router: Router, private activatedRoute: ActivatedRoute) { }
   
    ngOnInit() {
      this.userProfile.userId = this.activatedRoute.snapshot.paramMap.get('userId');
      this.userProfile.userName = this.activatedRoute.snapshot.paramMap.get('userName');
      this.userProfile.userPass = this.activatedRoute.snapshot.paramMap.get('userPass');
      this.userProfile.dob = this.activatedRoute.snapshot.paramMap.get('dob');
      this.userProfile.email = this.activatedRoute.snapshot.paramMap.get('email');
      this.userProfile.gender = this.activatedRoute.snapshot.paramMap.get('gender');
      const mobileNo= this.activatedRoute.snapshot.paramMap.get('mobileNo');
      this.userProfile.mobileNo = +mobileNo;
      this.userProfile.permanentAddress = this.activatedRoute.snapshot.paramMap.get('permanentAddress');
      this.userProfile.presentAddress = this.activatedRoute.snapshot.paramMap.get('presentAddress');
    }
   
    AddUser(){
   console.log('called');
   if(this.userProfile.userId ===null){
   
    this._jarvisservice.addUser(this.userProfile).subscribe(
      userProfile => {
        this.router.navigate(['/userlist']);
        console.log('Okcalled');
      },
      error => {
        console.log('Erorcalled');
        alert(error);
      });
    }else{
      this._jarvisservice.updateUser(this.userProfile).subscribe(
        userProfile => {
          this.router.navigate(['/userlist']);
          console.log('Okcalled');
        },
        error => {
          console.log('Erorcalled');
          alert(error);
        });
    }
  }

}
