package com.cg.bookmydoctor.service;

import java.util.List;
import com.cg.bookmydoctor.dto.AvailabilityDates;
import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.exception.DoctorException;
import com.cg.bookmydoctor.exception.UserException;
import com.cg.bookmydoctor.exception.ValidateDoctorException;
import com.cg.bookmydoctor.exception.ValidateUserException;

public interface IDoctorService {

	Doctor addDoctor(Doctor bean) throws DoctorException, ValidateDoctorException, ValidateUserException, UserException;

	Doctor updateDoctorProfile(Doctor bean) throws DoctorException, ValidateDoctorException;

	boolean addAvailability(AvailabilityDates bean) throws DoctorException;

	boolean updateAvailability(AvailabilityDates bean) throws DoctorException;

	Doctor getDoctor(Doctor doc) throws DoctorException;

	Doctor removeDoctor(Doctor doc) throws DoctorException;

	List<Doctor> getDoctorList() throws DoctorException;

	List<Doctor> getDoctorList(String speciality) throws DoctorException;
}
