package com.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.model.DAOService;
import com.login.model.DAOServiceImpl;

@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public RegistrationController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/new_registration.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	String mobile = request.getParameter("mobile");
	
	DAOService service = new DAOServiceImpl();
	service.connectDB();
	
	boolean statusOfEmail = service.existsByEmail(email);
	boolean statusOfMobile = service.existsByMobile(mobile);
	if(statusOfEmail || statusOfMobile) {
		request.setAttribute("msg", "Email/Mobile Already Exist!!");
	}
	else {
		service.saveRegistration(name, password, email, mobile);
		request.setAttribute("msg", "Record is saved");
	}
	
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/new_registration.jsp");
	rd.forward(request, response);
	}
	
	}


