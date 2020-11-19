package com.doctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.doctor.model.Appointment;
import com.doctor.model.Doctor;
import com.doctor.service.BookService;
import com.doctor.service.DoctorService;
import com.doctor.service.UserService;
import com.doctor.web.dto.PatientRegistrationDTO;
import com.doctor.web.dto.PatientsLogin;

@Controller
@RequestMapping("/api")
public class AdminController {
	
	@Autowired
	private DoctorService docService;
	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;
	
	@ModelAttribute("patient")
	public PatientRegistrationDTO registrationDTO() {
		return new PatientRegistrationDTO();
	}
	
	
	@GetMapping("/registerPatients")
	public String register() {
		return "/patients/register_patient";
	}
	
	@PostMapping("/registerPatients")
	public String patientRegisterPage(@ModelAttribute("patient") PatientRegistrationDTO registrationDTO) {
		
		userService.savePatient(registrationDTO);
		
		return "patients/register_patient";
	}
	@GetMapping("/login")
	public String login() {
		return "patients/login";
	}
	
//	@PostMapping("/login")
//	public String patientDashBoard(@ModelAttribute("patient") PatientsLogin loginDTO) {
//		//here to check the email is already present or not
//		//not present return an error
//		//else return home
//		 userService.checkLogin(loginDTO);
//		
//		//return "/patients/home";
//	}
	
	@PostMapping("/login")
	public String patientHome(@ModelAttribute("patient") PatientRegistrationDTO registrationDTO) {
		userService.checkLogin(registrationDTO) ;
		return "/patients/home";
	}
	
	@GetMapping("/searchDoctors")
	public String serachDoctors() {
		return "/patients/searchDoctors";
	}
	
    @PostMapping("/findDoctors")
	public String listAllDoctors(@RequestParam("category") String category, @RequestParam("location") String location,Model model) {
		List<Doctor> doctors = docService.getAllDoctors(category,location);
		model.addAttribute("doctors", doctors);
		return "/patients/result";
	}
    
    @PostMapping("/edit/{id}")
    public Appointment bookDoctor(@PathVariable("id") int docId , @RequestBody Appointment appointment) {
    	return bookService.saveBooking(appointment);
}
}
