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
	public void saveRegistration(String name, String city, String email, String mobile) {
		try {
			stmnt.executeUpdate("insert into registration values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public boolean existsByEmail(String email) {
		try {
			ResultSet result = stmnt.executeQuery("Select * from registration where email='"+email+"'");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean existsByMobile(String mobile) {
		try {
			ResultSet result = stmnt.executeQuery("Select * from registration where mobile='"+mobile+"'");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public ResultSet getAllRegistration(){
		try {

			ResultSet result = stmnt.executeQuery("Select * from registration");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void deleteByEmail(String email) {
		try {
			stmnt.executeUpdate("delete from registration where email='"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void updateRegistration(String email, String mobile) {
		try {
			stmnt.executeUpdate("Update registration SET mobile='"+mobile+"' WHERE email='"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void loginreg(String name, String email, String mobile, String password) {
		try {
			stmnt.executeUpdate("insert into login values('"+name+"','"+email+"','"+password+"','"+mobile+"')");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public boolean existsByloginEmail(String email) {
		try {
			ResultSet result = stmnt.executeQuery("Select * from login where email='"+email+"'");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean existsByloginMobile(String mobile) {
		try {
			ResultSet result = stmnt.executeQuery("Select * from login where mobile='"+mobile+"'");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public void forget(String email, String password) {
		try {
			stmnt.executeUpdate("Update login SET password='"+password+"' WHERE email='"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
