package com.management.model;

public class Patient {
	int id;
	String name;
	int age;
	String contactNo;
	String address;
	String mode;
	public Patient()
	{
		
	}
	public Patient(int id,String name,int age,String contactNo,String address)
	{
		this.id=id;
		this.name=name;
		this.age=age;
		this.contactNo=contactNo;
		this.address=address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}

}
