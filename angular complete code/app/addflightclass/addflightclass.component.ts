import { Component, OnInit } from '@angular/core';
import { Flightclass } from '../flightclass';
import { Flight } from '../flight';
import { Route } from '../route';
import { Schedule } from '../schedule';
import { Location } from '../location';
import { JarvisService } from '../jarvis.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-addflightclass',
  templateUrl: './addflightclass.component.html',
  styleUrls: ['./addflightclass.component.css']
})
export class AddflightclassComponent implements OnInit {
 

  fl = new Flightclass;
  flight : Flight[];
  flightId1:string;
  routeId1:string;
  scheduleId:string;

 
  constructor(private _jarvisservice: JarvisService, private router: Router, private activatedRoute: ActivatedRoute) { }
 
  ngOnInit() {


    this._jarvisservice.getAllFlight().subscribe(
      flight => { this.flight = flight; }
    );

    this.fl.flightClassId = +this.activatedRoute.snapshot.paramMap.get('flightClassId');
    if(this.fl.flightClassId !== null )
    {
     
      this._jarvisservice.getFlightClassById(this.fl.flightClassId).subscribe(fl => {
        this.fl = fl;
          this.flightId1 = fl.flight.flightId;
          this.routeId1 = fl.flight.route.routeId;
          this.scheduleId = fl.flight.schedule.scheduleId;

          console.log(this.fl);
        }
        );
      }

  }
  addflightclass()
  {

    console.log('Add Called');
    this.fl =
    {
   
     'flightClassId': this.fl.flightClassId,
     'flightclass': this.fl.flightclass,
     'numberOfSeats': this.fl.numberOfSeats,
     'flight': 
        {
          'flightId' : this.flightId1,
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
            'scheduleId': this.scheduleId,
            'scheduleDate':'',
            'scheduleTime':''
            }
      
        }
      };
   if(this.fl.flightClassId === undefined)
   {
    this._jarvisservice.addFlightClass(this.fl).subscribe(
      
      fc => {
        this.router.navigate(['/flightclasslist']);
      },
      error => {
        alert(error);
      });
   }
   else
   {
   this._jarvisservice.updateFlightClass(this.fl).subscribe(
      
       data => {
        this.router.navigate(['/flightclasslist']);
       },
     error => {
       alert(error);
      });
   }
   
  }




}
