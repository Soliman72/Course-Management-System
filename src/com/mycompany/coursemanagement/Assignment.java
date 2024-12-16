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
    
    // Parameterized Constructor
    public Assignment(String courseName, String title, String description, int daysUntilDeadline) {
        this.ID = ++count;
        this.courseName = courseName;
        this.title = title;
        this.description = description;
        this.deadline = LocalDate.now().plusDays(daysUntilDeadline);
    }

    // Getter Assignment's ID
    public int getID() {
        return ID;
    }

    // Getter courseName of assignment
    public String getCourseName() {
        return courseName;
    }
    
    // Setter Assignment title
    public void setTitle(String title) {
        this.title = title;
    }
    
    // Getter Assignment title
    public String getTitle() {
        return title;
    }
    
    //Setter Assignment description
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter Assignment description
    public String getDescription() {
        return description;
    }

    // Setter Assignment deadline
    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    // Getter Assignment deadline
    public LocalDate getDeadline() {
        return deadline;
    }

    // Display assignment details
    public void displayAssignmentDetails() {
        System.out.println("Assignment ID: " + ID);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Deadline: " + deadline);
    }
    
    // Convert object to string
    public String objectToString(){
        return this.ID + "," + this.courseName + "," + this.title + "," + this.description + "," + this.deadline;
    }
}