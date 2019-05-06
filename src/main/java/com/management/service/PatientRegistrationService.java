package com.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.management.model.Patient;

public interface PatientRegistrationService {
	public List<Patient> getAllPatients();
	public void addPatient(Patient patient);
	public void updatePatient(Patient patient);
	public void deletePatient(int id);
	
	

}
