import { Component, OnInit } from '@angular/core';
import { Admin } from '../admin';
import { JarvisService } from '../jarvis.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-addadmin',
  templateUrl: './addadmin.component.html',
  styleUrls: ['./addadmin.component.css']
})
export class AddadminComponent implements OnInit {
  ngOnInit(){
  
  }

  admin = new Admin;

  constructor(private jarvisService : JarvisService, private router : Router
    , private activatedRoute : ActivatedRoute) { }
 
  addAdmin() {
    console.log('Admin Called');
    this.jarvisService.addAdmin(this.admin).subscribe(
      data => {
        this.router.navigate(['/admin']);
      },
      error => {
        alert(error);
      }
    );
  }

}
