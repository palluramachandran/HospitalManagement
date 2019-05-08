package com.management.dao;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.management.model.Patient;


@Repository
public class PatientRegistrationDAOImpl implements PatientRegistrationDAO {
	public JdbcTemplate jdbcTemplate;
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
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
	public Patient viewPatient(int id) {
		Patient p1=new Patient(1001,"pallavi",23,"9867543423","bangalore");
		return p1;
		
	}

	@Override
	public void addPatient(Patient patient) {
		String sql="insert into HOSPITAL.PATIENT(id,name,age,contactno,address) values(?,?,?,?,?)";
		jdbcTemplate.update(sql,patient.getId(),patient.getName(),patient.getAge(),patient.getContactNo(),patient.getAddress());
		System.out.println(patient.getId()+""+patient.getName()+""+patient.getAge()+""+patient.getContactNo()+""+patient.getAddress());
		
	}

	@Override
	public void updatePatient(Patient patient) {
		System.out.println(patient.getId()+""+patient.getName()+""+patient.getAge()+""+patient.getContactNo()+""+patient.getAddress());
		
		
	}

	@Override
	public void deletePatient(int id) {
		System.out.println("patient deleted"+id);
	}



}
