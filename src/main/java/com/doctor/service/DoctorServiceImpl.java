package com.doctor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.model.Doctor;
import com.doctor.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	private DoctorRepository docRepo;
	
	@Override
	public Doctor saveDoctor(Doctor doctor) {
		
		return docRepo.save(doctor);
	}

	@Override
	public Doctor getDoctor(int docId) {
		
		Optional<Doctor> doctor = docRepo.findById(docId);
		if(doctor.isPresent()) {
			return doctor.get();
		}else {
			throw new ArithmeticException("Doctors not found");
		}
	}

	@Override
	public List<Doctor> getAllDoctors() {
		
		return docRepo.findAll();
	}

	@Override
	public List<Doctor> getAllDoctors(String category, String location) {
		return docRepo.findDoctorByCategoryAndLocation(category, location);
	}

}
