package com.mphasis.jarvis.service;

import java.util.List;

import com.mphasis.jarvis.entities.UserProfile;
import com.mphasis.jarvis.exceptions.BusinessException;


public interface UserProfileService {
	public UserProfile login(String userName,String userPass) throws BusinessException ;
	public UserProfile getUserById(String userId) throws BusinessException;
	public void updatePassword(UserProfile userProfile) ;
	public void registerUser(UserProfile userProfile);
	public List<UserProfile> getAllUser();
	public void deleteUser(String userId);
	public void updateUser(UserProfile userProfile);
}
