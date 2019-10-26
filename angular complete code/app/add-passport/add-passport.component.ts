import { Component, OnInit } from '@angular/core';
import { Passport } from '../passport';
import { JarvisService } from '../jarvis.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-add-passport',
  templateUrl: './add-passport.component.html',
  styleUrls: ['./add-passport.component.css']
})
export class AddPassportComponent implements OnInit {

  passport=new Passport;
  constructor(private _jarvisservice: JarvisService,private router:Router, private activatedRoute: ActivatedRoute){}
  
  ngOnInit() {
    
  } 
  AddPassport(){
 
    console.log("passport is called");
    if( this.passport.passportId !== null ){
    this._jarvisservice.addPassport(this.passport).subscribe(
      passport =>{
        this.router.navigate(['/passportlist']);
      },
      error =>{
        alert(error);
      }); 
    }
}

}
