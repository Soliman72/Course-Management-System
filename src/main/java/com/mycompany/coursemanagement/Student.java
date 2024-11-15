/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.coursemanagement;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student extends User {
    // Attributes
    private final int ID;
    private static int count=0;
    private ArrayList<Course> courses;
    private HashMap<Assignment,Grade> assignmentGrade;
    private HashMap<Course,Grade> courseGrade;
    
    //constructor
    public Student(String name,String password ,String email) {
        super(name,password,email);
        this.ID = ++count;  // Automatically increment the student ID
        this.courses=new ArrayList<>();
        this.assignmentGrade=new HashMap<>();
        this.courseGrade=new HashMap<>();
    }
 // Getters
    public int getID() {
        return ID;
    }
    public ArrayList<Course> getCourses() {
        return courses;
    }

    public HashMap<Assignment, Grade> getAssignmentGrade() {
        return assignmentGrade;
    }

    public HashMap<Course, Grade> getCourseGrade() {
        return courseGrade;
    }

    // View details of the student
    public void viewDetails() {
        System.out.println("Student ID: " + ID);
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
    }

    // View enrolled courses
    public void viewCourses() {
        System.out.println("Enrolled Courses:");
        for (Course course : courses) {
            System.out.println(course.getCourseName());
        }
    }

    // Calculate and display course grades
    public void calculateCourseGrade() {
        int g;
        Grade grade = new Grade();
        for (Course course : courses) {
            g=0;
            if(!assignmentGrade.isEmpty())
                for (Assignment assignment : assignmentGrade.keySet()) {
                    if(assignmentGrade.containsKey(assignment.getCourseName()))
                        g+=assignmentGrade.get(assignment.getCourseName()).getGrade();
            }
            if(g>0&&g<50)
                grade=new Grade(g,"F","course");
            else if(g>=50&&g<60)
                grade=new Grade(g,"D","course");
            else if(g>=60&&g<80)
                grade=new Grade(g,"C","course");
            else if(g>=80&&g<90)
                grade=new Grade(g,"B","course");
            else if(g>=90)
                grade=new Grade(g,"A","course");
            else 
                System.out.println("No assignment Was submitted in this course");
            this.courseGrade.put(course, grade);
        }
    }
    // View all assignment grades
    public void viewAssignmentGrades() {
        System.out.println("Assignment Grades:");
        for (HashMap.Entry<Assignment, Grade> entry : assignmentGrade.entrySet()) {
            System.out.println("Assignment: " + entry.getKey().getTitle() + ", Grade: " + entry.getValue().getGrade());
        }
    }

    // View all course grades
    public void viewCourseGrades() {
        System.out.println("Course Grades:");
        for (HashMap.Entry<Course, Grade> entry : courseGrade.entrySet()) {
            System.out.println("Course: " + entry.getKey().getCourseName() + ", Grade: " + entry.getValue().getGrade());
        }
    }

    // View grade for a specific course
    public void viewCourseGrade(Course course) {
        if (courseGrade.containsKey(course)) {
            System.out.println("Course: " + course.getCourseName() + ", Grade: " + courseGrade.get(course).getGrade());
        } else {
            System.out.println("No grade available for this course.");
        }
    }

//        // Add grade for a course
//    public void addCourseGrade(Course course, Grade grade) {
//        courseGrade.put(course, grade);
//    }
    
    // Enroll the student in a new course
    public void enrollCourse(Course course) {
        courses.add(course);
    }

    // Submit an assignment and add the grade
    public void submitAssignment(Assignment assignment, Course course,Teacher teacher) {
        teacher.assignGradeOfAssignment(assignment, this);
    }

    // Calculate total price of courses (if there's a price attribute in Course)
    public double totalPriceOfCourses() {
        double totalPrice = 0;
        for (Course course : courses) {
            totalPrice += course.getPrice(); // Assuming Course class has a getPrice() method
        }
        return totalPrice;
    }

    // Static method to get the number of students
    public static int numberOfStudent() {
        return count;
    }

    // Add grade for a specific assignment
    public void addGrade(Assignment assignment, Grade grade) {
        if(assignmentGrade.containsKey(assignment)){
            assignmentGrade.put(assignment, grade);
            System.out.println("Submitted assignment: " + assignment.getTitle() + " for course: " + assignment.getCourseName());
        }
        else System.out.println("This student did not submitted assignment");
    }
    
    
    @Override
    public void logIn(String email,String password){
        FileManagement fileManager = new FileManagement();
        try {
            ArrayList<Student> students = fileManager.readFromFile("students.txt", line -> {
                String[] parts = line.split(",");
                
                // Ensure the data has exactly 3 parts (name, email, password)
                if (parts.length >0) {
                    return new Student(parts[0], parts[1], parts[2]);
                } else {
                    // Log error message for invalid data
                    System.err.println("Invalid student data: " + Arrays.toString(parts));
                    return null;  // Handle invalid data (e.g., skip this entry)
                }
                
            }); 
            for(Student student : students){
                if((email == null ? student.getEmail() == null : email.equals(student.getEmail()))&&(password == null ? student.getPassword() == null : password.equals(student.getPassword())))
                    System.out.println(student.getName()+"Logged in");
                else
                    System.out.println("Incorrect Email or Password");
            }
        }catch (IOException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void logOut(){
        FileManagement fileManager = new FileManagement();
        try {
            ArrayList<Student> students = fileManager.readFromFile("students.txt", line -> {
                String[] parts = line.split(",");
                
                // Ensure the data has exactly 3 parts (name, email, password)
                if (parts.length >0) {
                    return new Student(parts[0], parts[1], parts[2]);
                } else {
                    // Log error message for invalid data
                    System.err.println("Invalid admin data: " + Arrays.toString(parts));
                    return null;  // Handle invalid data (e.g., skip this entry)
                }
            }); 
            for(Student student : students){
                if(this.equals(student))
                    students.remove(this);
            }
            File file = new File("students.txt");
            if (file.exists())
                file.delete();
            fileManager.writeToFile(students, "students.txt", student -> student.objectToString());
        }catch (IOException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
