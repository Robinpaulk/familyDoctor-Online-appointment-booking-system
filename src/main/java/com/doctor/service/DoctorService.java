package com.doctor.service;

import java.util.List;

import com.doctor.model.Doctor;

public interface DoctorService {

	
	Doctor saveDoctor(Doctor doctor);
	
	Doctor getDoctor(int docId);
	
	List<Doctor> getAllDoctors();

	List<Doctor> getAllDoctors(String category, String location);
}
