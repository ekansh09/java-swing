/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author user
 */
public class Student {
   private int id;
   private String name, course, contact_no, email, address; 

    public Student() {
    }

    public Student(String name, String course, String contact_no, String email, String address) {
        this.name = name;
        this.course = course;
        this.contact_no = contact_no;
        this.email = email;
        this.address = address;
    }

    public Student(int id, String name, String course, String contact_no, String email, String address) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.contact_no = contact_no;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", course=" + course + ", contact_no=" + contact_no + ", email=" + email + ", address=" + address + '}';
    }
    
    
    
   
    
}
