package com.mphasis.jarvis.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.jarvis.daos.RouteDao;
import com.mphasis.jarvis.entities.Route;
import com.mphasis.jarvis.exceptions.BusinessException;
@Service
public class RouteServiceImpl implements RouteService {
	@Autowired
	RouteDao routeDao;
	public void insertRoute(Route route) {
		
			try {
				routeDao.addRoute(route);
			} catch (Exception e) {
				e.getMessage();
			}
		
	}

	public void editRoute(Route route) {
		
			try {
				routeDao.updateRoute(route);
			} catch (Exception e) {
				e.getMessage();
			}	
	}

	public void removeRoute(String routeId) {
		if(routeId != null) {
			routeDao.deleteRoute(routeId);
		}
		else {
			try {
				throw new BusinessException("RouteId should be greater than 1");
			} catch (BusinessException e) {
				e.getMessage();
			}
		}	
	}

	public List<Route> getAll() {
		List<Route> route=routeDao.getAll();
		if(route == null) {
			try {
				throw new BusinessException("No routes Available");
			} catch (BusinessException e) {
				e.getMessage();
			}
		}
		return route;
	}

	public Route getRouteByID(String routeId) {	
		Route route=routeDao.getRouteByID(routeId);
		if(route == null) {
			try {
				throw new BusinessException("No routes Available");
			} catch (BusinessException e) {
				e.getMessage();
			}
		}
		return route;
	}

}
