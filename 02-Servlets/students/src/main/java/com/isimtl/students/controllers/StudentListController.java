package com.isimtl.students.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isimtl.students.models.Student;
import com.isimtl.students.services.StudentService;

@WebServlet(name = "StudentListController", urlPatterns = { "", "/students" })
public class StudentListController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        StudentService service = new StudentService();
        ArrayList<Student> students = service.getStudents();
        
        try (PrintWriter out = response.getWriter())
        {
            response.setContentType("text/html;charset=UTF-8");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Students</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Students</h1>");
            
            for (Student student : students)
            {
                out.println("<ul>");
                out.println("<li>" + student.toString()+ "</li>");
                out.println("<li>Date of birth: " + student.getDateOfBirth() + "</li>");
                out.println("<li>Age: " + student.getAge() + "</li>");
                out.println("</ul>");
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }
}
