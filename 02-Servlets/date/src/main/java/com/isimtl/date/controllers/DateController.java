package com.isimtl.date.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DateController", urlPatterns = { "" })
public class DateController extends HttpServlet
{
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        LocalDateTime now = LocalDateTime.now();
        
        response.addIntHeader("refresh", 1);
        
        try (PrintWriter out = response.getWriter())
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Date</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>Current date: " + dateFormatter.format(now) + "</p>");
            out.println("<p>Current time: " + timeFormatter.format(now) + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
