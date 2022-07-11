package com.isimtl.students.services;

import com.isimtl.students.models.Student;
import java.time.LocalDate;
import java.util.ArrayList;

public class StudentService
{
    private static final ArrayList<Student> students = createStudents();
    
    private static ArrayList<Student> createStudents()
    {
        long id = 10001;

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(id++, "Anna", "Brown", LocalDate.of(1999, 5, 31)));
        students.add(new Student(id++, "Catherine", "Dubois", LocalDate.of(2001, 9, 15)));
        students.add(new Student(id++, "Emily", "Freeman", LocalDate.of(1997, 1, 28)));
        students.add(new Student(id++, "Gabriel", "Harcourt", LocalDate.of(2002, 11, 06)));
        return students;
    }
    
    public ArrayList<Student> getStudents()
    {
        return students;
    }
}
