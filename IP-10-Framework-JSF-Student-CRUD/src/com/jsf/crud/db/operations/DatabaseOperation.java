package com.jsf.crud.db.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.jsf.crud.StudentBean;

public class DatabaseOperation {

	public static Statement stmtObj;
	public static Connection connObj;
	public static ResultSet resultSetObj;
	public static PreparedStatement pstmt;


	public static Connection getConnection(){  
		try{  
			Class.forName("com.mysql.jdbc.Driver");     
			String db_url ="jdbc:mysql://localhost:3306/student",
					db_userName = "root",
					db_password = "";
			connObj = DriverManager.getConnection(db_url,db_userName,db_password);  
		} catch(Exception sqlException) {  
			sqlException.printStackTrace();
		}  
		return connObj;
	}


	public static ArrayList<StudentBean> getStudentsListFromDB() {
		ArrayList<StudentBean> studentsList = new ArrayList<StudentBean>();  
		try {
			stmtObj = getConnection().createStatement();    
			resultSetObj = stmtObj.executeQuery("select * from student_record");    
			while(resultSetObj.next()) {  
				StudentBean stuObj = new StudentBean(); 
				stuObj.setId(resultSetObj.getInt("student_id"));  
				stuObj.setName(resultSetObj.getString("student_name"));  
				stuObj.setEmail(resultSetObj.getString("student_email"));  
				stuObj.setPassword(resultSetObj.getString("student_password"));  
				stuObj.setGender(resultSetObj.getString("student_gender"));  
				stuObj.setAddress(resultSetObj.getString("student_address")); 
				stuObj.setGodina_studija(resultSetObj.getString("godina_studija")); 
				stuObj.setBudzetski_student(resultSetObj.getInt("budzetski_student")); 
				stuObj.setStudentski_racun(resultSetObj.getString("studentski_racun")); 
						
				
				studentsList.add(stuObj);  
			}   
			System.out.println("Total Records Fetched: " + studentsList.size());
			connObj.close();
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
		} 
		return studentsList;
	}


	public static String saveStudentDetailsInDB(StudentBean newStudentObj) {
		int saveResult = 0;
		String navigationResult = "";
		try {      
			pstmt = getConnection().prepareStatement("insert into student_record (student_name, student_email, student_password, student_gender, student_address,godina_studija,budzetski_student,studentski_racun) values (?, ?, ?, ?, ?,?,?,?)");			
			pstmt.setString(1, newStudentObj.getName());
			pstmt.setString(2, newStudentObj.getEmail());
			pstmt.setString(3, newStudentObj.getPassword());
			pstmt.setString(4, newStudentObj.getGender());
			pstmt.setString(5, newStudentObj.getAddress());
			pstmt.setString(6, newStudentObj.getGodina_studija());
			pstmt.setInt(7, newStudentObj.getBudzetski_student());
			pstmt.setString(8, newStudentObj.getStudentski_racun());
			
			
			saveResult = pstmt.executeUpdate();
			connObj.close();
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
		}
		if(saveResult !=0) {
			navigationResult = "studentsList.xhtml?faces-redirect=true";
		} else {
			navigationResult = "createStudent.xhtml?faces-redirect=true";
		}
		return navigationResult;
	}


	public static String editStudentRecordInDB(int studentId) {
		StudentBean editRecord = null;
		System.out.println("editStudentRecordInDB() : Student Id: " + studentId);


		Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		try {
			stmtObj = getConnection().createStatement();    
			resultSetObj = stmtObj.executeQuery("select * from student_record where student_id = "+studentId);    
			if(resultSetObj != null) {
				resultSetObj.next();
				editRecord = new StudentBean(); 
				editRecord.setId(resultSetObj.getInt("student_id"));
				editRecord.setName(resultSetObj.getString("student_name"));
				editRecord.setEmail(resultSetObj.getString("student_email"));
				editRecord.setGender(resultSetObj.getString("student_gender"));
				editRecord.setAddress(resultSetObj.getString("student_address"));
				editRecord.setPassword(resultSetObj.getString("student_password")); 
				editRecord.setGodina_studija(resultSetObj.getString("godina_studija")); 
				editRecord.setBudzetski_student(resultSetObj.getInt("budzetski_student"));
				editRecord.setStudentski_racun(resultSetObj.getString("studentski_racun")); 
				
				
				
				
			}
			sessionMapObj.put("editRecordObj", editRecord);
			connObj.close();
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
		}
		return "/editStudent.xhtml?faces-redirect=true";
	}


	public static String updateStudentDetailsInDB(StudentBean updateStudentObj) {
		try {
			pstmt = getConnection().prepareStatement("update student_record set student_name=?, student_email=?, student_password=?, student_gender=?, student_address=?,godina_studija=?,budzetski_student=?,studentski_racun=? where student_id=?");    
			pstmt.setString(1,updateStudentObj.getName());  
			pstmt.setString(2,updateStudentObj.getEmail());  
			pstmt.setString(3,updateStudentObj.getPassword());  
			pstmt.setString(4,updateStudentObj.getGender());  
			pstmt.setString(5,updateStudentObj.getAddress());  
			pstmt.setString(6,updateStudentObj.getGodina_studija()); 
			pstmt.setInt(7,updateStudentObj.getBudzetski_student()); 
			pstmt.setString(8,updateStudentObj.getStudentski_racun());
			pstmt.setInt(9,updateStudentObj.getId()); 
			
			
			
			pstmt.executeUpdate();
			connObj.close();			
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
		}
		return "/studentsList.xhtml?faces-redirect=true";
	}


	public static String deleteStudentRecordInDB(int studentId){
		System.out.println("deleteStudentRecordInDB() : Student Id: " + studentId);
		try {
			pstmt = getConnection().prepareStatement("delete from student_record where student_id = "+studentId);  
			pstmt.executeUpdate();  
			connObj.close();
		} catch(Exception sqlException){
			sqlException.printStackTrace();
		}
		return "/studentsList.xhtml?faces-redirect=true";
	}
}