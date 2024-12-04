package com.cg.bookmydoctor.serviceimpl;

import com.cg.bookmydoctor.dao.IUserDao;
import com.cg.bookmydoctor.dto.User;
import com.cg.bookmydoctor.exception.UserException;
import com.cg.bookmydoctor.exception.ValidateUserException;
import com.cg.bookmydoctor.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.cg.bookmydoctor.dto.Patient;
import com.cg.bookmydoctor.dto.Appointment;
import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.exception.PatientException;
import com.cg.bookmydoctor.exception.ValidatePatientException;
import com.cg.bookmydoctor.service.IPatientService;
import com.cg.bookmydoctor.util.AllConstants;
import com.cg.bookmydoctor.dao.IPatientDao;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List; 
import java.util.Optional;

@Service
public class PatientServiceImpl implements IPatientService {
	@Autowired
	private IPatientDao patientDao;
	@Autowired
	private IUserService userService;

	@Autowired
	private IUserDao userDao; // Add this to save User


	private Appointment appointment;

	@Override
	public Patient addPatient(Patient bean) throws PatientException, ValidatePatientException, ValidateUserException, UserException {
		validatePatient(bean);
		Optional<Patient> patientdb= patientDao.findById(bean.getPatientId());
		if(patientdb.isPresent()) {
			throw new PatientException("Patient already exists with ID : " +bean.getPatientId());
		}
		 else {
			//return patientDao.save(bean);


			Patient savedPatient=patientDao.save(bean);
			createUserForPatient(savedPatient);
			return savedPatient;
		}
	}


	private void createUserForPatient(Patient patient) throws UserException, ValidateUserException {
		User user = new User();
		user.setUserName(patient.getPatientName());
		user.setEmailId(patient.getEmail());
		user.setPassword(patient.getPassword());

		userService.validateUser(user); // Correctly calling validateUser from userService
		userDao.save(user); // Saving user after validation
	}




	@Override
	public Patient editPatientProfile(Patient bean) throws PatientException, ValidatePatientException{
		validatePatient(bean);
		Optional<Patient> patientDb = patientDao.findById(bean.getPatientId());
		if (!patientDb.isPresent()) {
			throw new PatientException("Patient doesn't exist with ID : " +bean.getPatientId());
		} 
		else {
			return patientDao.save(bean);
		}
	}

	@Override
	public Patient removePatientDetails(Patient bean) throws PatientException{
		Patient oldpatient = bean;
		Optional<Patient> patientDb = patientDao.findById(bean.getPatientId());
		if (!patientDb.isPresent()) {
			throw new PatientException("Patient with id : " +bean.getPatientId() +"doesn't exist to delete");
		}
		else {
			patientDao.deleteById(bean.getPatientId());
		}
		return oldpatient;
	}

	
	@Override
	public Patient getPatient(Patient patient) throws PatientException{
		Optional<Patient> patientDb = patientDao.findById(patient.getPatientId());
		if(patientDb.isPresent()) {
			return patientDb.get();
		}
		else {
			throw new PatientException("Patient with ID : " + patient.getPatientId()+" doesn't exist");
		}
	}
	
	@Override
	public List<Patient> getAllPatient() {
		Iterable<Patient> result = patientDao.findAll();
		List<Patient> resultList = new ArrayList<>();
		result.forEach(resultList :: add);
		return resultList;
	}
	
	@Override
	public List<Patient> getPatientListByDoctor(Doctor doctor){
		String docname = doctor.getDoctorName();
		List<Patient> pat = new ArrayList<>();
		if(appointment.getDoctor().getDoctorName().equals(docname)) {
			pat.add(appointment.getPatient());
		}
		return pat;
	}
	
	@Override
	public List<Patient> getPatientListByDate(LocalDate appdate){
		List<Patient> patient = new ArrayList<>();
		if(appdate.equals(appointment.getAppointmentDate())) {
			patient.add(appointment.getPatient());
		}
		return patient;
	}
	
	private boolean validatePatient(Patient patient) throws ValidatePatientException{
		if(!patient.getPatientName().matches(AllConstants.NAME_PATTERN)){
			throw new ValidatePatientException(AllConstants.EMPTY_PATIENT);
		}
		if(!patient.getEmail().matches(AllConstants.EMAIL_PATTERN)) {
			throw new ValidatePatientException(AllConstants.EMAIL_CANNOT_BE_EMPTY);
		}
		if(!patient.getBloodGroup().matches(AllConstants.BLOODGROUP_PATTERN)) {
			throw new ValidatePatientException(AllConstants.BLOODGROUP_INVALID);
		}
		if(!patient.getGender().matches("Male") && !patient.getGender().matches("Female") && !patient.getGender().matches("Others")) {
			throw new ValidatePatientException(AllConstants.GENDER_INVALID);
		}
		if(!patient.getMobileNo().matches(AllConstants.PHONENUMBER_PATTERN)) {
			throw new ValidatePatientException(AllConstants.EMPTY_PHONENUMBER);
		}
		if(!patient.getPassword().matches(AllConstants.PASSWORD_PATTERN)) {
			throw new ValidatePatientException(AllConstants.PASSWORD_NOT_STRONG);
		}
		if(patient.getAge() < 0) {
			throw new ValidatePatientException(AllConstants.INVALID_AGE);
		}
		return true;
	}
}