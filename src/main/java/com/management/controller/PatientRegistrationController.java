package com.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.management.model.Patient;
import com.management.service.PatientRegistrationService;

@Controller
public class PatientRegistrationController {
	public PatientRegistrationService patientRegistrationService;
	
	@Autowired
	public void setPatientRegistrationService(PatientRegistrationService patientRegistrationService )
	{
		this.patientRegistrationService=patientRegistrationService;
	}
	
	@RequestMapping(value="/patientRegistration",method=RequestMethod.GET)
	public ModelAndView getAllPatients()
	{
		System.out.println("Inside Patient Registration");
		ModelAndView model=new ModelAndView();
		model.setViewName("patientRecords");
		List<Patient> patientList=patientRegistrationService.getAllPatients();
		model.addObject("patientList", patientList);
		return model;
	}

}
