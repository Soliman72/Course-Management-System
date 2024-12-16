package com.mycompany.coursemanagement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Coursemanagement {

    public static void main(String[] args) throws IOException {
        // test the methods 
        {         
        // ===> Before runing for the second time, the file must be deleted.
         
        FileManagement fileManager = new FileManagement();

        // Step 1: Create Admin
        Admin admin1 = new Admin("Admin User", "admin@example.com", "admin123", true);
        //Store admin information
        //FileManagement.writeSingleObjectToFile(admin1, "admins.txt", admin -> admin.objectToString());
        
        // Step 2: Create Teachers
        Teacher teacher1 = new Teacher("Mr. Smith", "smith@example.com", "teacher123", "Mathematics", true);
        Teacher teacher2 = new Teacher("Ms. Johnson", "johnson@example.com",  "teacher456", "Physics", true);
        
        // Add teachers using Admin
        admin1.addTeacher(teacher1);
        admin1.addTeacher(teacher2);
        //Storing teachers' information
        //FileManagement.writeToFile(Admin.getTeachers(), "teachers.txt", teacher -> teacher.objectToString());
        
        // Step 3: Create Students
        Student student1 = new Student("John Doe", "john@example.com", "johndoe123", true);
        Student student2 = new Student("Jane Roe", "jane@example.com", "janeroe456", true);
        Student student3 = new Student("Michael Blue", "michael@example.com", "michaelblue789", true);
        Student student4 = new Student("Sarah White", "sarah@example.com", "sarahwhite101", true);
        Student student5 = new Student("shahd saed", "shahd@example.com", "shahdsaed263", true);
        
        // test to add student with the same email ( should be got an error )
//        Student student6 = new Student("test", "test@example.com", "123123123");
        

        // Add students using Admin
        admin1.addStudent(student1);
        admin1.addStudent(student2);
        admin1.addStudent(student3);
        admin1.addStudent(student4);
        admin1.addStudent(student5);
        //Storing students' information
        //FileManagement.writeToFile(Admin.getStudents(), "students.txt", student -> student.objectToString());

        // Step 4: Create Courses
        Course mathCourse = new Course("Mathematics", teacher1, "Algebra and Calculus", 200.0, "three months");
        Course physicsCourse = new Course("Physics", teacher2, "Mechanics and Thermodynamics", 250.0, "three months");
        //Defining the course to the teacher
        teacher1.addCourses(mathCourse);
        teacher2.addCourses(physicsCourse);
        // Add courses using Admin
        admin1.addCourse(mathCourse);
        admin1.addCourse(physicsCourse);
        //store information for courses
        //FileManagement.writeToFile(Admin.getCourses(), "courses.txt", course -> course.objectToString());
        
        // Step 5: Enroll students in courses
        student1.enrollCourse(mathCourse);
        admin1.setStudentsOfCourse(mathCourse, student1);// John enrolls in Math
        admin1.setStudentsOfCourse(mathCourse, student2);// Jane enrolls in Math
        admin1.setStudentsOfCourse(mathCourse, student4); // Sarah enrolls in Math
        admin1.setStudentsOfCourse(physicsCourse, student2);// Jane enrolls in Physics
        admin1.setStudentsOfCourse(physicsCourse, student3); // Michael enrolls in Physics
        admin1.setStudentsOfCourse(physicsCourse, student4); // Sarah enrolls in Physics
        
        // Step 6: Create Assignments
        Assignment mathAssignment1 = new Assignment(
                "Mathematics", // Course Name
                "Algebra Assignment", // Title
                "Solve Algebra Problems", // Description
                15 // Deadline after 2 weaks
        );
        Assignment physicsAssignment1 = new Assignment(
                "Physics", // Course Name
                "Physics Assignment", // Title
                "Mechanics Problems", // Description
                30 // Deadline after month
        );
        // Add assignments to courses
        teacher1.addAssignmentOfCourse(mathAssignment1, mathCourse);
        teacher2.addAssignmentOfCourse(physicsAssignment1, physicsCourse);
        //store assignment information
        //FileManagement.writeSingleObjectToFile(mathAssignment1, "assignments.txt", assignment -> assignment.objectToString());
        //FileManagement.writeSingleObjectToFile(physicsAssignment1, "assignments.txt", assignment -> assignment.objectToString());
        // login to the website to submit assignments
        student1.logIn(student1.getEmail(), student1.getPassword());
        student2.logIn(student2.getEmail(), student2.getPassword());
        student3.logIn(student3.getEmail(), student3.getPassword());
        student4.logIn(student4.getEmail(), student4.getPassword());
        student5.logIn(student5.getEmail(), student5.getPassword());
        
        student5.logOut();
        // Step 7: Submitting assignment and giving grades by teachers if the student is registered for the course
        student1.submitAssignment(mathAssignment1, mathCourse, teacher1);
        student2.submitAssignment(mathAssignment1, mathCourse, teacher1);
        student4.submitAssignment(mathAssignment1, mathCourse, teacher1);
        student2.submitAssignment(physicsAssignment1, physicsCourse, teacher2);
        student3.submitAssignment(physicsAssignment1, physicsCourse, teacher2);
        student4.submitAssignment(physicsAssignment1, physicsCourse, teacher2);
        //student1.getAssignmentGrade().forEach((key, value) -> System.out.println(key.getCourseName() + value.getGrade()));
        
        // Optional: Set course grade for students (based on performance)
        teacher1.assignGradeOfCourses(student1);
        teacher1.assignGradeOfCourses(student2);
        teacher2.assignGradeOfCourses(student3);
        teacher2.assignGradeOfCourses(student4);
        //student1.getCourseGrade().forEach((key, value) -> System.out.println(key.getCourseName() + value.getGrade()));
        
        // step 8: Create Notices
        Notice mathNotice = new Notice(
                "Mathematics",
                "Math Course Enrollment Announcement",
                "We are pleased to announce the launch of an advanced Math course for all levels. " +
                "The course will begin on Sunday; November 20; 2024; and will cover topics such as Calculus; Algebra; and Geometry. " +
                "The course will be conducted online; and study materials will be provided via our online learning platform.",
                "2024-12-10"
        );
        Notice physicsNotice = new Notice(
                "Physics",
                "Physics Course Enrollment Announcement",
                "We are excited to announce the start of an Advanced Physics course for students at all levels. " +
                "The course will begin on Saturday; November 22; 2024; and will cover topics including Mechanics; Thermodynamics; " +
                "and Electromagnetism. The course will be held online and all course materials will be available on our e-learning platform.",
                "2024-12-12"
        );
        //Adding notices to the course and admin information
        admin1.addNotice(mathNotice, mathCourse);
        admin1.addNotice(physicsNotice, physicsCourse);
        //Storing notification data
        //FileManagement.writeToFile(Admin.getNotices(), "notices.txt", notice -> notice.objectToString());
        
        // Step 9: Read data from files using FileManagement
        ArrayList<Teacher> teachersFromFile = FileManagement.readFromFile("teachers.txt", line -> {
            String[] parts = line.split(",");
            if (parts.length >= 3) {
                return new Teacher(parts[0], parts[1], parts[2], parts[3] , true);
            } else {
                System.err.println("Invalid teacher data: " + Arrays.toString(parts));
                return null;  // Or handle the error in a way that suits your logic
            }
        });
        
        ArrayList<Student> studentsFromFile = FileManagement.readFromFile("students.txt", line -> {
            String[] parts = line.split(",");

            // Ensure the data has exactly 3 parts (name, email, password)
            if (parts.length >0) {
                return new Student(parts[0], parts[1], parts[2] , true);
            } else {
                // Log error message for invalid data
                System.err.println("Invalid student data: " + Arrays.toString(parts));
                return null;  // Handle invalid data (e.g., skip this entry)
            }
        });
        ArrayList<Course> coursesFromFile = FileManagement.readFromFile("courses.txt", line -> {
            String[] parts = line.split(",");
            if (parts.length > 0) {
                return new Course(parts[0], new Teacher(parts[1], parts[2], parts[3], parts[4] , true),parts[5], Double.parseDouble(parts[6]), parts[7]);
            } else {
                System.err.println("Invalid course data: " + Arrays.toString(parts));
                return null;  // Or handle the error in a way that suits your logic
            }
        });

        // Display the loaded data
        //Print teachers' data from the file
        System.out.println("\nTeachers loaded from file:");
        for (Teacher teacher : teachersFromFile) {
            if (teacher != null) {
                System.out.println(teacher.getName() + " - " + teacher.getSpecialty());
            }
        }
        //Print students' data from the file
        System.out.println("\nStudents loaded from file:");
        for (Student student : studentsFromFile) {
            if (student != null) {
                System.out.println(student.getName() + " - " + student.getEmail());
            }
        }
        //Print courses' data from the file
        System.out.println("\nCourses loaded from file:");
        for (Course course : coursesFromFile) {
            if (course != null) {
                System.out.println(course.getCourseName() + " - " + course.getDescription() + " - $" + course.getPrice());
            }
        }

        // Step 10: View course details and student grades
        System.out.println("\nDetails for the Mathematics course:");
        mathCourse.viewCourseDetails();  // View course details directly from the Course class

        System.out.println("\nDetails for the Physics course:");
        physicsCourse.viewCourseDetails();  // View course details directly from the Course class

        // Display grades of students for assignments and courses
        System.out.println("\nAssignment grades for students :");
        student1.viewAssignmentGrades();
        student2.viewAssignmentGrades();
        student3.viewAssignmentGrades();
        student4.viewAssignmentGrades();

        // Display course grades
        System.out.println("\nCourse grades for students :");
        student1.viewCourseGrades();
        student2.viewCourseGrades();
        student3.viewCourseGrades();
        student4.viewCourseGrades();
        }
        
    }
}
