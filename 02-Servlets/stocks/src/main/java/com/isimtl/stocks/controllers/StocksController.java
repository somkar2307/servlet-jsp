package com.isimtl.stocks.controllers;

import com.isimtl.utility.formatting.CurrencyHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "StocksController", urlPatterns = { "", "/stocks" })
public class StocksController extends HttpServlet
{
    private static final Random random = new Random();
    private static final NumberFormat formatter = CurrencyHelper.getCurrencyFormatter(Locale.US);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setIntHeader("refresh", 3);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Stock Prices</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Stock Prices</h1>");
            out.println("<p>Oracle: " + formatter.format(getRandomNumber()) + "</p>");
            out.println("<p>Microsoft: " + formatter.format(getRandomNumber()) + "</p>");
            out.println("<p>Google: " + formatter.format(getRandomNumber()) + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private static double getRandomNumber()
    {
        return random.nextDouble(50, 100);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>
}
