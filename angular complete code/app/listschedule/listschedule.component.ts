import { Component, OnInit } from '@angular/core';
import { Schedule } from '../schedule';
import { JarvisService } from '../jarvis.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-listschedule',
  templateUrl: './listschedule.component.html',
  styleUrls: ['./listschedule.component.css']
})
export class ListscheduleComponent implements OnInit {
  schedule : Schedule[];
  constructor(private _jarvisService : JarvisService, private router : Router
    , private activatedRoute : ActivatedRoute) { }
 
  ngOnInit() {
    this._jarvisService.getSchedule().subscribe(schedule =>
      {
        this.schedule = schedule;
      });
    
  }
  
  delete (schedule : Schedule): void {
    this._jarvisService.deleteSchedule(schedule.scheduleId).subscribe(
      data => {
        this.schedule = this.schedule.filter (u => u !== schedule);
      }  
      );
  }
edit (schedule : Schedule) : void {
  this.router.navigate(['admin/addschedule',schedule]);
}
}
