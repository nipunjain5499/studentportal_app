package com.example.numberotpsignin;

public class Helperclass {

    String name,father_name,course,roll_number,email,contact_no,address,cno;
    public Helperclass(){

    }

    public Helperclass(String name, String father_name, String course, String roll_number, String email, String contact_no, String address,String cno) {
        this.name = name;
        this.father_name = father_name;
        this.course = course;
        this.roll_number = roll_number;
        this.email = email;
        this.contact_no = contact_no;
        this.address = address;
        this.cno = cno;

    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCno(String cno) {
        this.cno = cno;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setRoll_number(String roll_number) {
        this.roll_number = roll_number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getFather_name() {
        return father_name;
    }

    public String getCourse() {
        return course;
    }

    public String getRoll_number() {
        return roll_number;
    }

    public String getEmail() {
        return email;
    }

    public String getContact_no() {
        return contact_no;
    }

    public String getAddress() {
        return address;
    }
    public String getCno() {
        return cno;
    }

}
