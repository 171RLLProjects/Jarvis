package com.mphasis.jarvis.service;

import java.util.List;

import com.mphasis.jarvis.entities.Schedule;

public interface ScheduleService {
	public void insertSchedule(Schedule schedule);
	public void editSchedule(Schedule schedule);
	public void removeSchedule(String scheduleId);
	public List<Schedule> getAll();
	public Schedule getScheduleByID(String scheduleId);


}
