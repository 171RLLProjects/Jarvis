package com.mphasis.jarvis.daos;

import java.util.List;
import com.mphasis.jarvis.entities.Route;


public interface RouteDao {
	public void addRoute(Route route);
	public void updateRoute(Route route)  ;
	public void deleteRoute(String routeId);
	public List<Route> getAll();
	public Route getRouteByID(String routeId);
}

