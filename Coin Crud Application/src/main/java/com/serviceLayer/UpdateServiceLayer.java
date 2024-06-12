package com.serviceLayer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.businessLogic.CRUD;


@WebServlet("/UpdateServiceLayer")
public class UpdateServiceLayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   
    public UpdateServiceLayer() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String nm = request.getParameter("coinNameToUpdate");
		String val= request.getParameter("coinvaluetoupdate");
		CRUD ref = new CRUD();
		ref.update(nm,val);
		PrintWriter out;
		out=response.getWriter();
		out.print("Updated successfully!!");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
