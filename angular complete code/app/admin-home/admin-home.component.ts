import { Component, OnInit } from '@angular/core';
import { JarvisService } from '../jarvis.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }
  logout(){
    this.router.navigateByUrl('/home');
  }



}
