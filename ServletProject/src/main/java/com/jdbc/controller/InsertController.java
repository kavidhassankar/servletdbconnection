package com.jdbc.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.jdbc.dto.User;
import com.servlet.db.DbUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class InsertController
 */
@WebServlet("/InsertController")
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public InsertController() {
       super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String Name = request.getParameter("name");
		String Email = request.getParameter("email");
		String Phone = request.getParameter("phone");

		User member =new User();
		try {
			DbUtil.saveUser(member);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
			request.getRequestDispatcher("Success.jsp").include(request,response);

		
		}
	}

	


