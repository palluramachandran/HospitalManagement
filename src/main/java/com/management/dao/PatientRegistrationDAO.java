package com.management.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.management.model.Patient;

public interface PatientRegistrationDAO {
	public List<Patient> getAllPatients();
	public void addPatient(Patient patient);
	public void updatePatient(Patient patient);
	public void deletePatient(int id);
	}
