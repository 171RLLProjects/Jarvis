package com.mphasis.jarvis.service;

import com.mphasis.jarvis.entities.Admin;

public interface AdminServices {
	public void registerAdmin(Admin admin);
	
	public void updatePassword(Admin admin); 
	public Admin getAdminByUser(String adminName);
	public Admin login(String adminName,String adminPass);
}
