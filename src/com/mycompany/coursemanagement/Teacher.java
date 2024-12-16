/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.coursemanagement;

import java.util.Scanner;
import java.io.IOException;
import static java.lang.Math.random;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Teacher extends User {
    // Attributes
    private String specialty;
    private int ID;
    private static int count = 0;
    private ArrayList<Course> courses;

     // Empty Constructor
    public Teacher(){}
    
    // Parameterized Constructor that checks email uniqueness
    public Teacher(String name, String email ,  String password, String specialty) {
        super(name, email, password);
        FileManagement filemanager = new FileManagement();
        // To Check validat of email
        if(!filemanager.validEmail(email))
            throw new IllegalArgumentException( "this Email : " + email + "  => invalid ");
        // To confirm the oneness of the email
        if(filemanager.emailExists(email, "teachers.txt")){
            throw new IllegalArgumentException( "this Email : " + email + "  => already in use");
        }
        this.specialty = specialty;
        this.ID = ++count;  // Automatically increment the teacher ID
        this.courses = new ArrayList<>();
    }
    
    // Overloaded constructor for loading from file without checking email
    public Teacher(String name, String email ,  String password, String specialty , boolean isFromFile) {
        super(name, email, password);
        this.specialty = specialty;
        this.ID = ++count;  // Automatically increment the teacher ID
        this.courses = new ArrayList<>();
    }

    

    // Setter for specialty
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    
    // Getter for specialty 
    public String getSpecialty() {
        return specialty;
    }
    
    // Get the teacher's ID
    public int getID() {
        return ID;
    }
    
    // Get the list of courses taught by the teacher
    public ArrayList<Course> getCourses() {
        return courses;
    }

    // Set description of a course
    public void setDescriptionOfCourse(Course course, String description){
        course.setDescription(description);// Assuming Course class has a setDescription method
    }
    
    // Set description of an assignment
    public void setDescriptionOfAssignment(Assignment assignment, String description) {
        assignment.setDescription(description);// Assuming Assignment class has a setDescription method
    }

    // Set title of an assignment
    public void setTitleOfAssignment(Assignment assignment, String title) {
        assignment.setTitle(title);// Assuming Assignment class has a setTitle method
    }

    // Set the deadline of an assignment
    public void setDeadlineOfAssignment(Assignment assignment, LocalDate deadline) {
        assignment.setDeadline(deadline);// Assuming Assignment class has a setDeadline method
    }

    //Add a new course to a teacher
    public void addCourses(Course course) {
        this.courses.add(course);
    }
    
    //Delete a course to a teacher
    public void deleteCourses(Course course) {
        this.courses.remove(course);
    }
    
    // Create an assignment for a course
    public void createAssignment(Course course, Assignment assignment) {
        course.addAssignment(assignment);
    }

    // Assign a grade for a courses to a student
    public void assignGradeOfCourses(Student student){
        student.calculateCourseGrade();
    }
    
    //calculate Assignment Grade
    public static Grade calculateAssignmentGrade(){
        Grade grade = new Grade();
        grade.setGrade((int)(random()*100)+1);
        grade.setType("Assignment");
        if(grade.getGrade()>0&&grade.getGrade()<25)
            grade.setComment("fail");
        else if(grade.getGrade()>=25&&grade.getGrade()<40)
            grade.setComment("good");
        else if(grade.getGrade()>=40&&grade.getGrade()<=50)
            grade.setComment("Well done");
        return grade;        
    }
    
    // Set assignment grade for a student
    public void setAssignmentGradeOfStudent(Assignment assignment, Grade grade, Student student) {
        System.out.println("Setting grade " + grade.getGrade() + " for student " + student.getName() + " in assignment " + assignment.getTitle());
        student.addGrade(assignment, grade);
    }
    
    //Add Assignment to the course
    public void addAssignmentOfCourse(Assignment assignment, Course course ){
        course.addAssignment(assignment);
    }
    
    // Static method to get the number of teachers
    public static int numberOfTeacher() {
        return count;
    }
    
    // Method to get user input and create a Teacher object
    public static Teacher read(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter name of teacher : ");
        String name = in.nextLine();
        System.out.print("\nEnter email of teacher : ");
        String email = in.nextLine();
        System.out.print("\nEnter password of teacher : ");
        String password = in.nextLine();
        System.out.print("\nEnter specialty of teacher : ");
        String specialty = in.nextLine();
        return new Teacher(name, email, password, specialty);
    }
    
    // Convert object to string
    @Override
    public String objectToString() {
        return this.getName() + "," + this.getEmail() + "," + this.getPassword() + "," + this.getSpecialty();
    }

    // Teacher login
    @Override
    public boolean logIn(String email,String password){
        FileManagement fileManager = new FileManagement();
        try {
            ArrayList<Teacher> teachers = fileManager.readFromFile("teachers.txt", line -> {
                String[] parts = line.split(",");
                
                // Ensure the data has exactly 4 parts (name, email, password, specialty)
                if (parts.length >0) {
                    return new Teacher(parts[0], parts[1], parts[2], parts[3] , true);
                } else {
                    // Log error message for invalid data
                    //System.err.println("Invalid teacher data: " + Arrays.toString(parts));
                    return null;  // Handle invalid data (e.g., skip this entry)
                }
                
            }); 
            boolean found = false;
            for(Teacher teacher : teachers){
                if(( teacher!=null && email.equals(teacher.getEmail()))&&(password.equals(teacher.getPassword()))){
                    //System.out.println(teacher.getName()+" logged in successfully. ");   
                    found = true;
                    break;
                }
            }
            
            if(!found){
                //System.out.println("Incorrect Email or Password!");
            }
            return found;
        }catch (IOException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    // Teacher logout
    @Override
    public void logOut(){
        FileManagement fileManager = new FileManagement();
        try {
            ArrayList<Teacher> teachers = fileManager.readFromFile("teachers.txt", line -> {
                String[] parts = line.split(",");
                
                // Ensure the data has exactly 4 parts (name, email, password, specialty)
                if (parts.length >0) {
                    return new Teacher(parts[0], parts[1], parts[2], parts[3] , true);
                } else {
                    // Log error message for invalid data
                    System.err.println("Invalid admin data: " + Arrays.toString(parts));
                    return null;  // Handle invalid data (e.g., skip this entry)
                }
            }); 
            boolean found = false;
            for(int i=0 ; i<teachers.size() ; i++){
                if (this.getEmail().equals(teachers.get(i).getEmail())){
                    teachers.remove(i);
                    i--; // Decrement the index to adjust for the shift 
                    found=true;
                }
            }
            
            if(found){
                // Rewrite the updated list to the file
                fileManager.writeToFile(teachers, "teachers.txt", teacher -> teacher.objectToString());
                System.out.println("Logged out successfully.");
            }else {
                System.out.println("No matching student found for logout.");
            }
        }catch (IOException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
