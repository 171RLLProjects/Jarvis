import { Component, OnInit } from '@angular/core';
import { Route } from '../route';
import { Schedule } from '../schedule';
import { Flightclass } from '../flightclass';
import { Flight } from '../flight';
import { JarvisService } from '../jarvis.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Location } from '../location';

@Component({
  selector: 'app-addflight',
  templateUrl: './addflight.component.html',
  styleUrls: ['./addflight.component.css']
})
export class AddflightComponent implements OnInit {

  flight = new Flight;
  route : Route[];
  schedule : Schedule[];
  location : Location[];
  routeId1:string;
  scheduleId1:string;


  constructor(private _jarvisservice: JarvisService,private router:Router, private activatedRoute: ActivatedRoute) { }


  ngOnInit() {

    this._jarvisservice.getRoute().subscribe(
      route => { this.route = route; }
    );

    this._jarvisservice.getSchedule().subscribe(
      schedule => { this.schedule = schedule; }
    );

    this._jarvisservice.getLocation().subscribe(
      location => { this.location = location; }
    );

    this.flight.flightId = this.activatedRoute.snapshot.paramMap.get('flightId');
    if(this.flight.flightId !== null )
    {
     
      this._jarvisservice.getFlightById(this.flight.flightId).subscribe(flight => {
          this.flight=flight;
          this.routeId1 = flight.route.routeId;
          this.scheduleId1 = flight.schedule.scheduleId;
        }
        );
      }
  }

  AddFlight(){
  
    this.flight =  {
      "flightId": this.flight.flightId,
        "flightName": this.flight.flightName,
        "totalSeat": this.flight.totalSeat,
        "availableSeat": this.flight.availableSeat,
        "flightType": this.flight.flightType,
        "route": {
            "routeId": this.routeId1,
            "source": {
                "locationId": "LOC003",
                "locationName": "pune"
            },
            "destination": {
                "locationId": "LOC005",
                "locationName": "jaipur"
            },
            "distance": 20000,
            "duration": "12 am"
        },
        "schedule": {
            "scheduleId": this.scheduleId1,
            "scheduleDate": "10/may/20",
            "scheduleTime": "3:04:09 am"
        }

  };
console.log(this.flight);

      if(this.flight.flightId === null ){
        this._jarvisservice.addFlight(this.flight).subscribe(
          data => { 
            this.router.navigate(['/admin/listflight']);
          }, error => {
            alert(error);
          }
        );

      } else{    
        this._jarvisservice.updateFlight(this.flight).subscribe(
          data => {
            console.log(this.route);
            this.router.navigate(['/admin/listflight']);
          }, error => {
            alert(error);
          }
        );

      }


  }





}
