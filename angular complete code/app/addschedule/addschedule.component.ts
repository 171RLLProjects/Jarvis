import { Component, OnInit } from '@angular/core';
import { JarvisService } from '../jarvis.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Schedule } from '../schedule';

@Component({
  selector: 'app-addschedule',
  templateUrl: './addschedule.component.html',
  styleUrls: ['./addschedule.component.css']
})
export class AddscheduleComponent implements OnInit {
  schedule = new Schedule;
 
  constructor(private _jarvisService : JarvisService, private router : Router
    , private activatedRoute : ActivatedRoute) { }
 
    ngOnInit() {
      this.schedule.scheduleId = this.activatedRoute.snapshot.paramMap.get('scheduleId');
      this.schedule.scheduleDate= this.activatedRoute.snapshot.paramMap.get('scheduleDate');
      this.schedule.scheduleTime = this.activatedRoute.snapshot.paramMap.get('scheduleTime');
    }
  
 
addSchedule() {
 
 
  if(this.schedule.scheduleId === null){
    console.log(this.schedule);
    this._jarvisService.addSchedule(this.schedule).subscribe(
      data => {
        this.router.navigate(['/admin/listschedule']);
      },
     error => {
        alert(error);
     });
    }
    else{
      this._jarvisService.updateSchedule(this.schedule).subscribe(
        data => {
          this.router.navigate(['/admin/listschedule']);
        },
       error => {
          alert(error);
       });
      }


 
    }

}
