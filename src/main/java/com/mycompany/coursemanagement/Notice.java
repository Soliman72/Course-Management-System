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
    private LocalDate date;

    // Constructor
    public Notice(String courseName, String title, String content, LocalDate date) {
        this.courseName = courseName;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getCourseName() {
        return courseName;
    }

    public LocalDate getDate() {
        return date;
    }
    
    //Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    //Display the ad content
    public void displayDitals() {
        System.out.println("Notice{" + "title=" + title + ", content=" + content + ", courseName=" + courseName + ", date=" + date +" '}'");
    }
    
    public String objectToString(){
        return this.courseName + "," + this.title + "," + this.content + "," + this.date;
    }
}