/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.coursemanagement;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Admin extends User {
    // Static lists to hold all instLocalTimeances of teachers, students, courses, and notices
    public static ArrayList<Teacher> teachers = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Course> courses = new ArrayList<>();
    private static ArrayList<Notice> notices = new ArrayList<>();

    // Constructor
    public Admin(String name, String email, String password) {
        super(name, email, password);
        FileManagement filemanager = new FileManagement();
        if(filemanager.emailExists(email, "admins.txt")){
            throw new IllegalArgumentException( "this Email : " + email + "  => already in use");
        }
    }
    
    public Admin(String name, String email, String password , boolean isFromFile) {
        super(name, email, password);
    }
    
    // Getter All students registered in the Course-Management-System
    public static ArrayList<Student> getStudents() {
        return students;
    }
    
    // Getter All teachers registered in the course-management-system
    public static ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    // Getter all the courses in the course-management-system
    public static ArrayList<Course> getCourses() {
        return courses;
    }

    // Getter All notices in the course-management-system
    public static ArrayList<Notice> getNotices() {
        return notices;
    }
   
   // Add a new student
    public void addStudent(Student student) {
        students.add(student);
    }

    // Add a new course
    public void addCourse(Course course) {
        courses.add(course);
    }

    // Add a new teacher
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    // Delete a course
    public void deleteCourse(Course course) {
        courses.remove(course);
    }

    // Set the teacher of a course
    public void setTeacherOfCourse(Course course, Teacher teacher) {
        course.setTeacher(teacher); // Assuming Course class has a setTeacher method
        teacher.getCourses().add(course); // Add course to teacher's list
    }

    // Set the courses of a teacher
    public void setCoursesOfTeacher(Teacher teacher, Course course) {
        teacher.getCourses().add(course);
    }

    // Set the courses of a student
    public void setCoursesOfStudent(Student student, Course course) {
        student.enrollCourse(course);
    }

    // Set the name of a course
    public void setNameOfCourse(Course course, String name) {
        course.setCourseName(name);
    }

    // Set students for a course
    public void setStudentsOfCourse(Course course, Student student) {
        course.enrollStudent(student); // Assuming Course class has an enrollStudent method
        student.enrollCourse(course);
    }

    // Set the price of a course
    public void setPriceOfCourse(Course course, double price) {
        course.setPrice(price); // Assuming Course class has a setPrice method
    }

    // Set the time period of a course
    public void setTimePeriod(Course course, String timePeriod) {
        course.setTimePeriod(timePeriod); // Assuming Course class has a setTimePeriod method
    }

    // Add a new notice
    public void addNotice(Notice notice, Course course) {
        notices.add(notice);// Assuming Course class has an addNotice method
        course.addNotice(notice);
    }

    // Set the title of a notice
    public void setTitleOfNotice(Notice notice, String title) {
        notice.setTitle(title); // Assuming Notice class has a setTitle method
    }

    // Set the content of a notice
    public void setContentOfNotice(Notice notice, String content) {
        notice.setContent(content); // Assuming Notice class has a setContent method
    }

    // Set the course name of a notice
    public void setCourseNameOfNotice(Notice notice, String courseName) {
        notice.setCourseName(courseName); // Assuming Notice class has a setCourseName method
    }

    // Set the date of a notice
    public void setDateOfNotice(Notice notice, LocalDate date) {
        notice.setDate(date); // Assuming Notice class has a setDate method
    }

    // View all teachers
    public static void viewAllTeachers() {
        System.out.println("List of Teachers:");
        for (Teacher teacher : teachers) {
            System.out.println(teacher.getName());
        }
    }

    // View all students
    public static void viewAllStudents() {
        System.out.println("List of Students:");
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }

    // View all courses
    public static void viewAllCourses() {
        System.out.println("List of Courses:");
        for (Course course : courses) {
            System.out.println(course.getCourseName());
        }
    }

    // View all notices
    public static void viewAllNotices() {
        System.out.println("List of Notices:");
        for (Notice notice : notices) {
            System.out.println(notice.getTitle());
        }
    }
    
    @Override
    public void logIn(String email,String password){
        FileManagement fileManager = new FileManagement();
        try {
            ArrayList<Admin> admins = fileManager.readFromFile("admins.txt", line -> {
                String[] parts = line.split(",");
                
                // Ensure the data has exactly 3 parts (name, email, password)
                if (parts.length >0) {
                    return new Admin(parts[0], parts[1], parts[2] , true);
                } else {
                    // Log error message for invalid data
                    System.err.println("Invalid admin data: " + Arrays.toString(parts));
                    return null;  // Handle invalid data (e.g., skip this entry)
                }
                
            }); 
            boolean found = false;
            for(Admin admin : admins){
                if( admin!=null && (email.equals(admin.getEmail()))&&(password.equals(admin.getPassword()))){
                    System.out.println(admin.getName()+"Logged in");
                    found=true;
                    break;
                }
            }
            
            if(!found){
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
            ArrayList<Admin> admins = fileManager.readFromFile("admins.txt", line -> {
                String[] parts = line.split(",");
                
                // Ensure the data has exactly 3 parts (name, email, password)
                if (parts.length >0) {
                    return new Admin(parts[0], parts[1], parts[2] , true);
                } else {
                    // Log error message for invalid data
                    System.err.println("Invalid admin data: " + Arrays.toString(parts));
                    return null;  // Handle invalid data (e.g., skip this entry)
                }
            }); 
            boolean found = false;
            for(int i=0 ; i<admins.size() ; i++){
                if (this.getEmail().equals(admins.get(i).getEmail())){
                    admins.remove(i);
                    i--; // Decrement the index to adjust for the shift 
                    found=true;
                }
            }
            
            if(found){
                // Rewrite the updated list to the file
                fileManager.writeToFile(admins, "admins.txt", admin -> admin.objectToString());
                System.out.println("Logged out successfully.");
            }else {
                System.out.println("No matching student found for logout.");
            }
        }catch (IOException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}