package com.cg.bookmydoctor.controller;

import java.time.LocalDate;
import java.util.List;

import com.cg.bookmydoctor.exception.UserException;
import com.cg.bookmydoctor.exception.ValidateUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.dto.Patient;
import com.cg.bookmydoctor.exception.PatientException;
import com.cg.bookmydoctor.exception.ValidatePatientException;
import com.cg.bookmydoctor.serviceimpl.PatientServiceImpl;

/**
 * @author Gaurav
 *         REST Controller with different HTTP methods 
 *         as GET,POST,DELETE and their respective URL mappings class level
 *         request mapping as "patient"       
 */
@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientServiceImpl patientService;

	//working
	@PostMapping("/addpatient")
	public Patient addPatient(@RequestBody Patient bean) throws PatientException, ValidatePatientException, ValidateUserException, UserException {
		return patientService.addPatient(bean);
	}

	//working
	@PutMapping("/updatepatient")
	public Patient editPatientProfile(@RequestBody Patient bean) throws PatientException, ValidatePatientException {
		return patientService.editPatientProfile(bean);
	}
	
	//working
	@DeleteMapping("/removepatient/{patientId}")
	public Patient removePatientDetails(@PathVariable("patientId") Patient bean) throws PatientException {
		return patientService.removePatientDetails(bean);
	}
	
	//working
	@GetMapping("/getpatient")
	public Patient getPatient(@RequestParam("patientId") Patient patient) throws PatientException {
		return patientService.getPatient(patient);
	}

	//working
	@GetMapping("/getallpatients")
	public List<Patient> getAllPatient() {
		return patientService.getAllPatient();
	}
	
	@GetMapping("/getallpatientbydoctor")
	public List<Patient> getPatientListByDoctor(@RequestParam("doctorname") Doctor doc) {
		return patientService.getPatientListByDoctor(doc);
	}
	
	
	@GetMapping("/getallpatienbydate")
	public List<Patient> getPatientListByDate(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("appointmentdate")LocalDate appdate) {
		return patientService.getPatientListByDate(appdate);
	}
}