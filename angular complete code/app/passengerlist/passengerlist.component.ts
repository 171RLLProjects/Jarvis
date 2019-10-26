import { Component, OnInit } from '@angular/core';
import { Passenger } from '../passenger';
import { JarvisService } from '../jarvis.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-passengerlist',
  templateUrl: './passengerlist.component.html',
  styleUrls: ['./passengerlist.component.css']
})
export class PassengerlistComponent implements OnInit {

  passenger : Passenger[];
 
  constructor(private _jarvisservice: JarvisService,private router:Router) { }
 
  ngOnInit() {
    this._jarvisservice.getPassenger().subscribe( passenger => {
      this.passenger = passenger;
      });
  }
 

}
