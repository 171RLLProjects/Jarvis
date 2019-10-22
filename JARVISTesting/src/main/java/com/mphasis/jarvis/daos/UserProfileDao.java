package com.mphasis.jarvis.daos;

import java.util.List;

import com.mphasis.jarvis.entities.UserProfile;


public interface UserProfileDao {
	public UserProfile login(String userName,String userPass);
	public UserProfile getUserById(String userId);
	public void updatePassword(UserProfile userProfile) ;
	public void registerUser(UserProfile userProfile);
	public List<UserProfile> getAllUser() ;
	public void deleteUser(String userId) ;
	public void updateUser(UserProfile userProfile);
}
