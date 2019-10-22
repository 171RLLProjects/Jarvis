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
import com.mphasis.jarvis.entities.Schedule;
import com.mphasis.jarvis.exceptions.BusinessException;
import com.mphasis.jarvis.service.ScheduleService;

@RestController
public class ScheduleController {
	@Autowired
	ScheduleService scheduleService;

	@RequestMapping(value="/schedule",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> addSchedule(@RequestBody Schedule schedule){
		try {
			scheduleService.insertSchedule(schedule);
		}
		catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value="/schedule",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateSchedule(@RequestBody Schedule schedule) {
		try {
			scheduleService.editSchedule(schedule);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}


	@RequestMapping(value="/schedule/{scheduleId}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteSchedule(@PathVariable("scheduleId")String scheduleId) {
		try {
			scheduleService.removeSchedule(scheduleId);
		} catch (Exception e) {

			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value="/schedule", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Schedule>> getSchedule(){
		List<Schedule> schedule=null;
		try {
			schedule=scheduleService.getAll();
		} catch (Exception e) {
			try {
				throw new BusinessException("no location found");
			} catch (BusinessException e1) {
				e1.getMessage();
			}
			return new ResponseEntity<List<Schedule>>(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.ok().body(schedule);
	}

	@RequestMapping(value="/schedule/{scheduleId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Schedule> getScheduleById(@PathVariable("scheduleId")String scheduleId) {
		Schedule schedule=null;
		try {
			schedule=scheduleService.getScheduleByID(scheduleId);
		} catch (Exception e) {
			return new ResponseEntity<Schedule>(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.accepted().body(schedule);
	}


}
