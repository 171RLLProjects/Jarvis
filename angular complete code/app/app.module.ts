import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { JarvisService } from './jarvis.service';
import { AddadminComponent } from './addadmin/addadmin.component';
import { AddscheduleComponent } from './addschedule/addschedule.component';
import { ListscheduleComponent } from './listschedule/listschedule.component';
import { AddPassportComponent } from './add-passport/add-passport.component';
import { AddPassengerComponent } from './add-passenger/add-passenger.component';
import { AddUserComponent } from './add-user/add-user.component';
import { AddlocationComponent } from './addlocation/addlocation.component';
import { LocationlistComponent } from './locationlist/locationlist.component';
import { AddrouteComponent } from './addroute/addroute.component';
import { RoutelistComponent } from './routelist/routelist.component';
import { AddflightComponent } from './addflight/addflight.component';
import { FlightlistComponent } from './flightlist/flightlist.component';
import { AddflightclassComponent } from './addflightclass/addflightclass.component';
import { FlightclasslistComponent } from './flightclasslist/flightclasslist.component';
import { CustomerLoginComponent } from './customer-login/customer-login.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';

import { AdminHomeComponent } from './admin-home/admin-home.component';
import { CustomerHomeComponent } from './customer-home/customer-home.component';
import { FlightViewComponent } from './flight-view/flight-view.component';
import { SearchFlightComponent } from './search-flight/search-flight.component';
import { TicketconfrimComponent } from './ticketconfrim/ticketconfrim.component';
import { ViewticketComponent } from './viewticket/viewticket.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { UserlistComponent } from './userlist/userlist.component';
import { PassengerlistComponent } from './passengerlist/passengerlist.component';

const appRoutes: Routes = [

  { path: 'home', component: HomeComponent },
  { path: 'customerlogin', component: CustomerLoginComponent },
  { path: 'addUser', component: AddUserComponent},
  { path: 'adminlogin', component: AdminLoginComponent },
  { path: 'customer', component: CustomerHomeComponent, 
  children : [
  {path: 'flightview', component: FlightViewComponent},
  { path: 'searchflight', component: SearchFlightComponent },
 
  ]
},
  { path: 'ticketconfrim', component: TicketconfrimComponent },
  { path: 'addpassenger/:flightId', component: AddPassengerComponent },
  { path: 'viewticket/:passengerName', component: ViewticketComponent },
  {path: 'admin', component: AdminHomeComponent, children : [
    { path: 'addflight', component: AddflightComponent },
    { path: 'listflight', component: FlightlistComponent },
    { path: 'listflightclass', component: FlightclasslistComponent },
    { path: 'addlocation', component: AddlocationComponent },
    { path: 'listlocation', component: LocationlistComponent },
    { path: 'addroute', component: AddrouteComponent },
    { path: 'listroute', component: RoutelistComponent },
    { path: 'addschedule', component: AddscheduleComponent },
    { path: 'listschedule', component: ListscheduleComponent },
    { path: 'addflightclass', component: AddflightclassComponent },
    { path: 'listpassenger', component: PassengerlistComponent },
    { path: 'listuser', component:  UserlistComponent },
    { path: 'addadmin', component: AddadminComponent},
  ]},
 
{ path: '', redirectTo: '/home' , pathMatch: 'full'},
{path: '**', component: PagenotfoundComponent}
];
@NgModule({
  declarations: [
    AppComponent,
    AddadminComponent,
    AddscheduleComponent,
    ListscheduleComponent,
    AddPassportComponent,
    AddPassengerComponent,
    AddUserComponent,
    AddlocationComponent,
    LocationlistComponent,
    AddrouteComponent,
    RoutelistComponent,
    AddflightComponent,
    FlightlistComponent,
    AddflightclassComponent,
    FlightclasslistComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    CustomerHomeComponent,
    CustomerLoginComponent,
    AdminHomeComponent,
    AdminLoginComponent,
    FlightViewComponent,
    SearchFlightComponent,
    TicketconfrimComponent,
    ViewticketComponent,
    PagenotfoundComponent,
    UserlistComponent,
    PassengerlistComponent
  ],
  imports: [
    BrowserModule, FormsModule, HttpClientModule, ReactiveFormsModule, RouterModule.forRoot(appRoutes), FormsModule
  ],
  providers: [JarvisService],
  bootstrap: [AppComponent]
})
export class AppModule { }
