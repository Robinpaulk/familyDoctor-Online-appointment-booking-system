package com.doctor.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.doctor.model.User;
import com.doctor.repository.UserRepository;
import com.doctor.web.dto.PatientRegistrationDTO;
import com.doctor.web.dto.PatientsLogin;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User savePatient(PatientRegistrationDTO registrationDto) {
		User user = new User(registrationDto.getFirstName(),registrationDto.getLastName(),
				registrationDto.getEmail(),registrationDto.getMobileNumber(),
				registrationDto.getAddress(),
				registrationDto.getGender(),
				registrationDto.getPassword(),registrationDto.getDob());
		
		return userRepo.save(user);
	}

	@Override
	public User checkLogin(PatientRegistrationDTO registrationDto) {
		 User userExists = userRepo.findByEmailAndPassword(registrationDto.getEmail(), registrationDto.getPassword());
		 if(userExists == null) {
			  throw new UsernameNotFoundException("Invalid User Name or Password");
		 }  else {
			return userExists; 
		 }
	}

	
}
