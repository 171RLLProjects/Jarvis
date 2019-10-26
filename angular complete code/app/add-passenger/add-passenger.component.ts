import { Component, OnInit } from '@angular/core';
import { Passport } from '../passport';
import { JarvisService } from '../jarvis.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Passenger } from '../passenger';
import { Flight } from '../flight';
import { Route } from '../route';
import { Schedule } from '../schedule';

import { Flightclass } from '../flightclass';
import { Location } from '../location';

@Component({
  selector: 'app-add-passenger',
  templateUrl: './add-passenger.component.html',
  styleUrls: ['./add-passenger.component.css']
})
export class AddPassengerComponent implements OnInit {
passenger = new Passenger;
flights: Flight;
flightClass : Flightclass;
flightId:string;
flightId1:string;
flightId2:string;
routeId1:string;
scheduleId1:string;
fare : number

 
  constructor(private _jarvisservice: JarvisService,private router:Router, private _activatedRoute: ActivatedRoute) { }
 
  ngOnInit() {

  console.log('called');
  this.flightId=this._activatedRoute.snapshot.paramMap.get('flightId');
  console.log(this.flightId);

    this._jarvisservice.getFlightById(this.flightId).subscribe(flight => {
      this.flights=flight;
      this.flightId1=flight.flightId;
      this.routeId1 = flight.route.routeId;
      this.scheduleId1 = flight.schedule.scheduleId;
      console.log(this.flights);
    });

      
  }

AddPassenger(){


  this.passenger = 
  {

        'passengerId': this.passenger.passengerId,
        'passengerName': this.passenger.passengerName,
        'passengerAge': this.passenger.passengerAge,
        'passengerGender': this.passenger.passengerGender,
        'passengerSeatNo': this.passenger.passengerSeatNo,
        'bookingDate': this.passenger.bookingDate,
        'passportNum':this.passenger.passportNum,
        'PassengerStatus': this.passenger.PassengerStatus,
        'flight': 
        {
          'flightId' : this.flightId,
          'availableSeat': 67,
          'flightName' : 'da',
          'flightType': '',
          'totalSeat': 97,
          'route' :
          {
            'routeId' : this.routeId1,
            'source': {
              'locationId': '',
              'locationName': 'kj'
            },
            'destination' : {
              'locationId' : '',
              'locationName' : 'germany'
            },
            'distance': 67,
            'duration': ''
          },
          'schedule':{
            'scheduleId': this.scheduleId1,
            'scheduleDate':'',
            'scheduleTime':''
            }
      
          
        }
  };

  console.log('passenger is c');
 
    this._jarvisservice.addPassenger(this.passenger).subscribe(
      passenger =>{
     
        this.fare= (this.flights.route.distance * 20)+(10*600);


        if(this.flightClass.flightclass == "Business")
        {

        }
       
      },
      error =>{
        alert(error);
      }); 
      this.router.navigate(['/viewticket/',this.passenger.passengerName]);
}
}
