package com.doctor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.doctor.model.Doctor;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

	@Query("SELECT u FROM Doctor u WHERE u.category =?1 AND u.location = ?2")
	List<Doctor> findDoctorByCategoryAndLocation(String category, String location);

}
