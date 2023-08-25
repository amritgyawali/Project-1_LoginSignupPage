package com.login.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOServiceImpl implements DAOService {
	private Connection con;
	private Statement stmnt;

	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_con_1","root","test");
			stmnt = con.createStatement();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public boolean verifyLogin(String email, String password) {
		try {
			ResultSet result = stmnt.executeQuery("Select * from login where email='"+email+"' and password='"+password+"'");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public void saveRegistration(String name, String email, String password, String mobile) {
		try {
			stmnt.executeUpdate("insert into registration values('"+name+"','"+email+"','"+password+"','"+mobile+"')");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public boolean existsByEmail(String email) {
		try {
			ResultSet result = stmnt.executeQuery("Select * from login where email='"+email+"'");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean existsByMobile(String mobile) {
		try {
			ResultSet result = stmnt.executeQuery("Select * from login where mobile='"+mobile+"'");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public ResultSet getAllRegistration(){
		try {

			ResultSet result = stmnt.executeQuery("Select * from login");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
