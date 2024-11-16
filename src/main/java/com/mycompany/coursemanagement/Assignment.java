/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.coursemanagement;

import java.time.LocalDate;

public class Assignment {
    // Attributes
    private final int ID;
    private static int count = 0;
    private String courseName;
    private String title;
    private String description;
    private LocalDate deadline;
    
    // Constructor
    public Assignment(String courseName, String title, String description, int daysUntilDeadline) {
        this.ID = ++count;
        this.courseName = courseName;
        this.title = title;
        this.description = description;
        this.deadline = LocalDate.now().plusDays(daysUntilDeadline);
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

    public LocalDate getDeadline() {
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

    //Setters
    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }
    public String objectToString(){
        return this.ID + "," + this.description + "," + this.title + "," + this.deadline + "," + this.courseName;
    }
}