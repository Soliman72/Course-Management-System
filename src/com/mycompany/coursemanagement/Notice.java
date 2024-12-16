/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.coursemanagement;

import java.time.LocalDate;

public class Notice {
    // Attributes
    private String courseName;
    private String title;
    private String content;
    private String date;

    // Parameterized Constructor
    public Notice(String courseName, String title, String content, String date) {
        this.courseName = courseName;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    // Setter for courseName
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
     
    // Getter for courseName
    public String getCourseName() {
        return courseName;
    }
     
     // Setter for title
    public void setTitle(String title) {
        this.title = title;
    }
    
    // Getter for title
    public String getTitle() {
        return title;
    }

    // Setter for content
    public void setContent(String content) {
        this.content = content;
    }
    
    // Getter for content
    public String getContent() {
        return content;
    }

    // Setter for date
    public void setDate(String date) {
        this.date = date;
    }
    
    // Getter for date
    public String getDate() {
        return date;
    }
   
    //Display the ad content
    public void displayDitals() {
        System.out.println("Notice{" + "title=" + title + ", content=" + content + ", courseName=" + courseName + ", date=" + date +" '}'");
    }
    
    // Convert object to string
    public String objectToString(){
        return this.courseName + "," + this.title + "," + this.content + "," + this.date;
    }
}