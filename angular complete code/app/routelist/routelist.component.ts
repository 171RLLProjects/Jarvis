import { Component, OnInit } from '@angular/core';
import { Route } from '../route';
import { JarvisService } from '../jarvis.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-routelist',
  templateUrl: './routelist.component.html',
  styleUrls: ['./routelist.component.css']
})
export class RoutelistComponent implements OnInit {

  routes: Route[];
  constructor(private _jarvisService: JarvisService,private _router: Router) { }
 
  ngOnInit() {
    this._jarvisService.getRoute().subscribe ( routes => {
      this.routes = routes;
    }
 
    );
  }
 
  delete(route: Route): void{
    this._jarvisService.deleteRoute(route.routeId).subscribe( routes => {
      this.routes = this.routes.filter( u => u !== route );
    }
 
    );
  }
 
edit(route: Route):void{
  this._router.navigate(['admin/addroute',route]);
}

}
