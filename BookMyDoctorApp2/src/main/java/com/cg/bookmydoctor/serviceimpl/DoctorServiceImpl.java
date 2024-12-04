package com.cg.bookmydoctor.serviceimpl;

import java.util.ArrayList;
  
import java.util.List;      
import java.util.Optional;

import com.cg.bookmydoctor.dao.IUserDao;
import com.cg.bookmydoctor.dto.Admin;
import com.cg.bookmydoctor.dto.User;
import com.cg.bookmydoctor.exception.UserException;
import com.cg.bookmydoctor.exception.ValidateUserException;
import com.cg.bookmydoctor.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookmydoctor.dto.AvailabilityDates;
import com.cg.bookmydoctor.dto.Doctor;

import com.cg.bookmydoctor.exception.DoctorException;
import com.cg.bookmydoctor.exception.ValidateDoctorException;
import com.cg.bookmydoctor.service.IDoctorService;
import com.cg.bookmydoctor.util.AllConstants;
import com.cg.bookmydoctor.dao.IAvailabilityDao;
import com.cg.bookmydoctor.dao.IDoctorDao;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private IDoctorDao doctorDao;
	@Autowired
	private IAvailabilityDao availabilityDao;

	@Autowired
	private IUserService userService;

	@Autowired
	private IUserDao userDao; // Add this to save User
	
	@Override
	public List<Doctor> getDoctorList() {
		Iterable<Doctor> result = doctorDao.findAll();
		List<Doctor> resultList = new ArrayList<>();
		result.forEach(resultList :: add);
		return resultList;
	}

	
	@Override
	public Doctor addDoctor(Doctor doctor) throws DoctorException, ValidateDoctorException, ValidateUserException, UserException {
		validateDoctor(doctor);
		Optional<Doctor>docdb= doctorDao.findById(doctor.getDoctorId());
		if(docdb.isPresent()) {
			throw new DoctorException("Doctor object already exists with ID : " +doctor.getDoctorId());
		} else {
			//return doctorDao.save(doctor);
            Doctor savedDoctor=doctorDao.save(doctor);
			createUserForDoctor(savedDoctor);
			return savedDoctor;

		}
	}

	private void createUserForDoctor(Doctor doctor) throws UserException, ValidateUserException {
		User user = new User();
		user.setUserName(doctor.getDoctorName());
		user.setEmailId(doctor.getEmail());
		user.setPassword(doctor.getPassword());

		userService.validateUser(user); // Correctly calling validateUser from userService
		userDao.save(user); // Saving user after validation
	}

	@Override
	public Doctor updateDoctorProfile(final Doctor bean) throws DoctorException, ValidateDoctorException {
		validateDoctor(bean);
		Optional<Doctor>docdb = doctorDao.findById(bean.getDoctorId());
		if(!docdb.isPresent()) {
			throw new DoctorException("Doctor doesn't exist with ID : " +bean.getDoctorId());
		} else {
			return doctorDao.save(bean);
		}
	}


	@Override
	public Doctor removeDoctor(final Doctor doc) throws DoctorException {
		Doctor doctor = doc;
		Optional<Doctor> docdb = doctorDao.findById(doc.getDoctorId());
		if(!docdb.isPresent()) {
			throw new DoctorException("Doctor with id : " +doc.getDoctorId() +" doesn't exist to delete");

		} else {
			doctorDao.deleteById(doc.getDoctorId());	
		}
		return doctor;
	}

	@Override
	public Doctor getDoctor(final Doctor doc) throws DoctorException {
		Optional<Doctor> docdb = doctorDao.findById(doc.getDoctorId());
		if(docdb.isPresent()) {
			return docdb.get();
		} else {
			throw new DoctorException("Doctor with id : " +doc.getDoctorId() +"doesn't exist");
		}

	}


	@Override
	public List<Doctor> getDoctorList(String speciality) throws DoctorException {
		Optional<Doctor> doctorDb = doctorDao.findBySpeciality(speciality);
		List<Doctor> doclist = new ArrayList<>();
		if (doctorDb .isPresent()) {
			doclist.add(doctorDb .get());
		} else {
			throw new DoctorException("Doctor with the speciality : " + speciality + "not exists");
		}
		return doclist;
	}

	@Override
	public boolean addAvailability(AvailabilityDates availDates) {
		if(availDates != null) {
			Optional<AvailabilityDates> availabilityDb = availabilityDao.findById(availDates.getAvailabilityId());
			if(!availabilityDb.isPresent()) {
				availabilityDao.save(availDates);
				return true;
			}
		}	
		return false;
	}
	
    @Override
	public boolean updateAvailability(AvailabilityDates availDates) {
		Optional<AvailabilityDates> availabilityDb = availabilityDao.findById(availDates.getAvailabilityId());
		if(availabilityDb.isPresent()) {
			availabilityDao.save(availDates);
			return true;	

		} else {
			return false;
		}
	}
    
	private boolean validateDoctor(Doctor doctor) throws ValidateDoctorException{
		if(!doctor.getDoctorName().matches(AllConstants.NAME_PATTERN)){
			throw new ValidateDoctorException(AllConstants.EMPTY_DOCTOR);
		}
		if(!doctor.getEmail().matches(AllConstants.EMAIL_PATTERN)) {
			throw new ValidateDoctorException(AllConstants.EMAIL_CANNOT_BE_EMPTY);
		}
		if(!doctor.getHospitalName().matches(AllConstants.NAME_PATTERN)) {
			throw new ValidateDoctorException(AllConstants.EMPTY_HOSPITALNAME);
		}
		if(!doctor.getLocation().matches(AllConstants.NAME_PATTERN)) {
			throw new ValidateDoctorException(AllConstants.EMPTY_LOCATION);
		}
		if(!doctor.getMobileNo().matches(AllConstants.PHONENUMBER_PATTERN)) {
			throw new ValidateDoctorException(AllConstants.EMPTY_PHONENUMBER);
		}
		if(!doctor.getPassword().matches(AllConstants.PASSWORD_PATTERN)) {
			throw new ValidateDoctorException(AllConstants.PASSWORD_NOT_STRONG);
		}
		if(!doctor.getSpeciality().matches(AllConstants.NAME_PATTERN)) {
			throw new ValidateDoctorException(AllConstants.EMPTY_SPECIALITY);
		}
		return true;
	}

}