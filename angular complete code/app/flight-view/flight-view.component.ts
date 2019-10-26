import { Component, OnInit } from '@angular/core';
import { JarvisService } from '../jarvis.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Flight } from '../flight';
import { Route } from '../route';
import { Schedule } from '../schedule';

@Component({
  selector: 'app-flight-view',
  templateUrl: './flight-view.component.html',
  styleUrls: ['./flight-view.component.css']
})
export class FlightViewComponent implements OnInit {

  flight = new Flight;
 

  constructor(private _jarvisservice: JarvisService, private router: Router, private activatedRoute: ActivatedRoute) { }
  ngOnInit() {
  
    


  }

}
