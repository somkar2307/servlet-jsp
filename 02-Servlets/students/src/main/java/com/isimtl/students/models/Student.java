package com.isimtl.students.models;

import java.time.LocalDate;
import java.time.Period;

public class Student
{
    private final long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    
    public Student(long id, String firstName, String lastName, LocalDate dateOfBirth)
    {
        if (firstName == null)
            throw new IllegalArgumentException("First name must not be null.");
        if (lastName == null)
            throw new IllegalArgumentException("Last name must not be null.");
        if (dateOfBirth == null)
            throw new IllegalArgumentException("Date of birth must not be null.");
        if (dateOfBirth.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Date of birth must not be in the future.");
        
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }
    
    public long getId()
    {
        return id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        if (firstName != null)
            this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        if (lastName != null)
            this.lastName = lastName;
    }
    
    public LocalDate getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth)
    {
        if (dateOfBirth != null)
            this.dateOfBirth = dateOfBirth;
    }
    
    public String getFullName()
    {
        return firstName + " " + lastName;
    }

    public int getAge()
    {
        LocalDate today = LocalDate.now();
        Period period = Period.between(dateOfBirth, today);
        return period.getYears();
    }

    @Override
    public String toString()
    {
        return "Student " + id + " " + getFullName();
    }
}
