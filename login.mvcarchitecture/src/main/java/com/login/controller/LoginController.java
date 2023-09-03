package com.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.model.DAOService;
import com.login.model.DAOServiceImpl;
@WebServlet("/verifyLogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    
	    DAOService service = new DAOServiceImpl();
	    service.connectDB();
	    boolean status = service.verifyLogin(email, password);
	    
	    if (status) {
	        HttpSession session = request.getSession(true);
	        session.setAttribute("email", email);
	        
	        // Check if the "Remember Me" checkbox is selected
	        if (request.getParameter("rememberMe") != null) {
	            // Create a new cookie for remembering the email
	            Cookie emailCookie = new Cookie("rememberMeEmail", email);
	            
	            // Set the cookie's expiration time (e.g., 30 days)
	            emailCookie.setMaxAge(30 * 24 * 60 * 60); // 30 days in seconds
	            
	            // Add the cookie to the response
	            response.addCookie(emailCookie);
	        }
	        
	        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/new_registration.jsp");
	        rd.forward(request, response);
	    } else {
	        request.setAttribute("error", "Invalid email/password");
	        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	        rd.forward(request, response);
	    }
	}}
