package com.management.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.management.model.Patient;

@Repository
public class PatientRegistrationDAOImpl implements PatientRegistrationDAO {
	
	@Override
	public List<Patient> getAllPatients() {
		Patient p1=new Patient(1001,"pallavi",23,"9867543423","bangalore");
		Patient p2=new Patient(1002,"sharath",27,"9456888887","kanhagad");
		List<Patient> patientList=new ArrayList<>();
		patientList.add(p1);
		patientList.add(p2);
		
		return patientList;
	}

	@Override
	public void addPatient(Patient patient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePatient(Patient patient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePatient(int id) {
		// TODO Auto-generated method stub
		
	}



}
