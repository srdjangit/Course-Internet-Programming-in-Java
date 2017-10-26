package com.jsf.crud;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.jsf.crud.db.operations.DatabaseOperation;

@ManagedBean @RequestScoped
public class StudentBean {

	private int id;  
	private String name;  
	private String email;  
	private String password;  
	private String gender;  
	private String address;
	private String godina_studija;
	private int budzetski_student;
	private String studentski_racun;

	public ArrayList<StudentBean>studentsListFromDB;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}  
	
	public String getGodina_studija() {
		return godina_studija;
	}

	public void setGodina_studija(String godina_studija) {
		this.godina_studija = godina_studija;
	}  
	
		
	public int getBudzetski_student() {
		return budzetski_student;
	}

	public void setBudzetski_student(int budzetski_student) {
		this.budzetski_student = budzetski_student;
	} 
	
	
	public String getStudentski_racun() {
		return studentski_racun;
	}

	public void setStudentski_racun(String studentski_racun) {
		this.studentski_racun = studentski_racun;
	} 
	
	
	
	
	
	
	@PostConstruct
	public void init() {
		studentsListFromDB = DatabaseOperation.getStudentsListFromDB();
	}

	
	public ArrayList<StudentBean> studentsList() {
		return studentsListFromDB;
	}
	

	public String saveStudentDetails(StudentBean newStudentObj) {
		return DatabaseOperation.saveStudentDetailsInDB(newStudentObj);
	}
	

	public String editStudentRecord(int studentId) {
		return DatabaseOperation.editStudentRecordInDB(studentId);
	}
	

	public String updateStudentDetails(StudentBean updateStudentObj) {
		return DatabaseOperation.updateStudentDetailsInDB(updateStudentObj);
	}
	

	public String deleteStudentRecord(int studentId) {
		return DatabaseOperation.deleteStudentRecordInDB(studentId);
	}
}