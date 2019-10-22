package com.mphasis.jarvis.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mphasis.jarvis.daos.ScheduleDao;
import com.mphasis.jarvis.entities.Schedule;
import com.mphasis.jarvis.exceptions.BusinessException;



@Service
public class ScheduleServiceImpl implements ScheduleService {
	@Autowired
	ScheduleDao scheduleDao;
	public void insertSchedule(Schedule schedule) {
		
			try {
				scheduleDao.addSchedule(schedule);
				
			} catch (Exception e) {
				e.getMessage();
			}
		}

	public void editSchedule(Schedule schedule) {

			try {
				scheduleDao.updateSchedule(schedule);
				
			} catch (Exception e) {
				e.getMessage();
			}
		}

	public void removeSchedule(String scheduleId) {
			
			try {
				scheduleDao.deleteSchedule(scheduleId);
				
			} catch (Exception e) {
				e.getMessage();
			}
		} 

	public List<Schedule> getAll() {

		List<Schedule> schedule=scheduleDao.getAll();
		if(schedule == null) {
			try {
				throw new BusinessException("no schedule available");
			} catch (BusinessException e) {
				e.getMessage();
			}
		}
		return schedule;
	}

	public Schedule getScheduleByID(String scheduleId) {

		Schedule schedule=scheduleDao.getScheduleByID(scheduleId);
		if(schedule == null) {
			try {
				throw new BusinessException("no schedule available");
			} catch (BusinessException e) {
				e.getMessage();
			}
		}
		return schedule;
	}

}
