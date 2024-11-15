package com.mycompany.coursemanagement;

import java.io.IOException;
import java.time.LocalTime;
import java.util.*;

public class Coursemanagement {

    public static void main(String[] args) throws IOException {
        FileManagement fileManager = new FileManagement();

        // Step 1: Create Admin
        Admin admin1 = new Admin("Admin User", "admin@example.com", "admin123");

        // Step 2: Create Teachers
        Teacher teacher1 = new Teacher("Mr. Smith", "teacher123", "smith@example.com", "Mathematics");
        Teacher teacher2 = new Teacher("Ms. Johnson", "teacher456", "johnson@example.com", "Physics");

        // Add teachers using Admin
        admin1.addTeacher(teacher1);
        admin1.addTeacher(teacher2);

        // Step 3: Create Students
        Student student1 = new Student("John Doe", "student123", "john@example.com");
        Student student2 = new Student("Jane Roe", "student456", "jane@example.com");
        Student student3 = new Student("Michael Blue", "student789", "michael@example.com");
        Student student4 = new Student("Sarah White", "student101", "sarah@example.com");

        // Add students using Admin
        admin1.addStudent(student1);
        admin1.addStudent(student2);
        admin1.addStudent(student3);
        admin1.addStudent(student4);

        // Step 4: Create Courses
        Course mathCourse = new Course("Mathematics", teacher1, "Algebra and Calculus", 200.0, LocalTime.of(10, 0));
        Course physicsCourse = new Course("Physics", teacher2, "Mechanics and Thermodynamics", 250.0, LocalTime.of(14, 0));

        // Add courses using Admin
        admin1.addCourse(mathCourse);
        admin1.addCourse(physicsCourse);

        // Step 5: Enroll students in courses
        student1.enrollCourse(mathCourse); // John enrolls in Math
        student2.enrollCourse(mathCourse); // Jane enrolls in Math
        student3.enrollCourse(physicsCourse); // Michael enrolls in Physics
        student4.enrollCourse(physicsCourse); // Sarah enrolls in Physics

        // Admin assigns the teacher to the course
        admin1.setTeacherOfCourse(mathCourse, teacher1);
        admin1.setTeacherOfCourse(physicsCourse, teacher2);

        // Step 6: Create Assignments
        Assignment mathAssignment1 = new Assignment(1, "Solve Algebra Problems", "Algebra Assignment", new Date());
        Assignment physicsAssignment1 = new Assignment(2, "Mechanics Problems", "Physics Assignment", new Date());

        // Add assignments to courses
        mathCourse.addAssignment(mathAssignment1);
        physicsCourse.addAssignment(physicsAssignment1);

        // Step 7: Teachers assign grades to students for assignments
        Grade grade1 = new Grade(90, "Well done", "Assignment");
        Grade grade2 = new Grade(85, "Good Job", "Assignment");
        Grade grade3 = new Grade(95, "Excellent", "Assignment");
        Grade grade4 = new Grade(80, "Well done", "Assignment");

        // Teacher assigns grades to students
        teacher1.assignGrade(mathAssignment1, grade1, student1);
        teacher1.assignGrade(mathAssignment1, grade2, student2);
        teacher2.assignGrade(physicsAssignment1, grade3, student3);
        teacher2.assignGrade(physicsAssignment1, grade4, student4);

        // Optional: Set course grade for students (based on performance)
        Grade mathCourseGrade1 = new Grade(88, "Excellent work in Math", "Course");
        Grade mathCourseGrade2 = new Grade(78, "Good work in Math", "Course");
        Grade physicsCourseGrade1 = new Grade(92, "Outstanding in Physics", "Course");
        Grade physicsCourseGrade2 = new Grade(85, "Good in Physics", "Course");

        student1.addCourseGrade(mathCourse, mathCourseGrade1);
        student2.addCourseGrade(mathCourse, mathCourseGrade2);
        student3.addCourseGrade(physicsCourse, physicsCourseGrade1);
        student4.addCourseGrade(physicsCourse, physicsCourseGrade2);

        // Step 8: Save data to files using FileManagement
        fileManager.writeToFile(Admin.getTeachers(), "teachers.txt", teacher -> teacher.getName() + "," + teacher.getEmail() + "," + teacher.getSpecialty());
        fileManager.writeToFile(Admin.getStudents(), "students.txt", student -> student.getName() + "," + student.getEmail());
        fileManager.writeToFile(Admin.getCourses(), "courses.txt", course -> course.getCourseName() + "," + course.getDescription() + "," + course.getPrice() + "," + course.getTimePeriod());

        // Step 9: Read data from files using FileManagement
        List<Teacher> teachersFromFile = fileManager.readFromFile("teachers.txt", line -> {
            String[] parts = line.split(",");
            if (parts.length >= 3) {
                return new Teacher(parts[0], parts[1], parts[2], parts[2]);
            } else {
                System.err.println("Invalid teacher data: " + Arrays.toString(parts));
                return null;  // Or handle the error in a way that suits your logic
            }
        });

        List<Student> studentsFromFile = fileManager.readFromFile("students.txt", line -> {
        String[] parts = line.split(",");
    
        // Ensure the data has exactly 3 parts (name, email, password)
        if (parts.length == 3) {
            return new Student(parts[0], parts[1], parts[2]);
        } else {
            // Log error message for invalid data
            System.err.println("Invalid student data: " + Arrays.toString(parts));
            return null;  // Handle invalid data (e.g., skip this entry)
        }
        });


        List<Course> coursesFromFile = fileManager.readFromFile("courses.txt", line -> {
            String[] parts = line.split(",");
            if (parts.length >= 4) {
                return new Course(parts[0], null, parts[1], Double.parseDouble(parts[2]), LocalTime.parse(parts[3]));
            } else {
                System.err.println("Invalid course data: " + Arrays.toString(parts));
                return null;  // Or handle the error in a way that suits your logic
            }
        });

        // Display the loaded data
        System.out.println("\nTeachers loaded from file:");
        for (Teacher teacher : teachersFromFile) {
            if (teacher != null) {
                System.out.println(teacher.getName() + " - " + teacher.getSpecialty());
            }
        }

        System.out.println("\nStudents loaded from file:");
        for (Student student : studentsFromFile) {
            if (student != null) {
                System.out.println(student.getName() + " - " + student.getEmail());
            }
        }

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
        System.out.println("\nGrades for students in Mathematics course:");
        student1.viewAssignmentGrades();
        student2.viewAssignmentGrades();

        System.out.println("\nGrades for students in Physics course:");
        student3.viewAssignmentGrades();
        student4.viewAssignmentGrades();

        // Display course grades
        System.out.println("\nCourse grades for Mathematics course:");
        student1.viewCourseGrades();
        student2.viewCourseGrades();

        System.out.println("\nCourse grades for Physics course:");
        student3.viewCourseGrades();
        student4.viewCourseGrades();
    }
}
