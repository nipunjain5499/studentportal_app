package com.example.numberotpsignin;

public class ProctorClass {
    String branch;
    Boolean isProctore;
    String semester;
    String department;
    public  ProctorClass(){

    }

    public ProctorClass(String branch, Boolean isProctore, String semester, String department) {
        this.branch = branch;
        this.isProctore = isProctore;
        this.semester = semester;
        this.department = department;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setProctore(Boolean proctore) {
        isProctore = proctore;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBranch() {
        return branch;
    }

    public Boolean getProctore() {
        return isProctore;
    }

    public String getSemester() {
        return semester;
    }

    public String getDepartment() {
        return department;
    }
}
