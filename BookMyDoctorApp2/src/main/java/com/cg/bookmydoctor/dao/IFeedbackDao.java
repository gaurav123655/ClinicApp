package com.cg.bookmydoctor.dao;

import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.dto.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.bookmydoctor.dto.FeedBack;

import java.util.List;

public interface IFeedbackDao extends JpaRepository<FeedBack, Integer> {

    // Method to find all feedbacks for a specific doctor
    List<FeedBack> findByDoctor(Doctor doctor);

    // Optional: Method to find all feedbacks for a specific patient
    List<FeedBack> findByPatient(Patient patient);

    // Optional: Method to get all feedbacks
    List<FeedBack> findAll();
	
}
