/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.coursemanagement;

import java.util.Date;

public class Assignment {
    // Attributes
    private final int ID;
    private String description;
    private String title;
    private Date deadline;
    private String courseName;

    // Constructor
    public Assignment(int ID, String description, String title, Date deadline) {
        this.ID = ID;
        this.description = description;
        this.title = title;
        this.deadline = deadline;
    }

    // Getters
    public int getID() {
        return ID;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public Date getDeadline() {
        return deadline;
    }

    public String getCourseName() {
        return courseName;
    }
    
    // Display assignment details
    public void displayAssignmentDetails() {
        System.out.println("Assignment ID: " + ID);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Deadline: " + deadline);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
    
}