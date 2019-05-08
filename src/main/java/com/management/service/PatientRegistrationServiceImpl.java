package com.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.dao.PatientRegistrationDAO;
import com.management.model.Patient;

@Service
public class PatientRegistrationServiceImpl implements PatientRegistrationService {
	public PatientRegistrationDAO patientRegistraionDao;
	
	@Autowired
	public void setPatientRegistrationDAO(PatientRegistrationDAO patientRegistraionDao) {
		this.patientRegistraionDao=patientRegistraionDao;
	}
	
	@Override
	public List<Patient> getAllPatients() {
		List<Patient> patientList=patientRegistraionDao.getAllPatients();
		return patientList;
	}
	
	@Override
	public Patient viewPatient(int id) {
		Patient patient=patientRegistraionDao.viewPatient(id);
		return patient;
		
	}

	@Override
	public void addPatient(Patient patient) {
	
	patientRegistraionDao.addPatient(patient);
	
	}

	@Override
	public void updatePatient(Patient patient) {
		patientRegistraionDao.updatePatient(patient);
		
	}

	@Override
	public void deletePatient(int id) {
		
		patientRegistraionDao.deletePatient(id);
	}

}
