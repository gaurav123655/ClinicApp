package com.cg.bookmydoctor.controller;

import com.cg.bookmydoctor.exception.UserException;
import com.cg.bookmydoctor.exception.ValidateUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.bookmydoctor.dto.Admin;
import com.cg.bookmydoctor.exception.AdminException;
import com.cg.bookmydoctor.exception.ValidateAdminException;
import com.cg.bookmydoctor.serviceimpl.AdminServiceImpl;


/**
 * @author Gaurav
 *         REST Controller with different HTTP methods 
 *         as GET,POST,DELETE and their respective URL mappings class level
 *         request mapping as "admin"
 *         
 */
@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminServiceImpl adminservice ;
	
	//working
   	@GetMapping("/viewadmin/{adminId}")
	public Admin viewAdmin(@PathVariable("adminId") final Admin admin) throws AdminException {
		return adminservice.viewAdmin(admin);
	}

	@PostMapping("/register")
	public Admin addAdmin(@RequestBody final Admin admin) throws AdminException, ValidateAdminException, ValidateUserException, UserException {
		System.out.println("Admin Registration Request Received: " + admin);
		return adminservice.addAdmin(admin);
	}


	//working
	@PutMapping("/updateadmin")
	public Admin updateAdmin(@RequestBody final Admin admin) throws AdminException, ValidateAdminException {
		return adminservice.updateAdmin(admin);
	}

	//working
	@DeleteMapping("/removeadmin")
	public Admin removeAdmin(@RequestBody final Admin admin) throws AdminException {
		return adminservice.removeAdmin(admin);
	}
}