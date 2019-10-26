import { Component, OnInit } from '@angular/core';
import { JarvisService } from '../jarvis.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Location } from '../location';
import { Route } from '../route';


@Component({
  selector: 'app-addroute',
  templateUrl: './addroute.component.html',
  styleUrls: ['./addroute.component.css']
})
export class AddrouteComponent implements OnInit {
  locations : Location[];
  locationId1: string;
  locationId2 : string;
   
  route = new Route;
   
    constructor(private _jarvisService:JarvisService, private _router: Router,private _activatedRoute: ActivatedRoute) { }
   
    ngOnInit() {
   
      this._jarvisService.getLocation().subscribe( location =>
        {
          this.locations = location;
        });
  
      this.route.routeId=this._activatedRoute.snapshot.paramMap.get('routeId');
      if(this.route.routeId !==  null){ 
      this._jarvisService.getRouteById(this.route.routeId).subscribe( route =>{
          this.route=route;
          this.locationId1=route.source.locationId;
          this.locationId2=route.destination.locationId;
        }
   
        );
   }
   
    }
  addRouter(){
   
  if(this.route.routeId === null ){
    this.route = {
      'routeId' : this.route.routeId,
      'source': {
        'locationId': this.locationId1,
        'locationName': 'kj'
      },
      'destination' : {
        'locationId' : this.locationId2,
        'locationName' : 'germany'
      },
      'distance': this.route.distance,
      'duration': this.route.duration,
      
    };
   
    this._jarvisService.addRoute(this.route).subscribe(
      data => {
        console.log(this.route);
        this._router.navigate(['/admin/routelist']);
      }, error => {
        alert(error);
      }
    );
    }
    else{
     
        this.route = {
          'routeId' : this.route.routeId,
          'source': {
            'locationId': this.locationId1,
            'locationName': 'kj'
          },
          'destination' : {
            'locationId' : this.locationId2,
            'locationName' : 'germany'
          },
          'distance': this.route.distance,
          'duration': this.route.duration,
          
        };
        
        this._jarvisService.updateRoute(this.route).subscribe(
          data => {
            console.log(this.route);
            this._router.navigate(['/admin/routelist']);
          }, error => {
            alert(error);
          }
        );
    }
  }

}
