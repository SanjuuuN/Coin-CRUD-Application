package com.serviceLayer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.businessLogic.CRUD;
import com.model.Coin;

@WebServlet("/ReadServiceLayer")
public class ReadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ReadServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Fetch all coins
        List<Coin> coins = CRUD.getAllCoins();
        
        // Set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        // Write HTML response
        out.println("<html><head><title>Coins List</title></head><body>");
        out.println("<h2>Coins List:</h2>");
        out.println("<table border=\"1\"><tr><th>Coin Name</th><th>Quantity</th><th>Value</th><th>Country</th></tr>");

        for (Coin coin : coins) {
            out.println("<tr><td>" + coin.getCoinName() + "</td><td>" + coin.getCoinQuantity() + "</td><td>" + coin.getValue() + "</td><td>"
                    + coin.getCountryOfOrigin() + "</td></tr>");
        }

        out.println("</table></body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
