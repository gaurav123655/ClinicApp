//package com.cg.bookmydoctor.tests;
//
//import static org.junit.Assert.assertEquals;
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import com.cg.bookmydoctor.exception.UserException;
//import com.cg.bookmydoctor.exception.ValidateUserException;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import com.cg.bookmydoctor.BookMyDoctorApp2ApplicationTests;
//import com.cg.bookmydoctor.dao.IDoctorDao;
//import com.cg.bookmydoctor.dto.AvailabilityDates;
//import com.cg.bookmydoctor.dto.Doctor;
//import com.cg.bookmydoctor.exception.DoctorException;
//import com.cg.bookmydoctor.exception.ValidateDoctorException;
//import com.cg.bookmydoctor.serviceimpl.DoctorServiceImpl;
//
//
//@SpringBootTest
//public class DoctorTest extends BookMyDoctorApp2ApplicationTests{
//
//	@Autowired
//	private DoctorServiceImpl doctorservice;
//
//	@Autowired
//	private IDoctorDao doctorDao;
//
//	@Before
//	public void setUp() {
//		doctorservice = new DoctorServiceImpl();
//	}
//
//	@Test
//	void testdoctorServiceImpl() {
//		assertTrue(doctorservice instanceof DoctorServiceImpl);
//	}
//
//
//	@Test
//	void testAddDoctor() throws DoctorException, ValidateDoctorException, ValidateUserException, UserException {
//		Doctor doctor = new Doctor(1,"K Priya", "Dental","Mumbai", "Mumbai Hospital","8787778866", "priyaeee@gmail.com","Priya@23", 800);
//		doctor = doctorservice.addDoctor(doctor);
//		assertEquals(doctor.getDoctorId(), 1);
//		Doctor doctor2 = new Doctor(2,"M Harshitha", "ENT", "Agra Delhi", "Sunshine Hospital", "9000878787","harshitha@gmail.com", "Crafty21@", 1200);
//		doctor2 = doctorservice.addDoctor(doctor2);
//		assertEquals(doctor2.getDoctorId(), 2);
//		Doctor doctor3 = new Doctor(3,"Shanmukh", "Cardiologist","Chennai", "KGF Hospital","9879879870", "shanmukh@gmail.com","Shanmukh#2", 1000);
//		doctor3 = doctorservice.addDoctor(doctor3);
//	}
//
//	@Test
//	void testEditDoctor() throws DoctorException, ValidateDoctorException  {
//		Doctor doctor = new Doctor(1,"K Priya", "Dental","Mumbai", "Shivaji Hospital","8787778866", "priyaeee@gmail.com","Joshi#123", 800);
//		doctor = doctorservice.updateDoctorProfile(doctor);
//		assertEquals(doctor.getHospitalName(), "Shivaji Hospital");
//	}
//
//	@Test
//	void testRemovedoctor() throws DoctorException {
//		Doctor doctor = doctorDao.findById(2).get();
//		Doctor deletedDoctor = doctorservice.removeDoctor(doctor);
//		assertEquals(deletedDoctor, doctor);
//	}
//
//	@Test
//	void testGetDoctor() throws DoctorException {
//		Doctor doctor = new Doctor(1,"K Priya", "Dental","Mumbai", "Shivaji Hospital","8787778866", "priyaeee@gmail.com","Joshi!123", 800);
//		Doctor doctorGet = doctorservice.getDoctor(doctor);
//		assertNotNull(doctorGet);
//	}
//
//	@Test
//	void testGetDoctorList() {
//		List<Doctor> docList = doctorservice.getDoctorList();
//		assertNotNull(docList);
//	}
//
//	@After
//	public void setDown() {
//		doctorservice = null;
//	}
//}
