package com.management.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.management.dao.PatientRegistrationDAO;
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
	
	@RequestMapping(value="/viewPatient",method=RequestMethod.POST)
	public ModelAndView viewPatient(HttpServletRequest request)
	{
		 String patientId=request.getParameter("id");
		 int id=Integer.parseInt(patientId);
		 Patient patient=patientRegistrationService.viewPatient(id);
		 patient.setMode("V");
		 ModelAndView viewModel=new ModelAndView();
		 viewModel.setViewName("patient");
		 viewModel.addObject("patient",patient);
		 return viewModel;
		 
		 
}
	
	@RequestMapping(value="/addPatient",method=RequestMethod.POST)
	public ModelAndView addPatient()
	{
		ModelAndView addModel=new ModelAndView();
		addModel.setViewName("patient");
		Patient patient=new Patient();
		addModel.addObject("patient",patient);
		return addModel;
		
		}
	@RequestMapping(value="/addPatientSubmit",method=RequestMethod.POST)
	public String addPatientSubmit(@ModelAttribute Patient patient,HttpServletRequest request,HttpServletResponse response) throws Exception, IOException
	{
		patientRegistrationService.addPatient(patient);
		return "redirect:patientRegistration";
		
	}
	
	@RequestMapping(value="/updatePatient",method=RequestMethod.POST)
	public ModelAndView updatePatient(HttpServletRequest request)
	{
		String patientId=request.getParameter("id");
		int id=Integer.parseInt(patientId);
		Patient patient=patientRegistrationService.viewPatient(id);
		ModelAndView updateModel=new ModelAndView();
		updateModel.setViewName("patient");
		updateModel.addObject("patient",patient);
		return updateModel;
		
	}
	@RequestMapping(value="/updatePatientSubmit",method=RequestMethod.POST)
	public String updatePatientSubmit(@ModelAttribute Patient patient,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		
		patientRegistrationService.updatePatient(patient);
		return "redirect:patientRegistration";
		
		
	}
	
	@RequestMapping(value="/deletePatient",method=RequestMethod.POST)
	public String deletePatient(HttpServletRequest request)
	{
		String patientId=request.getParameter("id");
		int id=Integer.parseInt(patientId);
		patientRegistrationService.deletePatient(id);
		return "redirect:patientRegistration";
		
	}
	
	
}
