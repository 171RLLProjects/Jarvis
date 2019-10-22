package com.mphasis.jarvis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mphasis.jarvis.entities.Route;
import com.mphasis.jarvis.exceptions.BusinessException;
import com.mphasis.jarvis.service.RouteService;

@RestController
public class RouteController {
	@Autowired
	RouteService routeService;


	@RequestMapping(value="/route",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> addRoute(@RequestBody Route route){
		try {
			routeService.insertRoute(route);
		}
		catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value="/route",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateRoute(@RequestBody Route route) {
		try {
			routeService.editRoute(route);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value="/route/{routeId}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteRoute(@PathVariable("routeId")String routeId) {
		try {
			routeService.removeRoute(routeId);
		} catch (Exception e) {

			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value="/route", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Route>> getRoute(){
		List<Route> route=null;
		try {
			route=routeService.getAll();
		} catch (Exception e) {
			try {
				throw new BusinessException("no location found");
			} catch (BusinessException e1) {
				e1.getMessage();
			}
			return new ResponseEntity<List<Route>>(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.ok().body(route);
	}

	@RequestMapping(value="/route/{routeId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Route> getRouteById(@PathVariable("routeId")String routeId) {
		Route route=null;
		try {
			route=routeService.getRouteByID(routeId);
		} catch (Exception e) {
			return new ResponseEntity<Route>(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.accepted().body(route);
	}

}
