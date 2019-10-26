import { Component, OnInit } from '@angular/core';
import { JarvisService } from '../jarvis.service';
import { Router } from '@angular/router';
import { Location } from '../location';

@Component({
  selector: 'app-locationlist',
  templateUrl: './locationlist.component.html',
  styleUrls: ['./locationlist.component.css']
})
export class LocationlistComponent implements OnInit {

  locations: Location[];
  constructor(private _jarvisService : JarvisService, private _router: Router) { }
 
  ngOnInit() {
    this._jarvisService.getLocation().subscribe( location =>
      {
        this.locations = location;
      });
  }
  delete(loc: Location): void{
    this._jarvisService.deleteLocation(loc.locationId).subscribe( data => {
      
this.locations = this.locations.filter( u => u !== loc );
    }
 
    );
  }
 
edit(loc: Location): void{
 this._router.navigate(['admin/addlocation',loc]);
}
}
