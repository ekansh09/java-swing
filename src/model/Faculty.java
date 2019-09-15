/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author cm
 */
public class Faculty {
    private int id;
    private String name;
    String dept;
    String contNo;

    public Faculty() {
    }

    public Faculty(String name, String dept, String contNo) {
        this.name = name;
        this.dept = dept;
        this.contNo = contNo;
    }

    public Faculty(int id, String name, String dept, String contNo) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.contNo = contNo;
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

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getContNo() {
        return contNo;
    }

    public void setContNo(String contNo) {
        this.contNo = contNo;
    }

    @Override
    public String toString() {
        return "Faculty{" + "id=" + id + ", name=" + name + ", dept=" + dept + ", contNo=" + contNo + '}';
    }
    
    
}
