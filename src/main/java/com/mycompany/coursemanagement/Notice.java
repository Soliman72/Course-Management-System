/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.coursemanagement;

import java.util.Date;

public class Notice {
    // Attributes
    private String title;
    private String content;
    private String courseName;
    private Date date;

    // Constructor
    public Notice(String title, String content, String courseName, Date date) {
        this.title = title;
        this.content = content;
        this.courseName = courseName;
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

    public Date getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}