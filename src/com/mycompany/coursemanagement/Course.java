/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.coursemanagement;


import java.util.*;

public class Course {
    // Attributes
    private String name;
    private Teacher teacher;
    private String description;
    private double price;
    private String timePeriod;
    private ArrayList<Student> students;
    private ArrayList<Assignment> assignments;
    private ArrayList<Notice> notices;

    // Parameterized Constructor
    public Course(String name, Teacher teacher, String description, double price, String timePeriod) {
        this.name = name;
        this.teacher = teacher;
        this.description = description;
        this.price = price;
        this.timePeriod = timePeriod;
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
        this.notices = new ArrayList<>();
    }

    // Setter for name of course
    public void setCourseName(String name) {
        this.name = name;
    }

    // Getter for name of course
    public String getCourseName() {
        return name;
    }

    // Setter for teacher of course
    public void setTeacher( Teacher teacher) {
        this.teacher = teacher;
    }
    
    // Getter for teacher of course
    public Teacher getTeacher() {
        return teacher;
    }
    
    // Setter for description of course
    public void setDescription(String description){
        this.description = description;
    }
 
    // Getter for description of course
    public String getDescription() {
        return description;
    }
    
    // Setter for price of course
    public void setPrice(double price) {
        this.price = price;
    }

    // Getter for price of course
    public double getPrice() {
        return price;
    }
    
    // Setter for timePeriod of course
    public void setTimePeriod(String timePeriod) {
        this.timePeriod =  timePeriod;
    }
    
    // Getter for timePeriod of course
    public String getTimePeriod() {
        return timePeriod;
    }
    
    // Getter All students in the same course
    public ArrayList<Student> getStudents() {
        return students;
    }

    // Getter All assignments in the same course
    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    // Getter All notises in the same course
    public ArrayList<Notice> getNotices() {
        return notices;
    }

    // Method to add an assignment to the course
    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    // Method to enroll a student in the course
    public void enrollStudent(Student student) {
        students.add(student);
    }

    // Method to add a notice to the course
    public void addNotice(Notice notice) {
        notices.add(notice);
    }

    // Method to view all students enrolled in the course
    public void viewStudents() {
        System.out.println("Students enrolled in course: " + name);
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }

    // Method to view all assignments in the course
    public void viewAssignments() {
        System.out.println("Assignments for course: " + name);
        for (Assignment assignment : assignments) {
            System.out.println(assignment.getTitle());
        }
    }

    // Method to view all notices for the course
    public void viewNotices() {
        System.out.println("Notices for course: " + name);
        for (Notice notice : notices) {
            System.out.println(notice.getTitle());
        }
    }
    
    // View Course Information
    public void viewCourseDetails() {
        System.out.println("Course Name: " + getCourseName());
        System.out.println("Teacher: " + (teacher != null ? teacher.getName() : "No Teacher Assigned"));
        System.out.println("Description: " + getDescription());
        System.out.println("Price: $" + getPrice());
        System.out.println("Time: " + getTimePeriod());

        // View students enrolled in the course
        System.out.println("Students enrolled in course: " + getCourseName());
        for (Student student : students) {
            System.out.println(student.getName());
        }

        // View assignments in the course
        System.out.println("Assignments for course: " + getCourseName());
        for (Assignment assignment : assignments) {
            System.out.println(assignment.getTitle());
        }

        // View notices in the course
        System.out.println("Notices for course: " + getCourseName());
        for (Notice notice : notices) {
            System.out.println(notice.getTitle());
        }
    }

    // Remove a student from the course
    public void removeStudent(Student student) {
        if (students.contains(student)) {
            students.remove(student);
            System.out.println(student.getName() + " has been removed from the course: " + name);
        } else {
            System.out.println(student.getName() + " is not enrolled in this course.");
        }
    }

    // Remove an assignment from the course
    public void removeAssignment(Assignment assignment) {
        if (assignments.contains(assignment)) {
            assignments.remove(assignment);
            System.out.println("Assignment: " + assignment.getTitle() + " has been removed from the course: " + name);
        } else {
            System.out.println("Assignment: " + assignment.getTitle() + " is not part of this course.");
        }
    }

    // Remove a notice from the course
    public void removeNotice(Notice notice) {
        if (notices.contains(notice)) {
            notices.remove(notice);
            System.out.println("Notice: " + notice.getTitle() + " has been removed from the course: " + name);
        } else {
            System.out.println("Notice: " + notice.getTitle() + " is not part of this course.");
        }
    }
    
    // Convert object to string
    public String objectToString() {
        return this.name + "," + this.teacher.getName() + "," + this.teacher.getEmail() + "," + this.teacher.getPassword() + "," + this.teacher.getSpecialty() + "," + this.description + "," + this.price + "," + this.timePeriod;
    }
}

