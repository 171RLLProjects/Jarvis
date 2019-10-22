package com.mphasis.jarvis.controllers;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.mphasis.jarvis.entities.UserProfile;
import com.mphasis.jarvis.exceptions.BusinessException;
import com.mphasis.jarvis.service.UserProfileService;

@RestController
public class UserController {
	@Autowired
	UserProfileService userProfileService;


	@RequestMapping(value="/user/{userName}/{userPass}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserProfile> loginUser(@PathVariable("userName")String userName,@PathVariable("userPass")String userPass
            ,HttpSession session) {
		UserProfile userProfile=null;
        try {
        	userProfile=userProfileService.login(userName, userPass);
        }catch (Exception e) {
            return new ResponseEntity<UserProfile>(HttpStatus.BAD_REQUEST);
        }
        session.setAttribute("userName", userProfile.getUserName());
        return ResponseEntity.accepted().body(userProfile);
    }

	@RequestMapping(value="/user", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserProfile>> getUser(){
		List<UserProfile> userProfiles=null;
		try {
			userProfiles=userProfileService.getAllUser();
		} catch (Exception e) {
			try {
				throw new BusinessException("Invalid");
			} catch (BusinessException e1) {
				// TODO Auto-generated catch block
				e1.getMessage();
			}
			return new ResponseEntity<List<UserProfile>>(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.ok().body(userProfiles);
	}

	@RequestMapping(value="/user",method=RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Void> adduser(@RequestBody UserProfile userProfile){
		try {
			userProfileService.registerUser(userProfile);
		}
		catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value="/user",method=RequestMethod.PUT, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateuser(@RequestBody UserProfile userProfile) {
		try {
			userProfileService.updateUser(userProfile);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}	


	@RequestMapping(value="/user/{userId}",method=RequestMethod.DELETE, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteUser(@PathVariable("userId")String userId) {
		try {
			userProfileService.deleteUser(userId);
		} catch (Exception e) {

			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	@RequestMapping(value="/user/{userId}",method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserProfile> getUserById(@PathVariable("userId")String userId) {
		UserProfile userProfile=null;
		try {
			userProfile=userProfileService.getUserById(userId);
		} catch (Exception e) {
			return new ResponseEntity<UserProfile>(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.accepted().body(userProfile);
	}
	@RequestMapping(value="/ulogout")
    public ResponseEntity<Void> logoutUser(HttpSession session){
        session.removeAttribute("userName");
        session.invalidate();
        return new ResponseEntity<Void>(HttpStatus.GONE);

	}
}
