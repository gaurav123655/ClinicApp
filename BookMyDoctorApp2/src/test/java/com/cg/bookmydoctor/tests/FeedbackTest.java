//package com.cg.bookmydoctor.tests;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//
//import com.cg.bookmydoctor.exception.*;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.cg.bookmydoctor.BookMyDoctorApp2ApplicationTests;
//import com.cg.bookmydoctor.dto.Doctor;
//import com.cg.bookmydoctor.dto.FeedBack;
//import com.cg.bookmydoctor.dto.Patient;
//import com.cg.bookmydoctor.serviceimpl.DoctorServiceImpl;
//import com.cg.bookmydoctor.serviceimpl.FeedbackServiceImpl;
//import com.cg.bookmydoctor.serviceimpl.PatientServiceImpl;
//
//public class FeedbackTest  extends BookMyDoctorApp2ApplicationTests {
//
//	@Autowired
//	private PatientServiceImpl patientservice;
//	@Autowired
//	private DoctorServiceImpl doctorservice;
//	@Autowired
//	private FeedbackServiceImpl feedbackservice;
//
//	@Before
//	public void setUp() {
//		patientservice = new PatientServiceImpl();
//		doctorservice = new DoctorServiceImpl();
//		feedbackservice = new FeedbackServiceImpl();
//	}
//
//
//	@Test
//	void testfeedbackServiceImpl() {
//		assertTrue(feedbackservice instanceof FeedbackServiceImpl);
//	}
//
//	@Test
//	public void testAddFeedback() throws DoctorException, ValidateDoctorException, PatientException, ValidatePatientException, ValidateUserException, UserException {
//		Doctor doctor = new Doctor(1,"K Priya", "Dental","Mumbai", "Mumbai Hospital","8787778866", "priyaeee@gmail.com","Priya@23", 800);
//		doctor = doctorservice.addDoctor(doctor);
//		Patient patient = new Patient(2,"Soumya","7829901763","soumya@gmail.com","Soumya@234","O+","Female",28,"Hyderabad");
//		patient = patientservice.addPatient(patient);
//		FeedBack feedback = new FeedBack(3,patient,doctor,5,"Excellent");
//		assertEquals(feedback.getFeedbackId(),3);
//	}
//
//
//	@After
//	public void setDown() {
//		doctorservice = null;
//		patientservice=null;
//		feedbackservice=null;
//
//	}
//
//
//}
