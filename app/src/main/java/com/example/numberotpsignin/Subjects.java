package com.example.numberotpsignin;

public class Subjects {

    String subjectname,programme,course,sem;

    public Subjects() {
    }

    public Subjects(String subjectname, String programme, String course, String sem) {
        this.subjectname = subjectname;
        this.programme = programme;
        this.course = course;
        this.sem = sem;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public String getProgramme() {
        return programme;
    }

    public String getCourse() {
        return course;
    }

    public String getSem() {
        return sem;
    }
}
