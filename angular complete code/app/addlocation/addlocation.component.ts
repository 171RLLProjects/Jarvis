import { Component, OnInit } from '@angular/core';
import { JarvisService } from '../jarvis.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Location } from '../location';

@Component({
  selector: 'app-addlocation',
  templateUrl: './addlocation.component.html',
  styleUrls: ['./addlocation.component.css']
})
export class AddlocationComponent implements OnInit {
  location = new Location;
  constructor(private _jarvisService : JarvisService, private _router: Router,private _activatedRoute : ActivatedRoute) { }
 
  ngOnInit() {
    this.location.locationId= this._activatedRoute.snapshot.paramMap.get('locationId');
   this.location.locationName = this._activatedRoute.snapshot.paramMap.get('locationName');
  }
  addLocation(){
 
    if(this.location.locationId === null){
    console.log(this.location);
    this._jarvisService.addLocation(this.location).subscribe(
      data => {
        this._router.navigate(['/admin/listlocation']);
      },
     error => {
        alert(error);
     });
    }
    else{
      this._jarvisService.updateLocation(this.location).subscribe(
        data => {
          this._router.navigate(['/admin/listlocation']);
        },
       error => {
          alert(error);
       });
    }
 
  }

}
