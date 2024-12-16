/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.coursemanagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student extends User {
    // Attributes
    private int ID;
    private static int count=0;
    private ArrayList<Course> courses;
    private HashMap<Assignment,Grade> assignmentGrade;
    private HashMap<Course,Grade> courseGrade;
    
     // Empty Constructor
    public Student(){}
    
    // Parameterized Constructor
    public Student(String name ,String email , String password) {
        super(name,email ,password);
        FileManagement filemanager = new FileManagement();
        // To Check validat of email
        if(!filemanager.validEmail(email))
            throw new IllegalArgumentException( "this Email : " + email + "  => invalid ");
        // To confirm the oneness of the email
        if(filemanager.emailExists(email, "students.txt")){
            throw new IllegalArgumentException( "this Email : " + email + "  => already in use");
        }
        this.ID = ++count;  // Automatically increment the student ID
        this.courses=new ArrayList<>();
        this.assignmentGrade=new HashMap<>();
        this.courseGrade=new HashMap<>();
    }
    
    // Overloaded constructor for loading from file without checking email
    public Student(String name,String email  ,String password , boolean isFromFile) {
        super(name,email ,password);
        this.ID = ++count;  // Automatically increment the student ID
        this.courses=new ArrayList<>();
        this.assignmentGrade=new HashMap<>();
        this.courseGrade=new HashMap<>();
    }
    
    // Getter student's ID
    public int getID() {
        return ID;
    }
    
    // Getter all courses in which the student is registered
    public ArrayList<Course> getCourses() {
        return courses;
    }

    // Getter All assignments received with grades
    public HashMap<Assignment, Grade> getAssignmentGrade() {
        return assignmentGrade;
    }

    // Getter All courses registered with their grades
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
            if(!this.assignmentGrade.isEmpty())
                for (Assignment assignment : this.assignmentGrade.keySet()) {
                    if(assignment.getCourseName() == null ? course.getCourseName() == null : assignment.getCourseName().equals(course.getCourseName()))
                        g+=this.assignmentGrade.get(assignment).getGrade();
            }
            else {
                System.out.println("No assignment Was submitted in this course" + course.getCourseName());
                return;
            }
            if(g>=0&&g<50){
                grade.setGrade(g);
                grade.setComment("F");
                grade.setType("course");
            }     
            else if(g>=50&&g<60){
                grade.setGrade(g);
                grade.setComment("D");
                grade.setType("course");
            }
            else if(g>=60&&g<80){
                grade.setGrade(g);
                grade.setComment("C");
                grade.setType("course");
            }
            else if(g>=80&&g<90){
                grade.setGrade(g);
                grade.setComment("B");
                grade.setType("course");
            }
            else if(g>=90){
                grade.setGrade(g);
                grade.setComment("A");
                grade.setType("course");
            }
            
            this.courseGrade.put(course, grade);
        }
    }
    
    // View all assignment grades
    public void viewAssignmentGrades() {
        System.out.println();
        System.out.println("Assignment Grades for " + this.getName() + ":" );
        for (HashMap.Entry<Assignment, Grade> entry : assignmentGrade.entrySet()) {
            System.out.println("Assignment: " + entry.getKey().getTitle() + ", Grade: " + entry.getValue().getGrade());
        }
    }

    // View all course grades
    public void viewCourseGrades() {
        System.out.println();
        System.out.println("Course Grades for " + this.getName() + ":" );
        for (HashMap.Entry<Course, Grade> entry : courseGrade.entrySet()) {
            System.out.println("Course: " + entry.getKey().getCourseName() + ",");
            entry.getValue().displayGradeDetails();
        }
    }

    // View grade for a specific course
    public void viewCourseGrade(Course course) {
        System.out.println();
        System.out.println("Course Grades" + course.getCourseName() + " for " + this.getName() + ":" );
        if (courseGrade.containsKey(course)) {
            System.out.println("Course: " + course.getCourseName() + ",");
            courseGrade.get(course).displayGradeDetails();
        } else {
            System.out.println("No grade available for this course.");
        }
    }

    // View Notice of Course
    public ArrayList<Notice> viewCoursesNotice(){
        return Admin.getNotices();
    }

    // Enroll the student in a new course
    public void enrollCourse(Course course) {
        this.courses.add(course);
    }

    // Submit an assignment and add the grade
    public void submitAssignment(Assignment assignment, Course course,Teacher teacher) {
        Grade grade=teacher.calculateAssignmentGrade();
        System.out.println("Assigning grade " + grade.getGrade() + " to student " + this.getName() + " for assignment " + assignment.getTitle());
        this.assignmentGrade.put(assignment, grade);
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
    
    // Method to get user input and create a Student object
    public static Student read(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter name of student : ");
        String name = in.nextLine();
        System.out.print("\nEnter email of student : ");
        String email = in.nextLine();
        System.out.print("\nEnter password of student : ");
        String password = in.nextLine();
        return new Student(name, email, password);
    }
    
    // Student login
    @Override
    public boolean logIn(String email,String password){
        FileManagement fileManager = new FileManagement();
        try {
            ArrayList<Student> students = fileManager.readFromFile("students.txt", line -> {
                String[] parts = line.split(",");
                
                // Ensure the data has exactly 3 parts (name, email, password)
                if (parts.length >0) {
                    return new Student(parts[0], parts[1], parts[2] , true);
                } else {
                    // Log error message for invalid data
                    //System.err.println("Invalid student data: " + Arrays.toString(parts));
                    return null;  // Handle invalid data (e.g., skip this entry)
                }
                
            }); 
            boolean found = false;
            for(Student student : students){
                if( student!=null&& (email.equals(student.getEmail()))&&(password.equals(student.getPassword()))){
                    //System.out.println(student.getName()+" logged in successfully. ");
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
    
    // Student logout
    @Override
    public void logOut(){
        FileManagement fileManager = new FileManagement();
        try {
            ArrayList<Student> students = fileManager.readFromFile("students.txt", line -> {
                String[] parts = line.split(",");
                
                // Ensure the data has exactly 3 parts (name, email, password)
                if (parts.length >0) {
                    return new Student(parts[0], parts[1], parts[2] , true);
                } else {
                    // Log error message for invalid data
                    System.err.println("Invalid admin data: " + Arrays.toString(parts));
                    return null;  // Handle invalid data (e.g., skip this entry)
                }
            }); 
            
            boolean found = false;
            for(int i=0 ; i<students.size() ; i++){
                if (this.getEmail().equals(students.get(i).getEmail())){
                    students.remove(i);
                    i--; // Decrement the index to adjust for the shift 
                    found=true;
                }
            }
            
            if(found){
                // Rewrite the updated list to the file
                FileManagement.writeToFile(students, "students.txt", student -> student.objectToString());
                System.out.println("Logged out successfully.");
            }else {
                System.out.println("No matching student found for logout.");
            }
            
            
        }catch (IOException ex) {
            System.err.println("Failed to log out: " + ex.getMessage());
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Student readFromfile(String email, String filename){
        File file = new File(filename);

        // Check if the file exists before trying to read it
        if (!file.exists()) {
            return null; // Return null if the file doesn't exist
        }

        try {
            // Read the file line by line
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                // Email is the second part of the line (adjust index if email position changes)
                if (parts.length > 1 && parts[1].trim().equals(email)) {
                    reader.close(); // Close the file after finding the match
                    return new Student(parts[0], parts[1], parts[2] , true);  // Return the matched object immediately
                }
            }

            reader.close(); // Close the file if no match is found
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, "Failed to read from " + filename, ex);
        }

        return null; // Return null if no match is found

    }

}
