package com.example.numberotpsignin;

import java.util.ArrayList;

public class facultyassign {

    private String name,designation,department,contactno,email;
    private ArrayList<String> facultyinterestedsub;
    private ProctorClass assignproctore;
    private ArrayList<Subjects> assignsubjects;

    public facultyassign() {
    }

    public facultyassign(String name,
                         String designation,
                         String department,
                         String contactno,
                         boolean assignproctore,
                         ArrayList<Subjects> assignsubjects,
                         ArrayList<String> facultyinterestedsub,String email)
    {
        this.name = name;
        this.designation = designation;
        this.department = department;
        this.contactno = contactno;
        ProctorClass m=new ProctorClass(" ",assignproctore," "," ");
        this.assignproctore = m;
        this.assignsubjects=assignsubjects;
        this.facultyinterestedsub=facultyinterestedsub;
        this.email=email;
        this.assignsubjects=assignsubjects;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFacultyinterestedsub(ArrayList<String> facultyinterestedsub) {
        this.facultyinterestedsub = facultyinterestedsub;
    }

    public void setAssignproctore(ProctorClass assignproctore) {
        this.assignproctore = assignproctore;
    }

    public void setAssignsubjects(ArrayList<Subjects> assignsubjects) {
        this.assignsubjects = assignsubjects;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public String getDepartment() {
        return department;
    }

    public String getContactno() {
        return contactno;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<String> getFacultyinterestedsub() {
        return facultyinterestedsub;
    }

    public ProctorClass getAssignproctore() {
        return assignproctore;
    }

    public ArrayList<Subjects> getAssignsubjects() {
        return assignsubjects;
    }

}
