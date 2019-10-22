package com.mphasis.jarvis.daos;

import java.util.List;

import com.mphasis.jarvis.entities.Schedule;

public interface ScheduleDao {

	public void addSchedule(Schedule schedule);
	public void updateSchedule(Schedule schedule);
	public void deleteSchedule(String scheduleId);
	public List<Schedule> getAll();
	public Schedule getScheduleByID(String scheduleId);
}
