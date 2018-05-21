//package com.example.myapp2.models;
//
//import java.util.ArrayList;
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//public class Student extends User {
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private int id;
//	private String username;
//	private String password;
//	private String firstName;
//	private String lastName;
//	private String role;
//	private String email;
//	private String phone;
//	private Date dateOfBirth;
//	private double GPA;
//	private int graduationYear;
////	private ArrayList<Section> sections;
//	
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public String getFirstName() {
//		return firstName;
//	}
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//	public String getLastName() {
//		return lastName;
//	}
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getRole() {
//		return role;
//	}
//	public void setRole(String role) {
//		this.role = role;
//	}
//	public String getPhoneNumber() {
//		return phone;
//	}
//	public void setPhoneNumber(String num) {
//		this.phone = num;
//	}
//	public Date getBirthday() {
//		return dateOfBirth;
//	}
//	public void setBirthday(Date bday) {
//		this.dateOfBirth = bday;
//	}
//	public double getGPA() {
//		return GPA;
//	}
//	public void setGPA(double gpa) {
//		this.GPA = gpa;
//	}
//	public int getGraduationYear() {
//		return graduationYear;
//	}
//	public void setGraduationYear(int gradYear) {
//		this.graduationYear = gradYear;
//	}
////	public ArrayList<Section> getSections() {
////		return sections;
////	}
////	public void addSection(Section section) {
////		this.sections.add(section);
////	}
////	public void dropSection(Section section) {
////		this.sections.remove(section);
////	}
//}