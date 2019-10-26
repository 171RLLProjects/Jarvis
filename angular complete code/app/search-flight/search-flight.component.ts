import { Component, OnInit } from '@angular/core';
import { Flight } from '../flight';
import { FormBuilder } from '@angular/forms';
import { JarvisService } from '../jarvis.service';
import { Router, ActivatedRoute } from '@angular/router';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-search-flight',
  templateUrl: './search-flight.component.html',
  styleUrls: ['./search-flight.component.css']
})
export class SearchFlightComponent implements OnInit {
  flight = new Flight;
  flights: Flight[];

  sourceId: string;
  destinationId: string;
  scheduleId: string;


  constructor(private formBuilder: FormBuilder, private _jarvisService: JarvisService, private _router: Router, private _activatedRouter: ActivatedRoute) { }

  ngOnInit() {

  }

  ser() {

    
if(this.scheduleId === undefined)
{
  this._jarvisService.getFlightBySrcAndDes(this.sourceId, this.destinationId).subscribe
  (
    flights => {
      this.flights = flights;
      console.log(this.flights +'from ROUTE');

    }
  );
}else{
    this._jarvisService.getFlightBySrcAndDesAndSch(this.sourceId, this.destinationId, this.scheduleId).subscribe
      (
        flights => {
          this.flights = flights;
          console.log(this.flights + 'from SCHDEULE');

        }
      );
      }
  }



book(fl: Flight):void{
  this._jarvisService.booking(fl.flightId).subscribe(flight => {
    console.log('update callled');
  

  this._router.navigate(['/addpassenger/',fl.flightId]);
  console.log(fl.flightId);



  }
  );
}

}
