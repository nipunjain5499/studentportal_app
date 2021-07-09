package com.example.numberotpsignin;

import java.util.ArrayList;

public class facultyassign {

    String name,designation,department,contactno;
    ArrayList<String> facultyinterestedsub;
    boolean assignproctore;
    ArrayList<Subjects> assignsubjects;

    public facultyassign() {
    }

    public facultyassign(String name, String designation, String department, String contactno, boolean assignproctore, ArrayList<Subjects> assignsubjects,ArrayList<String> facultyinterestedsub) {
        this.name = name;
        this.designation = designation;
        this.department = department;
        this.contactno = contactno;
        this.assignproctore = assignproctore;
        this.assignsubjects=assignsubjects;
        this.facultyinterestedsub=facultyinterestedsub;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFacultyinterestedsub(ArrayList<String> facultyinterestedsub) {
        this.facultyinterestedsub = facultyinterestedsub;
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

    public void setAssignproctore(boolean assignproctore) {
        this.assignproctore = assignproctore;
    }

    public void setSub(ArrayList<Subjects> sub) {
        this.assignsubjects = assignsubjects;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getFacultyinterestedsub() {
        return facultyinterestedsub;
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

    public boolean isAssignproctore() {
        return assignproctore;
    }

    public ArrayList<Subjects> getSub() {
        return assignsubjects;
    }
}
