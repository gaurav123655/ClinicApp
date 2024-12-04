package com.cg.bookmydoctor.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.bookmydoctor.dto.Appointment;
import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.exception.AppointmentException;
import com.cg.bookmydoctor.exception.ValidateAppointmentException;
import com.cg.bookmydoctor.exception.ValidateDoctorException;
import com.cg.bookmydoctor.exception.ValidatePatientException;

public interface IAppointmentService {
	
	List<Appointment> getAllAppointments() throws AppointmentException;
	Appointment getAppointment(int appointmentId) throws AppointmentException;
	boolean deleteAppointment(int appointmentId) ;
	boolean updateAppointment(Appointment bean) throws AppointmentException, ValidateAppointmentException;
	List<Appointment> getAppointments(Doctor doc) throws AppointmentException;
	List<Appointment> getAppointments(LocalDate date) throws AppointmentException;
	Appointment addAppointment(Appointment app) throws AppointmentException, ValidateAppointmentException, ValidateDoctorException, ValidatePatientException;
	

}
