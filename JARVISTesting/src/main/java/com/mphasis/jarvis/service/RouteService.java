package com.mphasis.jarvis.service;

import java.util.List;

import com.mphasis.jarvis.entities.Route;

public interface RouteService {
	public void insertRoute(Route route);
	public void editRoute(Route route)  ;
	public void removeRoute(String routeId);
	public List<Route> getAll();
	public Route getRouteByID(String routeId);
}
