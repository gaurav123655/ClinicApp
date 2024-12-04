package com.cg.bookmydoctor.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import com.cg.bookmydoctor.dto.Appointment;
import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.exception.AppointmentException;
import com.cg.bookmydoctor.exception.ValidateAppointmentException;
import com.cg.bookmydoctor.service.IAppointmentService;
import com.cg.bookmydoctor.util.AllConstants;
import com.cg.bookmydoctor.dao.IAppointmentDao;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements IAppointmentService {
	
		@Autowired
		private IAppointmentDao appointmentDao;
		
		
		@Override
		public List<Appointment> getAllAppointments() {
			Iterable<Appointment> result = appointmentDao.findAll();
			List<Appointment> resultList = new ArrayList<>();
			result.forEach(resultList :: add);
			return resultList;
		}
		
		@Override
		public Appointment addAppointment(Appointment appointment) throws AppointmentException, ValidateAppointmentException {
			validateAppointment(appointment);
			Optional<Appointment> appointmentDb = appointmentDao.findById(appointment.getAppointmentId());
			if(appointmentDb.isPresent()) {
				throw new AppointmentException("Appointment data already exists with ID : " +appointment.getAppointmentId());
			}
			 else {
				return appointmentDao.save(appointment);
			}
		}


		@Override
		public Appointment getAppointment(int appointmentId) throws AppointmentException {
	        Optional<Appointment> appointmentDb = appointmentDao.findById(appointmentId);
			if(appointmentDb.isPresent()) {
				return appointmentDb.get();
			}else {
				throw new AppointmentException("Record not found with ID : " +appointmentId);
			}
		}
		
	    private Appointment appointment;
		@Override
		public boolean deleteAppointment(int appointmentId){
			if(appointmentId > 0) {
				appointmentDao.deleteById(appointmentId);
				return true;		
			} 
			return false;
		}

		@Override
		public boolean updateAppointment(Appointment bean) throws ValidateAppointmentException {
			validateAppointment(bean);
			Optional<Appointment> appointmentDb = appointmentDao.findById(bean.getAppointmentId());
			if(appointmentDb.isPresent()) {
				 appointmentDao.save(bean);
				return true;	

			} else {
				return false;
			}
		}

		@Override
		public List<Appointment> getAppointments(Doctor doc) {
			List<Appointment> appt  = new ArrayList<>();
			if(appointment.getDoctor().getDoctorId() == doc.getDoctorId()) {
				appt.add(appointment);
			}
			return appt;
		}

		@Override
		public List<Appointment> getAppointments(LocalDate date) {
			return appointmentDao.findAllByAppointmentDate(date);
		}
		
		private boolean validateAppointment(Appointment appointment) throws ValidateAppointmentException{
			if (!appointment.getAppointmentStatus().matches("Approved") && !appointment.getAppointmentStatus().matches("Cancelled")
					&&!appointment.getAppointmentStatus().matches("Completed")) {
				throw new ValidateAppointmentException(AllConstants.STATUS_INVALID);
			}
			if (!appointment.getRemark().matches(AllConstants.NAME_REMARK)) {
				throw new ValidateAppointmentException(AllConstants.EMPTY_REMARK);
			}
			return true;
		}
}