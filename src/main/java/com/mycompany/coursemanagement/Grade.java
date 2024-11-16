/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.coursemanagement;


public class Grade {
    // Attributes
    private int grade;
    private String comment;
    private String type;

    // Constructor
    public Grade(){}
    public Grade(int grade, String comment, String type) {
        this.grade = grade;
        this.comment = comment;
        this.type = type;
    }

    // Setter for grade
    public void setGrade(int grade) {
        this.grade = grade;
    }
    
    // Getter for grade
    public int getGrade() {
        return grade;
    }

    // Setter for comment
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    // Getter for comment
    public String getComment() {
        return comment;
    }

    // Setter for type
    public void setType(String type) {
        this.type = type;
    }
    
    // Getter for type
    public String getType() {
        return type;
    }

    // Display grade details
    public void displayGradeDetails() {
        System.out.println("Grade: " + grade + " - Comment: " + comment + " - Type: " + type);
    }
}
