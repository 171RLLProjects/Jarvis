import { Component, OnInit } from '@angular/core';
import { JarvisService } from '../jarvis.service';
import { Router } from '@angular/router';
import { Flight } from '../flight';
import { Route } from '../route';
import { Schedule } from '../schedule';

@Component({
  selector: 'app-flightlist',
  templateUrl: './flightlist.component.html',
  styleUrls: ['./flightlist.component.css']
})
export class FlightlistComponent implements OnInit {

  flight : Flight[];

 

  constructor(private _jarvisService : JarvisService, private _router: Router) { }

  ngOnInit() {
    this._jarvisService.getAllFlight().subscribe( flight =>
      {
        this.flight = flight;
      });

   
  }


  delete(flight: Flight): void{
    this._jarvisService.deleteFlight(flight.flightId).subscribe( data => {
      
this.flight = this.flight.filter( u => u !== flight );
    }
 
    );
  }
 
edit(flight: Flight): void{
 this._router.navigate(['admin/addflight',flight]);
}

}
