package com.cg.bookmydoctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.dto.FeedBack;
import com.cg.bookmydoctor.exception.FeedBackException;
import com.cg.bookmydoctor.exception.ValidateFeedBackException;
import com.cg.bookmydoctor.service.IFeedbackService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/feedback")
public class FeedBackController {

	@Autowired
	private IFeedbackService feedbackService;

	@GetMapping("/getallfeedbacks")
	public List<FeedBack> getAllFeedBacks(@RequestParam(value = "doctorId", required = false) Integer doctorId) {
		Doctor doctor = null;
		if (doctorId != null) {
			// Assuming Doctor entity has a constructor that takes an ID
			doctor = new Doctor();
			doctor.setDoctorId(doctorId);
		}
		return feedbackService.getAllFeedback(doctor);
	}

	@PostMapping("/addfeedback")
	public FeedBack addFeedback(@RequestBody FeedBack feedback) throws FeedBackException, ValidateFeedBackException {
		return feedbackService.addFeedback(feedback);
	}

	@GetMapping("/getfeedback")
	public FeedBack getFeedback(@RequestParam("feedbackid") int feedbackId) throws FeedBackException {
		FeedBack feedback = new FeedBack();
		feedback.setFeedbackId(feedbackId);
		return feedbackService.getFeedback(feedback);
	}
}
