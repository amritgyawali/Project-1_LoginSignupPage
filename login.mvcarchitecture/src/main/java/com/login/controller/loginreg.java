package com.login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.model.DAOService;
import com.login.model.DAOServiceImpl;

@WebServlet("/loginreg")
public class loginreg extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public loginreg() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/new_registration.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
	
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	String mobile = request.getParameter("mobile");
	
	
	DAOService service = new DAOServiceImpl();
	service.connectDB();
	
	boolean statusOfEmail = service.existsByloginEmail(email);
	boolean statusOfMobile = service.existsByloginMobile(mobile);
	if(statusOfEmail || statusOfMobile) {
		request.setAttribute("msg", "Email/Mobile Already Exist!!");
	}
	else {
		service.loginreg(name, email, mobile, password);
		request.setAttribute("msg", "Successfully Signup <a href='login.jsp'>Login</a>");
		out.print("Login");
	}
	RequestDispatcher rd = request.getRequestDispatcher("loginreg.jsp");
	  rd.forward(request, response);
	}
	
	}


