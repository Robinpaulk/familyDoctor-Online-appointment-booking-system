package com.doctor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class AdminController {
	
	@GetMapping("/registerPatients")
	public String patientRegisterPage() {
		return "patients/register_patient";
	}
	@PostMapping("/login")
	public String loginPage() {
		return "patients/login";
	}
	
	@PostMapping("/loginPatient")
	public String patientDashBoard() {
		return "/patients/home";
	}
}
