package com.example.numberotpsignin;

import java.util.ArrayList;

public class facultyassign {

    String Name,Designation,department,contactno;
    String facultyinterestedsub[];
    boolean assignproctore;
    ArrayList<Subjects> assignsubjects;

    public facultyassign() {
    }

    public facultyassign(String name, String designation, String department, String contactno, boolean assignproctore, ArrayList<Subjects> assignsubjects) {
        Name = name;
        Designation = designation;
        this.department = department;
        this.contactno = contactno;
        this.assignproctore = assignproctore;
        this.assignsubjects=assignsubjects;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setFacultyinterestedsub(String[] facultyinterestedsub) {
        this.facultyinterestedsub = facultyinterestedsub;
    }

    public void setDesignation(String designation) {
        Designation = designation;
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
        return Name;
    }

    public String[] getFacultyinterestedsub() {
        return facultyinterestedsub;
    }

    public String getDesignation() {
        return Designation;
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
