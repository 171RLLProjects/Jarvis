import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Admin } from './admin';
import { Flight } from './flight';
import { Observable, throwError, BehaviorSubject  } from 'rxjs';
import { retry, catchError, tap } from 'rxjs/operators';
import { Passenger } from './passenger';
import { Route } from './route';
import { Schedule } from './schedule';
import { Ticket } from './ticket';
import { Userprofile } from './userprofile';
import { Passport } from './passport';
import { Location } from './location';
import { Router } from '@angular/router';
import { Flightclass } from './flightclass';
@Injectable({
  providedIn: 'root'
})
export class JarvisService {


headers = {
  headers: new HttpHeaders({ 'Content-Type' : 'application/json'})

};

handleError(error) {
  let errorMessage = '';
  if (error.error instanceof ErrorEvent) {
    // client-side error
    errorMessage = `Error: ${error.error.message}`;
  } else {
    // server-side error
    errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
  }
  window.alert(errorMessage);
  return throwError(errorMessage);
}

private currentUserSubject: BehaviorSubject<Admin>;
public currentUser: Observable<Admin>;

private currentUserSubject1: BehaviorSubject<Userprofile>;
public currentUser1: Observable<Userprofile>;

  constructor(private _http : HttpClient ) { 

    this.currentUserSubject = new BehaviorSubject<Admin>(JSON.parse(localStorage.getItem('currentUser')));
    this.currentUser = this.currentUserSubject.asObservable();


    this.currentUserSubject1 = new BehaviorSubject<Userprofile>(JSON.parse(localStorage.getItem('currentUser1')));
    this.currentUser1 = this.currentUserSubject1.asObservable();
  }




  //Admin Operations

  addAdmin (admin : Admin)
  {
    return this. _http.post( 'http://172.21.41.17:8076/JARVIS/admin' , JSON.stringify(admin), this.headers).pipe(
      retry(1),
      catchError(this.handleError)
    );
  }

  updateAdmin(admin: Admin)
  {
    return this._http.put('http://172.21.41.17:8076/JARVIS/admin', JSON.stringify(admin), this.headers).pipe(
      retry(1),
      catchError(this.handleError)
    );
    
    }

  
    getAdminByName(adminName: string)
    {
      return this._http.get(`http://172.21.41.17:8076/JARVIS/admin/` + adminName)  .pipe(
        retry(1),
        catchError(this.handleError)
      );
    }

    adminLogin(adminName: string , adminPass : string)
    {
      return this._http.get(`http://172.21.41.17:8076/JARVIS/admin/` + adminName + `/ ` + adminPass)  .pipe(
        retry(1),
        catchError(this.handleError)
      );
    }

 
   login(adminName: string, adminPass: string):Observable<Admin>
   {
      console.log('service called');  
     return this._http.get<Admin>(`http://172.21.41.17:8076/JARVIS/admin/` + adminName + `/ ` + adminPass)
     .pipe(tap(admin => {
      localStorage.setItem('currentPassenger',JSON.stringify(Admin));
       this.currentUserSubject.next(admin);
      return admin;})
  );
  } 

// Flight Operations

addFlight (flight : Flight)
{
  console.log(flight+"servive");
 return this. _http.post( 'http://172.21.41.17:8076/JARVIS/flights' , JSON.stringify(flight), this.headers)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}

updateFlight (flight : Flight)
{
  return this. _http.put( 'http://172.21.41.17:8076/JARVIS/flights' , JSON.stringify(flight), this.headers)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}

deleteFlight(flightId: string)
{
  return this._http.delete(`http://172.21.41.17:8076/JARVIS/flights/` + flightId)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}

getAllFlight(): Observable< Flight[]>


{
  return this. _http.get<Flight[]>( 'http://172.21.41.17:8076/JARVIS/flight')  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}


getFlightById(flightId: string) : Observable< Flight >
{
  return this._http.get< Flight >(`http://172.21.41.17:8076/JARVIS/flightsi/` + flightId )  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}


getFlightByRouteId(routeId: string)
{
  return this._http.get(`http://172.21.41.17:8076/JARVIS/flights1/` + routeId)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}

getFlightBySrcAndDes(sourceId : string, destinationId : string) : Observable< Flight[]>
{
  return this._http.get<Flight[]>(`http://172.21.41.17:8076/JARVIS/search/` + sourceId + `/ ` + destinationId)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}

getFlightBySrcAndDesAndSch(sourceId : string, destinationId : string, scheduleId : string) :  Observable< Flight[] >
{
  return this._http.get <Flight[]> (`http://172.21.41.17:8076/JARVIS/search1/` + sourceId + `/ ` + destinationId +`/` +scheduleId)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}

booking(flightId: string)
{
  return this._http.put(`http://172.21.41.17:8076/JARVIS/flightseat/` + flightId , JSON.stringify(flightId), this.headers)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}

cancel(flight : Flight, flightId: string)
{
  return this._http.put(`http://172.21.41.17:8076/JARVIS/flightseat1/` + flightId , JSON.stringify(flight), this.headers)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}


//Location Operations

addLocation (location : Location)
{
  return this. _http.post( 'http://172.21.41.17:8076/JARVIS/location' , JSON.stringify(location), this.headers)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}

updateLocation (location : Location)
{
  return this. _http.put( 'http://172.21.41.17:8076/JARVIS/location' , JSON.stringify(location), this.headers)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}

getLocation() : Observable < Location[] >
{
  return this. _http.get< Location[] >( 'http://172.21.41.17:8076/JARVIS/location')  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}


getLocationById(locationId: string)
{
  return this._http.get(`http://172.21.41.17:8076/JARVIS/location/` + locationId)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}

deleteLocation(locationId: string)
{
  return this._http.delete(`http://172.21.41.17:8076/JARVIS/location/` + locationId)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}


//Passenger Operation


addPassenger (passenger : Passenger) : Observable<Passenger>
{
  return this. _http.post<Passenger>( 'http://172.21.41.17:8076/JARVIS/insertpass' , JSON.stringify(passenger), this.headers)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}


getPassenger() : Observable < Passenger[] >
{
  return this. _http.get< Passenger[] >( 'http://172.21.41.17:8076/JARVIS/passenger')  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}

passengerStatus(passenger : Passenger, passengerId: string)
{
  return this._http.put(`http://172.21.41.17:8076/JARVIS/updatepass/` + passengerId , JSON.stringify(passenger), this.headers)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}

getPassengerById(passsengerId: string)
{
  return this._http.get(`http://172.21.41.17:8076/JARVIS/pass/` + passsengerId)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}

getPassengerByName(passsengerName: string) 
{
  return this._http.get<Passenger>(`http://172.21.41.17:8076/JARVIS/passname/` + passsengerName)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}


//ROUTE Operation


addRoute (route : Route)
{
  return this. _http.post( 'http://172.21.41.17:8076/JARVIS/route' , JSON.stringify(route), this.headers)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}

updateRoute (route : Route)
{
  return this. _http.put( 'http://172.21.41.17:8076/JARVIS/route' , JSON.stringify(route), this.headers)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}

getRoute() : Observable < Route[] >
{
  return this. _http.get< Route[] >( 'http://172.21.41.17:8076/JARVIS/route')  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}


getRouteById(routeId: string) :Observable <Route>
{
  return this._http.get<Route>(`http://172.21.41.17:8076/JARVIS/route/` + routeId)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}

deleteRoute(routeId: string)
{
  return this._http.delete(`http://172.21.41.17:8076/JARVIS/route/` + routeId)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}


//SCHEDULE Operation

addSchedule (schedule : Schedule)
{
  return this. _http.post( 'http://172.21.41.17:8076/JARVIS/schedule' , JSON.stringify(schedule), this.headers)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}

updateSchedule (schedule : Schedule)
{
  return this. _http.put( 'http://172.21.41.17:8076/JARVIS/schedule' , JSON.stringify(schedule), this.headers)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}

getSchedule() : Observable < Schedule[] >
{
  return this. _http.get< Schedule[] >( 'http://172.21.41.17:8076/JARVIS/schedule')  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}


getScheduleById(scheduleId: string)
{
  return this._http.get(`http://172.21.41.17:8076/JARVIS/schedule/` + scheduleId)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}

deleteSchedule(scheduleId: string)
{
  return this._http.delete(`http://172.21.41.17:8076/JARVIS/schedule/` + scheduleId)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}


//TICKET Operation

addTicket (ticket : Ticket)
{
  return this. _http.post( 'http://172.21.41.17:8076/JARVIS/ticket' , JSON.stringify(ticket), this.headers)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}

getTicketById(ticketId: string)
{
  return this._http.get(`http://172.21.41.17:8076/JARVIS/ticket/` + ticketId)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}

ticketStatus(ticket : Ticket, ticketId: string)
{
  return this._http.put(`http://172.21.41.17:8076/JARVIS/cancel/` + ticketId , JSON.stringify(ticket), this.headers)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}


//FlightClass Operations

addFlightClass (fl : Flightclass)
{
  return this. _http.post( 'http://172.21.41.17:8076/JARVIS/fs' , JSON.stringify(fl), this.headers)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}
updateFlightClass (flightClass : Flightclass)
{
  return this. _http.put( 'http://172.21.41.17:8076/JARVIS/fs' , JSON.stringify(flightClass), this.headers)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}
getAllFlightClass(): Observable< Flightclass[]>
{
  return this. _http.get<Flightclass[]>( 'http://172.21.41.17:8076/JARVIS/fs')  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}
getFlightClassById(flightClassId: number) : Observable <Flightclass>
{
  return this._http.get<Flightclass>(`http://172.21.41.17:8076/JARVIS/fs/` + flightClassId)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}


deleteFlightClass(flightClassId: number)
{
  return this._http.delete(`http://172.21.41.17:8076/JARVIS/fs/` + flightClassId)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}


getFlightClassByFlightId(flightId: string)
{
  return this._http.get<Flightclass>(`http://172.21.41.17:8076/JARVIS/fs1/` + flightId)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}


reduceSeat (flightId : string, flightclass : string, flightClass : Flightclass)
{
  return this. _http.put( 'http://172.21.41.17:8076/JARVIS/flightDec' + flightId + `/ ` + flightclass, JSON.stringify(flightClass), this.headers)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}


increaseSeat (flightId : string, flightclass : string, flightClass : Flightclass)
{
  return this. _http.put( 'http://172.21.41.17:8076/JARVIS/flightInc' + flightId + `/ ` + flightclass, JSON.stringify(flightClass), this.headers)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}


//User Operations

addUser (userProfile : Userprofile)
{
  return this. _http.post( 'http://172.21.41.17:8076/JARVIS/user' , JSON.stringify(userProfile), this.headers)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}

updateUser (userProfile : Userprofile)
{
  return this. _http.put( 'http://172.21.41.17:8076/JARVIS/user' , JSON.stringify(userProfile), this.headers)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}


getUser() : Observable < Userprofile[] >
{
  return this. _http.get< Userprofile[] >( 'http://172.21.41.17:8076/JARVIS/user')  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}


getUserById(userId: string)
{
  return this._http.get(`http://172.21.41.17:8076/JARVIS/user/` + userId)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}

deleteUser(userId: string)
{
  return this._http.delete(`http://172.21.41.17:8076/JARVIS/user/` + userId)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}


userlogin(userName: string, userPass: string):Observable <Userprofile>
{
 
 return this._http.get< Userprofile >(`http://172.21.41.17:8076/JARVIS/user/` + userName + `/ ` + userPass)
 .pipe(tap( userProfile => {
   localStorage.setItem('currentPassenger1',JSON.stringify(userProfile));
    this.currentUserSubject1.next(userProfile);
 return userProfile;})
);
} 

// userLogin(userName: string , userPass : string)
// {
//   return this._http.get(`http://172.21.41.17:8076/JARVIS/user/` + userName + `/ ` + userPass)  .pipe(
//     retry(1),
//     catchError(this.handleError)
//   );
// }

logOutUser (userProfile : Userprofile)
{
  return this._http.get(`http://172.21.41.17:8076/JARVIS/user`)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}


//passport

addPassport (passport : Passport)
{
  return this. _http.post( 'http://172.21.41.17:8076/JARVIS//passport' , JSON.stringify(passport), this.headers)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}

getPassportById(passportId: string)
{
  return this._http.get(`http://172.21.41.17:8076/JARVIS//passport/` + passportId)  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}


getPassport() : Observable < Passport[] >
{
  return this. _http.get< Passport[] > ( 'http://172.21.41.17:8076/JARVIS//passport')  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}



logout(){
  localStorage.removeItem('currentUser');
  this.currentUserSubject.next(null);
  localStorage.removeItem('currentUser1');
  this.currentUserSubject1.next(null);
 
}




}
