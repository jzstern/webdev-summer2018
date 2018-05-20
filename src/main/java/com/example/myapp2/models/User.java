package com.example.myapp2.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
	private int id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String role;
	private String email;
	private String phone;
	private Date dateOfBirth;
	
	// For Faculty
	private Boolean tenured;
	private String office;
	
	// For Students
	private Double GPA;
	private Integer graduationYear;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPhoneNumber() {
		return phone;
	}
	public void setPhoneNumber(String num) {
		this.phone = num;
	}
	public Date getBirthday() {
		return dateOfBirth;
	}
	public void setBirthday(Date bday) {
		this.dateOfBirth = bday;
	}
	public Double getGPA() {
		return GPA;
	}
	public void setGPA(Double gpa) {
		this.GPA = gpa;
	}
	public Integer getGraduationYear() {
		return graduationYear;
	}
	public void setGraduationYear(Integer gradYear) {
		this.graduationYear = gradYear;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public Boolean getTenure() {
		return tenured;
	}
	public void setTenure(Boolean tenure) {
		this.tenured = tenure;
	}
}