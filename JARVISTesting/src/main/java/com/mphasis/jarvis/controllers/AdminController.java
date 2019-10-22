package com.mphasis.jarvis.controllers;

import java.util.HashMap;
import java.util.Map;

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

import com.mphasis.jarvis.entities.Admin;
import com.mphasis.jarvis.service.AdminServices;

@RestController
public class AdminController {
	@Autowired
	AdminServices adminServices;

	@RequestMapping(value="/admin",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String, String>> addAdmin(@RequestBody Admin admin) {
		Map<String,String>  response=new HashMap<String, String>();    
		try {
		adminServices.registerAdmin(admin);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		response.put("ok", "Admin saved");
		return ResponseEntity.accepted().body(response);

	}

	@RequestMapping(value="/admin",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Map<String, String>> editPassword(@RequestBody Admin admin) {
		Map<String,String>  response=new HashMap<String, String>(); 
		try {
		adminServices.updatePassword(admin);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		response.put("ok", "Password Changed");
		return ResponseEntity.accepted().body(response);

	}
	@RequestMapping(value="/admin/{adminName}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)


	public  Admin retriveAdminByUser(@PathVariable("adminName") String adminName) {

		/*Admin admin;
		try {*/
		Admin admin=adminServices.getAdminByUser(adminName);
		/*}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.accepted().body(admin);*/
		return admin;
	}
	@RequestMapping(value="/admin/{adminName}/{adminPass}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Admin> loginAdmin(@PathVariable("adminName")String adminName,@PathVariable("adminPass")String adminPass
			,HttpSession session) {
		Admin admin=null;
		try {
		admin=adminServices.login(adminName, adminPass);
		}catch (Exception e) {
			return new ResponseEntity<Admin>(HttpStatus.BAD_REQUEST);
		}
		session.setAttribute("adminName", admin.getAdminName());
		return ResponseEntity.accepted().body(admin);
	}


	@RequestMapping(value="/alogout")
	public ResponseEntity<Void> logoutAdmin(HttpSession session){
		session.removeAttribute("adminName");
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.GONE);


	}

}