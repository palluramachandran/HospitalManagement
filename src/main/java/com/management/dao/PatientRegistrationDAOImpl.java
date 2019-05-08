package com.management.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
		String sql="select * from HOSPITAL.PATIENT";		
		List<Patient>patientList=jdbcTemplate.query(sql, new RowMapper<Patient>() {
			@Override
			public Patient mapRow(ResultSet rs,int rowNum) throws SQLException {
				Patient patient = new Patient();
				patient.setId(rs.getInt("ID"));
				patient.setName(rs.getString("NAME"));
				patient.setAge(rs.getInt("AGE"));
				patient.setContactNo(rs.getString("CONTACTNO"));
				patient.setAddress(rs.getString("ADDRESS"));
				return patient;
			}
		});
		
		return patientList;
	}

	@Override
	public Patient viewPatient(int id) {
		String sql="select * from HOSPITAL.PATIENT WHERE ID=?";	
		Patient patient=jdbcTemplate.queryForObject(sql, new RowMapper<Patient>() {
			@Override
			public Patient mapRow(ResultSet rs,int rowNum) throws SQLException {
				Patient patient = new Patient();
				patient.setId(rs.getInt("ID"));
				patient.setName(rs.getString("NAME"));
				patient.setAge(rs.getInt("AGE"));
				patient.setContactNo(rs.getString("CONTACTNO"));
				patient.setAddress(rs.getString("ADDRESS"));
				return patient;
			}
		},id);
		
		return patient;
		
	}

	@Override
	public void addPatient(Patient patient) {
		String insertSql="insert into HOSPITAL.PATIENT(id,name,age,contactno,address) values(?,?,?,?,?)";
		jdbcTemplate.update(insertSql,patient.getId(),patient.getName(),patient.getAge(),patient.getContactNo(),patient.getAddress());
		
	}

	@Override
	public void updatePatient(Patient patient) {
		String updateSql="update HOSPITAL.PATIENT SET ID=?,NAME=?,AGE=?,CONTACTNO=?,ADDRESS=? WHERE ID=?";
		jdbcTemplate.update(updateSql,patient.getId(),patient.getName(),patient.getAge(),patient.getContactNo(),patient.getAddress(),patient.getId());
		
		
	}

	@Override
	public void deletePatient(int id) {
		String deleteSql="delete from HOSPITAL.PATIENT WHERE ID=?";
		jdbcTemplate.update(deleteSql,id);
	}



}
