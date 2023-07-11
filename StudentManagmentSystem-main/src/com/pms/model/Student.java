package com.pms.model;

public class Student {
     private int sno;
    private String sname;
    private String saddress;
    public Student() {
    }
    //Using retrieving Data from DB
    public Student(int sno, String sname, String saddress) {
        this.sno = sno;
        this.sname = sname;
        this.saddress = saddress;
    }
    //Getter and Setter method for set and get Value for Instance Variable
    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }
    //using for Adding Student
    public Student(String sname, String saddress) {
        this.sname = sname;
        this.saddress = saddress;
    }
}
