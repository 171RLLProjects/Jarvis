package com.mphasis.jarvis.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mphasis.jarvis.daos.UserProfileDao;
import com.mphasis.jarvis.entities.UserProfile;
import com.mphasis.jarvis.exceptions.BusinessException;

@Service
public class UserprofileServiceImpl implements UserProfileService{
	@Autowired
	UserProfileDao userProfileDao;

	@Override
	public UserProfile login(String userName, String userPass){
		UserProfile userProfile= userProfileDao.login(userName,userPass);
		if(userProfile==null) {
			try {
				throw new BusinessException("invalid credentials");
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userProfile;
	}

	@Override
	public UserProfile getUserById(String userId)   {
		UserProfile userProfile= userProfileDao.getUserById(userId);
		if(userProfile==null) {
			try {
				throw new BusinessException("the requested user is not available");
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userProfile;
	}

	@Override
	public void updatePassword(UserProfile userProfile) {
		if(userProfile.getUserName()!= null) {
			userProfileDao.updatePassword(userProfile);	   
		}else {
			try {
				throw new BusinessException("username should not be null");
			} catch (BusinessException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void registerUser(UserProfile userProfile) {
		if(userProfile.getUserName().matches("[A-Za-z]{3,20}")) {
			if(userProfile.getEmail().toString().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
				//if(userProfile.getMobileNo().equals("[^0-9]") {
				userProfileDao.registerUser(userProfile);
			}else {
				try {
					throw new BusinessException("invalid email");
				} catch (BusinessException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			try {
				throw new BusinessException("invalid username");
			} catch (BusinessException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public List<UserProfile> getAllUser() {
		List<UserProfile> userProfiles = userProfileDao.getAllUser();
		if(userProfiles == null) {
			try {
				throw new BusinessException("No userdetails Available");
			} catch (BusinessException e) {
				System.out.println(e.getMessage());
			}
		}
		return userProfiles;
	}


	@Override
	public void deleteUser(String userId) {
		userProfileDao.deleteUser(userId);

	}

	@Override
	public void updateUser(UserProfile userProfile) {
		if(userProfile.getUserName().matches("[A-Za-z]{3,20}")) {
			if(userProfile.getEmail().toString().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
				userProfileDao.updateUser(userProfile);
			}else {
				try {
					throw new BusinessException("invalid email");
				} catch (BusinessException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			try {
				throw new BusinessException("invalid username");
			} catch (BusinessException e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
