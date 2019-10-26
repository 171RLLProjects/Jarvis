import { Route } from "./route";
import { Schedule } from "./schedule";

export class Flight {
    flightId : string;
    flightName : string;
    totalSeat : number;
    availableSeat : number;
    flightType : string ;
    route : Route;
    schedule : Schedule;
}
