//package com.cg.bookmydoctor.tests;
//
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import com.cg.bookmydoctor.exception.*;
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.cg.bookmydoctor.BookMyDoctorApp2ApplicationTests;
//import com.cg.bookmydoctor.dao.IAppointmentDao;
//import com.cg.bookmydoctor.dto.Appointment;
//import com.cg.bookmydoctor.dto.Doctor;
//import com.cg.bookmydoctor.dto.Patient;
//import com.cg.bookmydoctor.serviceimpl.AppointmentServiceImpl;
//import com.cg.bookmydoctor.serviceimpl.DoctorServiceImpl;
//import com.cg.bookmydoctor.serviceimpl.PatientServiceImpl;
//
//public class AppointmentTest extends BookMyDoctorApp2ApplicationTests{
//
//	@Autowired
//	AppointmentServiceImpl appointmentservice;
//	@Autowired
//	DoctorServiceImpl doctorservice;
//	@Autowired
//	PatientServiceImpl patientservice;
//	@Autowired
//	IAppointmentDao appDao;
//
//
//	@Before
//	public void setUp() {
//		patientservice = new PatientServiceImpl();
//		doctorservice = new DoctorServiceImpl();
//		appointmentservice = new AppointmentServiceImpl();
//	}
//
//	@Test
//	void testAppointmentServiceImpl() throws ValidateAppointmentException {
//		assertTrue(appointmentservice instanceof AppointmentServiceImpl);
//	}
//
//	@Test
//	void testAddAppointment() throws DoctorException, ValidateDoctorException, PatientException, ValidatePatientException, AppointmentException, ValidateAppointmentException, ValidateUserException, UserException {
//		Doctor doctor = new Doctor(1,"K Priya", "Dental","Mumbai", "Shivaji Hospital","8787778866", "priyaeee@gmail.com","Joshi@1234", 800);
//		doctorservice.addDoctor(doctor);
//		Patient patient = new Patient(2, "V Raghav", "9988742355","raghav@gmail.com", "Raghav@12", "O-","Male",32, "Kphb Colony, Hyderabad");
//		patientservice.addPatient(patient);
//		Appointment app = new Appointment(3, doctor, patient, LocalDate.of(2021,01,13), "Approved", "Good");
//		app = appointmentservice.addAppointment(app);
//		assertEquals(app.getAppointmentId(),3);
//	}
//
//	@Test
//	void testUpdateAppointment() throws ValidateAppointmentException, PatientException, ValidatePatientException, DoctorException, ValidateDoctorException {
//		Doctor doctor = new Doctor(1,"K Priya", "Dental","Mumbai", "Shivaji Hospital","8787778866", "priyaeee@gmail.com","Joshi@1234", 800);
//		Patient patient = new Patient(2, "V Raghav", "9988742355","raghav@gmail.com", "Raghav@12", "O-","Male",32, "Kphb Colony, Hyderabad");
//		Appointment app = new Appointment(3, doctor, patient, LocalDate.of(2021,01,13), "Cancelled", "Good");
//		boolean result = appointmentservice.updateAppointment(app);
//		assertEquals(result, true);
//	}
//
//	@Test
//	void testDeleteAppointment() {
//		boolean result = appointmentservice.deleteAppointment(3);
//		assertEquals(result, true);
//	}
//
//	@Test
//	void testGetAllAppointments() {
//		List<Appointment> app = appointmentservice.getAllAppointments();
//		assertNotNull(app);
//	}
//
//
//}
