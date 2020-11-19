package com.doctor.service;

import com.doctor.model.User;
import com.doctor.web.dto.PatientRegistrationDTO;
import com.doctor.web.dto.PatientsLogin;

public interface UserService{
	User savePatient(PatientRegistrationDTO registrationDto);

	User checkLogin(PatientRegistrationDTO registrationDto);
	
}
