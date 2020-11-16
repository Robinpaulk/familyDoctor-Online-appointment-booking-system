package com.doctor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class AdminController {
	
	@GetMapping("/registerPatients")
	public String patientRegisterPage() {
		return "register_patient";
	}
}
