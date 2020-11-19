package com.doctor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.model.Appointment;
import com.doctor.repository.AppointmentRepository;
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private AppointmentRepository appointmentRepo;
	
	@Override
	public Appointment saveBooking(Appointment appointment) {
		return appointmentRepo.save(appointment);
	}
	
}
