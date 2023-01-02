/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ua.edu.sumdu;

import java.io.Serializable;

public class Student implements Serializable{

    protected String name;
    protected String surname;
    protected String email;
    protected String group;
    protected String faculty;
    protected String age;

    public Student(String name,
                   String surname,
                   String email,
                   String group,
                   String faculty,
                   String age) throws Exception {
        setName(name);
        setSurname(surname);
        setEmail(email);
        setGroup(group);
        setFaculty(faculty);
        setAge(age);
    }

    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getEmail(){
        return email;
    }
    public String getFaculty(){
        return faculty;
    }
    public String getGroup(){
        return group;
    }
    public String getAge(){
        return age;
    }
    public void setName(String name) throws Exception {
        if (name == null || name.isBlank()) {
            throw new Exception("The fields cannot be empty");
        }

        this.name = name;
    }

    public void setSurname(String surname) throws Exception {
        if (surname == null || surname.isBlank()) {
            throw new Exception("The fields cannot be empty");
        }

        this.surname = surname;
    }

    public void setEmail(String email) throws Exception {
        if (email == null || email.isBlank()) {
            throw new Exception("The fields cannot be empty");
        }

        this.email = email;
    }

    public void setGroup(String group) throws Exception {
        if (group == null || group.isBlank()) {
            throw new Exception("The fields cannot be empty");
        }

        this.group = group;
    }

    public void setFaculty(String faculty) throws Exception {
        if (faculty == null || faculty.isBlank()) {
            throw new Exception("The fields cannot be empty");
        }

        this.faculty = faculty;
    }

    public void setAge(String age) throws Exception {
        this.age = age;
    }
    
}