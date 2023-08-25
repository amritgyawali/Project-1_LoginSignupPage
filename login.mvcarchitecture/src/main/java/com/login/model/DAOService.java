package com.login.model;

import java.sql.ResultSet;

public interface DAOService {
	public void connectDB();
	public boolean verifyLogin(String email,String password);
	public void saveRegistration(String name, String email , String password , String mobile);
	public boolean existsByEmail(String email);
	public boolean existsByMobile(String mobile);
	public ResultSet getAllRegistration();
}
