import { Flight } from "./flight";
import { Passport } from "./passport";

export class Passenger {

    passengerId: string;
    passengerName:string;
    passengerAge: number;
    passengerGender: string;
    passengerSeatNo:number;
    bookingDate : string;
    PassengerStatus:string;
    flight: Flight;
    passportNum: number;
}
