import { Component, OnInit } from '@angular/core';
import { Flightclass } from '../flightclass';
import { JarvisService } from '../jarvis.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-flightclasslist',
  templateUrl: './flightclasslist.component.html',
  styleUrls: ['./flightclasslist.component.css']
})
export class FlightclasslistComponent implements OnInit {
  fl : Flightclass[];
 
  constructor(private _jarvisservice : JarvisService, private router: Router) { }
 
  ngOnInit() {
    this._jarvisservice.getAllFlightClass().subscribe( fl => {
      this.fl = fl;
      });
  }


  delete(fl: Flightclass): void{
    this._jarvisservice.deleteFlightClass(fl.flightClassId).subscribe( data => {
      
this.fl = this.fl.filter( u => u !== fl );
    }
 
    );
  }
 
  edit(fl:Flightclass):void{
    console.log('edit called');
    this.router.navigate(['admin/addflightclass',fl]);
  }

}
