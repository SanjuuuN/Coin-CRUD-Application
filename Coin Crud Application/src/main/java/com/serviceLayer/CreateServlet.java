package com.serviceLayer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.businessLogic.CRUD;
import com.model.Coin;

@WebServlet("/CreateServiceLayer")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CreateServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String nm = request.getParameter("coinName");
		String coinquantity = request.getParameter("coinQuantity");
		String coinvalue = request.getParameter("coinValue");
		String coincountry = request.getParameter("coinCountry");
		Coin coinobj = new Coin(nm,coinquantity,coinvalue,coincountry);
		
		CRUD ref = new CRUD();
		ref.add(coinobj);
		PrintWriter out;
		out=response.getWriter();
		out.print("Created successfully!!");
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
