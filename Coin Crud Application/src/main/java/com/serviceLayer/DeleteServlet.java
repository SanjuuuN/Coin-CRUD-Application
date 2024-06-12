package com.serviceLayer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.businessLogic.CRUD;

@WebServlet("/DeleteServiceLayer")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Delete operation should be done via POST request, redirecting to doPost
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String coinName = request.getParameter("coinName"); // Assuming you get coinName as parameter

        // Perform delete operation based on coinName
        boolean deleted = CRUD.delete(coinName) ;

        // Set response content type
        response.setContentType("text/html");

        // Create PrintWriter
        PrintWriter out = response.getWriter();

        // Write HTML response
        out.println("<html><body>");

        if (deleted) {
            out.println("<h2>Successfully deleted coin: " + coinName + "</h2>");
        } else {
            out.println("<h2>Failed to delete coin: " + coinName + "</h2>");
        }

        out.println("</body></html>");
    }
}
