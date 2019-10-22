package com.mphasis.jarvis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.jarvis.daos.AdminDao;
import com.mphasis.jarvis.entities.Admin;
import com.mphasis.jarvis.exceptions.BusinessException;
@Service
public class AdminServicesImpl implements AdminServices {
	@Autowired
	AdminDao adminDao;
	@Override
	public void registerAdmin(Admin admin) {
		if(admin.getAdminName() != null && admin.getAdminPass() != null) {
			adminDao.registerAdmin(admin);
		}else {
			try {
				throw new BusinessException("Admin Name and Password Should Not be Null");
			} catch (BusinessException e) {

				e.getMessage();
			}
		}
	}


	@Override
	public void updatePassword(Admin admin) {
		if(admin.getAdminName() != null && admin.getAdminPass() != null) {
			adminDao.updatePassword(admin);
		}else {
			try {
				throw new BusinessException("Admin Name and Password Should Not be Null");
			} catch (BusinessException e) {

				e.getMessage();
			}
		}
	}

	@Override
	public Admin getAdminByUser(String adminName) {

		Admin admin=adminDao.getAdminByUser(adminName);
		if(admin.getAdminName() == null) {
			try {
				throw new BusinessException("Admin Not Available!!!!!!!!!!");
			} catch (BusinessException e) {

				e.getMessage();
			}
		}
		return admin;

	}





	@Override
	public Admin login(String adminName, String adminPass) {
		Admin admin=null;
		if((adminName == null)&&(adminPass == null)) {
			try {
				throw new BusinessException("name and password should not be empty");
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}else {
			admin=adminDao.login(adminName, adminPass);

		}
		return admin;

	}
}
