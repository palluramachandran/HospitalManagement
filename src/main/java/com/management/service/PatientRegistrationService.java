package com.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.management.model.Patient;

public interface PatientRegistrationService {
	public List<Patient> getAllPatients();
	public Patient viewPatient(int id);
	public void addPatient(Patient patient);
	public void updatePatient(Patient patient);
	public void deletePatient(int id);
	
}
