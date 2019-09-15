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
public class Course {
    private int id;
    private String title;
    private String duration;
    private int fee;

    public Course() {
    }

    public Course(String title, String duration, int fee) {
        this.title = title;
        this.duration = duration;
        this.fee = fee;
    }

    public Course(int id, String title, String duration, int fee) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.fee = fee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", title=" + title + ", duration=" + duration + ", fee=" + fee + '}';
    }
    
    
}
