package com.login.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.model.DAOService;
import com.login.model.DAOServiceImpl;
@WebServlet("/forget")
public class forget extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public forget() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		request.setAttribute("email", email);
		request.setAttribute("password", password);
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		DAOService service = new DAOServiceImpl();
		service.connectDB();
		service.forget(email,password);
		ResultSet result = service.getAllRegistration();
		request.setAttribute("res", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("forget.jsp");
		rd.forward(request, response);
		}
	}


