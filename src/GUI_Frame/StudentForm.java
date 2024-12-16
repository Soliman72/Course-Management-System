/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI_Frame;


import com.mycompany.coursemanagement.Course;
import com.mycompany.coursemanagement.FileManagement;
import com.mycompany.coursemanagement.Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shahd
 */
public class StudentForm extends javax.swing.JFrame {

    private String studentEmail= "john@example.com";
    /**
     * Creates new form StudentForm
     */
    public StudentForm() {
        setUndecorated(true);
        initComponents();
    }

    public StudentForm(String email){
        this.studentEmail = email;
        initComponents();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NoticesPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        NoticesTable1 = new javax.swing.JTable();
        AssPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        AssTable = new javax.swing.JTable();
        DetailsPanel = new javax.swing.JPanel();
        EnrollPanel = new javax.swing.JPanel();
        editData = new javax.swing.JButton();
        jstudentName1 = new javax.swing.JLabel();
        StudentTitle = new javax.swing.JLabel();
        describtion = new javax.swing.JLabel();
        logoutLabel = new javax.swing.JLabel();
        exitLabel = new javax.swing.JLabel();
        DetailsButton = new javax.swing.JButton();
        enrollCourseLabel1 = new javax.swing.JLabel();
        Enroll2 = new javax.swing.JButton();
        jlStudentName = new javax.swing.JTextField();
        StudentTitle1 = new javax.swing.JLabel();
        exitLabel1 = new javax.swing.JLabel();
        logoutLabel1 = new javax.swing.JLabel();
        viewassLabel = new javax.swing.JLabel();
        ButtonviewASS = new javax.swing.JButton();
        submitAssignment = new javax.swing.JLabel();
        Submit = new javax.swing.JButton();
        EnrollButton = new javax.swing.JButton();
        describtion2 = new javax.swing.JLabel();
        DetailsStPanel = new javax.swing.JPanel();
        AvailableCoursesPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CoursesTable = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        DetailsTable = new javax.swing.JTable();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NoticesPanel.setBackground(new java.awt.Color(0, 0, 0));
        NoticesPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NoticesTable1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        NoticesTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course Name", "Title", "Content", "Date"
            }
        ));
        jScrollPane4.setViewportView(NoticesTable1);

        NoticesPanel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 220));

        getContentPane().add(NoticesPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 310, 470, 220));

        AssPanel.setBackground(new java.awt.Color(0, 0, 0));
        AssPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AssTable.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        AssTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No Of Ass", "Course Name", "Title", "Description", "DeadLine"
            }
        ));
        jScrollPane3.setViewportView(AssTable);

        AssPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 220));

        getContentPane().add(AssPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 310, 470, 220));

        DetailsPanel.setBackground(new java.awt.Color(0, 0, 0));
        DetailsPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray));
        DetailsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        EnrollPanel.setBackground(new java.awt.Color(0, 0, 0));
        EnrollPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray));
        EnrollPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editData.setBackground(new java.awt.Color(0, 0, 0));
        editData.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        editData.setForeground(new java.awt.Color(255, 255, 255));
        editData.setText("Update Your Data");
        editData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editDataActionPerformed(evt);
            }
        });
        EnrollPanel.add(editData, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 190, 50));

        jstudentName1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jstudentName1.setForeground(new java.awt.Color(255, 255, 255));
        jstudentName1.setText("Student Name : ");
        EnrollPanel.add(jstudentName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 150, 30));

        StudentTitle.setFont(new java.awt.Font("Arial", 0, 32)); // NOI18N
        StudentTitle.setForeground(new java.awt.Color(255, 255, 255));
        StudentTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StudentTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/group.png"))); // NOI18N
        StudentTitle.setText("Student");
        EnrollPanel.add(StudentTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 420, 41));

        describtion.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        describtion.setForeground(new java.awt.Color(255, 255, 255));
        describtion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        describtion.setText("Hello! Let's learn");
        EnrollPanel.add(describtion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 420, -1));

        logoutLabel.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        logoutLabel.setForeground(new java.awt.Color(255, 255, 255));
        logoutLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logoutLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/001-logoute.png"))); // NOI18N
        logoutLabel.setText("Logout");
        logoutLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutLabelMouseClicked(evt);
            }
        });
        EnrollPanel.add(logoutLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 80, 20));

        exitLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        exitLabel.setForeground(new java.awt.Color(255, 255, 255));
        exitLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitLabel.setText("X");
        exitLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitLabelMouseClicked(evt);
            }
        });
        EnrollPanel.add(exitLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 29));

        DetailsButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DetailsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/skills.png"))); // NOI18N
        DetailsButton.setText("Details About You");
        DetailsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DetailsButton.setMaximumSize(new java.awt.Dimension(119, 43));
        DetailsButton.setMinimumSize(new java.awt.Dimension(119, 43));
        DetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetailsButtonActionPerformed(evt);
            }
        });
        EnrollPanel.add(DetailsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 300, 50));

        enrollCourseLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        enrollCourseLabel1.setForeground(new java.awt.Color(255, 255, 255));
        enrollCourseLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        enrollCourseLabel1.setText("Enroll Course");
        EnrollPanel.add(enrollCourseLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 200, 60));

        Enroll2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Enroll2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/checklist.png"))); // NOI18N
        Enroll2.setText("Enroll");
        Enroll2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Enroll2.setMaximumSize(new java.awt.Dimension(119, 43));
        Enroll2.setMinimumSize(new java.awt.Dimension(119, 43));
        Enroll2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Enroll2MouseClicked(evt);
            }
        });
        EnrollPanel.add(Enroll2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 160, 50));

        jlStudentName.setBackground(new java.awt.Color(0, 0, 0));
        jlStudentName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlStudentName.setForeground(new java.awt.Color(255, 255, 255));
        jlStudentName.setText("Unknown");
        EnrollPanel.add(jlStudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 120, 30));

        DetailsPanel.add(EnrollPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 500));

        StudentTitle1.setFont(new java.awt.Font("Arial", 0, 32)); // NOI18N
        StudentTitle1.setForeground(new java.awt.Color(255, 255, 255));
        StudentTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StudentTitle1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/group.png"))); // NOI18N
        StudentTitle1.setText("Student");
        DetailsPanel.add(StudentTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 420, 41));

        exitLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        exitLabel1.setForeground(new java.awt.Color(255, 255, 255));
        exitLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitLabel1.setText("X");
        exitLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitLabel1MouseClicked(evt);
            }
        });
        DetailsPanel.add(exitLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 29));

        logoutLabel1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        logoutLabel1.setForeground(new java.awt.Color(255, 255, 255));
        logoutLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logoutLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/001-logoute.png"))); // NOI18N
        logoutLabel1.setText("Logout");
        logoutLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutLabel1MouseClicked(evt);
            }
        });
        DetailsPanel.add(logoutLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 80, 20));

        viewassLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        viewassLabel.setForeground(new java.awt.Color(242, 242, 242));
        viewassLabel.setText("View Assignment");
        DetailsPanel.add(viewassLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 190, -1));

        ButtonviewASS.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ButtonviewASS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/homework.png"))); // NOI18N
        ButtonviewASS.setText("Vew");
        ButtonviewASS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonviewASS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonviewASSMouseClicked(evt);
            }
        });
        DetailsPanel.add(ButtonviewASS, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 190, 50));

        submitAssignment.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        submitAssignment.setForeground(new java.awt.Color(255, 255, 255));
        submitAssignment.setText("Assignment Grade");
        DetailsPanel.add(submitAssignment, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 170, 30));

        Submit.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/submit.png"))); // NOI18N
        Submit.setText("Submit");
        Submit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Submit.setMaximumSize(new java.awt.Dimension(119, 43));
        Submit.setMinimumSize(new java.awt.Dimension(119, 43));
        Submit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SubmitMouseClicked(evt);
            }
        });
        DetailsPanel.add(Submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 190, 50));

        EnrollButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        EnrollButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/skills.png"))); // NOI18N
        EnrollButton.setText("Enroll New Courses");
        EnrollButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EnrollButton.setMaximumSize(new java.awt.Dimension(119, 43));
        EnrollButton.setMinimumSize(new java.awt.Dimension(119, 43));
        EnrollButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnrollButtonActionPerformed(evt);
            }
        });
        DetailsPanel.add(EnrollButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 300, 50));

        describtion2.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        describtion2.setForeground(new java.awt.Color(255, 255, 255));
        describtion2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        describtion2.setText("Hello! Let's learn");
        DetailsPanel.add(describtion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 420, -1));

        getContentPane().add(DetailsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 650, 500));

        DetailsStPanel.setBackground(new java.awt.Color(0, 0, 0));
        DetailsStPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AvailableCoursesPanel.setBackground(new java.awt.Color(0, 0, 0));
        AvailableCoursesPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CoursesTable.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CoursesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course", "Description", "Price"
            }
        ));
        jScrollPane1.setViewportView(CoursesTable);

        AvailableCoursesPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 250));

        DetailsStPanel.add(AvailableCoursesPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 250));

        DetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course Name", "Description", "Price"
            }
        ));
        jScrollPane6.setViewportView(DetailsTable);

        DetailsStPanel.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 250));

        getContentPane().add(DetailsStPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 470, 250));

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/background.jpg"))); // NOI18N
        getContentPane().add(backgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitLabel1MouseClicked

    private void logoutLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutLabel1MouseClicked
        new LoginForm();
    }//GEN-LAST:event_logoutLabel1MouseClicked

    private void logoutLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutLabelMouseClicked
        new LoginForm();
    }//GEN-LAST:event_logoutLabelMouseClicked

    private void exitLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLabelMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitLabelMouseClicked

    private void DetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetailsButtonActionPerformed
        EnrollPanel.setVisible(false);
        DetailsPanel.setVisible(true);
        AvailableCoursesPanel.setVisible(false);
        DetailsStPanel.setVisible(true);
        NoticesPanel.setVisible(false);

    }//GEN-LAST:event_DetailsButtonActionPerformed

    private void EnrollButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnrollButtonActionPerformed
        EnrollPanel.setVisible(true);
        AvailableCoursesPanel.setVisible(true);
        NoticesPanel.setVisible(true);

    }//GEN-LAST:event_EnrollButtonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setLocationRelativeTo(null);
//        for (double i = 0.0; i <=1.0; i = i+0.1){
//            String val = i+ "";
//            float f = Float.valueOf(val);
//            this.setOpacity(f);
//        }
        try{
            Thread.sleep(50);
        }catch(Exception e){}
        try {
            // Use the readFromFile method to read the course data
            ArrayList<String[]> courses = FileManagement.readFromFile("courses.txt", line -> {
                // Split the line by commas
                String[] parts = line.split(",");
                if (parts.length >= 0) {
                    return new String[]{parts[0], parts[5], parts[6]}; // Extract only the required indices
                }
                return null;
            });

            DefaultTableModel model = (DefaultTableModel) CoursesTable.getModel();

            // Clear existing rows to prevent duplication
            model.setRowCount(0);

            // Populate the table with filtered course data
            for (String[] course : courses) {
                if (course != null) { // Skip null values
                    model.addRow(course);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        try {
            // Use the readFromFile method to read the notice data
            ArrayList<String[]> notices = FileManagement.readFromFile("notices.txt", line -> {
                // Split the line by commas
                String[] parts = line.split(",");
                if (parts.length >= 0) {
                    return new String[]{parts[0], parts[1], parts[2], parts[3]}; // Extract only the required indices
                }
                return null;
            });

            DefaultTableModel model = (DefaultTableModel) NoticesTable1.getModel();

            // Clear existing rows to prevent duplication
            model.setRowCount(0);

            // Populate the table with filtered notice data
            for (String[] notice : notices) {
                if (notice != null) { // Skip null values
                    model.addRow(notice);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        
        try {
            // Retrieve the teacher's data using their email
            String[] studentData = FileManagement.search(this.studentEmail, "students.txt");

            if (studentData != null) {
                // Set the labels with the retrieved data
                jlStudentName.setText(studentData[0]); // Assuming the name is at index 0
            } else {
                // Handle case where no matching teacher is found
                jlStudentName.setText("Unknown");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log any unexpected exceptions
            jlStudentName.setText("Error");
        }
    }//GEN-LAST:event_formWindowOpened

    // Method to add a single course to the student's existing courses
    public void addCourseToStudent(String newCourse) {
        File file = new File("students.txt");
        ArrayList<String> lines = new ArrayList<>();
        boolean studentFound = false;

        try {
            // Read all lines from the file
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();

            // Find the row with matching email and update the courses part
            for (int i = 0; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(",");
                if (parts.length > 1 && parts[1].trim().equalsIgnoreCase(this.studentEmail)) {
                    // Append the new course to the existing courses
                    String currentCourses = parts[3].trim();
                    if (!currentCourses.equals("[]")) {
                        currentCourses = currentCourses.substring(0, currentCourses.length() - 1) + ", " + newCourse + "]";
                    } else {
                        currentCourses = "[" + newCourse + "]";
                    }
                    parts[3] = currentCourses; // Update the courses field (4th field in the CSV)
                    lines.set(i, String.join(",", parts));
                    studentFound = true;
                    break;
                }
            }

            // If student is found, write the updated lines back to the file
            if (studentFound) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                for (String updatedLine : lines) {
                    writer.write(updatedLine);
                    writer.newLine();
                }
                writer.close();
                System.out.println("Student courses updated successfully.");
            } else {
                System.out.println("Student with email " + this.studentEmail + " not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    private void Enroll2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Enroll2MouseClicked
//        int row = CoursesTable.getSelectedRow();
//        if (row < 0){
//            JOptionPane.showMessageDialog(this, "No row is selected! Please selected one row", "Error" , JOptionPane.ERROR_MESSAGE);
//        } else {
//            addCourseToStudent((String)CoursesTable.getValueAt(row, 0));
//            String[] studentData = FileManagement.search(studentEmail, "students.txt");
//            if (studentData != null) {
//                // Debug: Print the entire studentData array
//                //System.out.println("Student data: " + Arrays.toString(studentData));
//
//                String coursesField = "";
//                for(int i=3 ;i<studentData.length; i++){
//                    if(studentData[i].trim().startsWith("["))
//                        studentData[i] = studentData[i].trim().substring(1, studentData[i].length() - 1);
//                    if(studentData[i].trim().endsWith("]"))
//                        studentData[i] = studentData[i].trim().substring(0, studentData[i].length() - 2);
//                    coursesField += studentData[i].trim();
//                    if(i != studentData.length-1)
//                        coursesField += ",";
//                }
//                //System.out.println("Raw courses field: " + coursesField);
//
//                // Split by comma and optional spaces, ensure that no empty course is added
//                String[] enrolledCourses = coursesField.split(",\\s*");
//                //System.out.println("Enrolled courses: " + Arrays.toString(enrolledCourses));
//                
//                // Load the courses data from courses.txt
//                ArrayList<String[]> matchingCourses = new ArrayList<>();
//                for (String c : enrolledCourses) {
//                    System.out.println(c);
//                    String[] course = FileManagement.searchCourse(c, "courses.txt");
//                    System.out.println("courses: " + Arrays.toString(course));
//                    String[] cc = {course[0] ,course[5] , course[6] , course[7]};
//                    matchingCourses.add(cc);
//                }
//                System.out.println("Matching courses: " + matchingCourses);
//
//                // Populate the table with the student's courses
//                DefaultTableModel model = (DefaultTableModel) DetailsTable.getModel();
//                model.setRowCount(0); // Clear existing rows
//
//                // Add the matched courses to the table
//                for (String[] course : matchingCourses) {
//                    model.addRow(course);
//                }
//                
//            } else {
//                JOptionPane.showMessageDialog(this, "Student not found in the records!", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//        }
        int row1 = CoursesTable.getSelectedRow();
        if (row1 < 0){
            JOptionPane.showMessageDialog(this, "No row is selected! Please selected one row", "Error" , JOptionPane.ERROR_MESSAGE);
        } else {
            try{
            String[] studentdata = FileManagement.search(studentEmail, "students.txt"); // Handle the exception appropriately
            Student student1 = new Student(studentdata[0], studentdata[1], studentdata[2], true);
            
            ArrayList<String[]> Courses = new ArrayList<>();
            for(Course course : student1.getCourses()){
                String[] parts = course.objectToString().split(",");
                String[] newparts = {parts[0], parts[5], parts[6]};
                Courses.add(newparts);
            }
           
            boolean courseExists = false;
            String selectedCourseName = (String) CoursesTable.getValueAt(row1, 0);
            
            
            for(Course course : student1.getCourses()){
                if(course.getCourseName().equals(selectedCourseName)){
                    courseExists = true;
                    break; 
                }
            }
            if (courseExists) {
                JOptionPane.showMessageDialog(this, "Course already exists!", "Error", JOptionPane.ERROR_MESSAGE);
          } else {
                String[] newCourse = {
                    (String) CoursesTable.getValueAt(row1, 0),
                    (String) CoursesTable.getValueAt(row1, 1),
                    (String) CoursesTable.getValueAt(row1, 2)
                };
                Courses.add(newCourse);
                
                DefaultTableModel model = (DefaultTableModel) DetailsTable.getModel();
                // Clear existing rows to prevent duplication
                model.setRowCount(0);
                // Populate the table with filtered assignment data
                for (String[] Course : Courses) {
                    if (Course != null) { // Skip null values
                        model.addRow(Course);
                    }
                }
                JOptionPane.showMessageDialog(this, "Course added successfully!");
            }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_Enroll2MouseClicked

    private void ButtonviewASSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonviewASSMouseClicked
        AssPanel.setVisible(true);    
        int row = DetailsTable.getSelectedRow();
        if (row < 0){
            JOptionPane.showMessageDialog(this, "No row is selected! Please selected one row", "Selected row" , JOptionPane.ERROR_MESSAGE);
        } else {
            try {

                // Use the readFromFile method to read the assignment data
                    ArrayList<String[]> assignments = FileManagement.readFromFile("assignments.txt", line -> {
                        // Split the line by commas
                        String[] parts = line.split(",");
                        // Check if the course name matches the course's name
                        if (parts.length >= 0 && parts[1].trim().equals((String)DetailsTable.getValueAt(row, 0))) { // Ensure there are enough fields and match course name
                            return new String[]{parts[0],parts[1], parts[2], parts[3],parts[4]}; // Extract only the required indices
                        }
                        return null; // Ignore lines that do not match the course name or have insufficient data
                    });

                DefaultTableModel model = (DefaultTableModel) AssTable.getModel();

                // Clear existing rows to prevent duplication
                model.setRowCount(0);


                for (String[] assignment : assignments) {
                    if (assignment != null) { // Skip null values
                        model.addRow(assignment);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace(); // Handle the exception appropriately
            }
        }
    }//GEN-LAST:event_ButtonviewASSMouseClicked

    private void SubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubmitMouseClicked
        JOptionPane.showMessageDialog(this, "Assignment submit successfully!");
    }//GEN-LAST:event_SubmitMouseClicked

    private void editDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editDataActionPerformed
        String newName = jlStudentName.getText();

        // Update admin name in admins.txt
        updateStudentName(newName);

        // Optionally, update the UI to reflect the changes
        jlStudentName.setText(newName);

        JOptionPane.showMessageDialog(this, "Admin name updated successfully!");

    }//GEN-LAST:event_editDataActionPerformed

    public void updateStudentName(String newName) {
        File file = new File("students.txt");
        ArrayList<String> lines = new ArrayList<>();
        boolean adminFound = false;

        try {
            try ( // Read all lines from the admins.txt file
                    BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            }

            // Iterate through the lines to find the admin with the matching email
            for (int i = 0; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(",");
                if (parts.length >= 2 && parts[1].trim().equalsIgnoreCase(this.studentEmail)) {
                    // If the admin email matches, update the name
                    parts[0] = newName; // Update admin's name
                    lines.set(i, String.join(",", parts)); // Update the line in the list
                    adminFound = true;
                    break;
                }
            }

            // If the admin was found, write the updated data back to the file
            if (adminFound) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    for (String updatedLine : lines) {
                        writer.write(updatedLine);
                        writer.newLine();
                    }
                }
                System.out.println("Admin details updated successfully.");
            } else {
                System.out.println("Admin with email " + this.studentEmail + " not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        
        java.awt.EventQueue.invokeLater(() -> {
            new StudentForm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AssPanel;
    private javax.swing.JTable AssTable;
    private javax.swing.JPanel AvailableCoursesPanel;
    private javax.swing.JButton ButtonviewASS;
    private javax.swing.JTable CoursesTable;
    private javax.swing.JButton DetailsButton;
    private javax.swing.JPanel DetailsPanel;
    private javax.swing.JPanel DetailsStPanel;
    private javax.swing.JTable DetailsTable;
    private javax.swing.JButton Enroll2;
    private javax.swing.JButton EnrollButton;
    private javax.swing.JPanel EnrollPanel;
    private javax.swing.JPanel NoticesPanel;
    private javax.swing.JTable NoticesTable1;
    private javax.swing.JLabel StudentTitle;
    private javax.swing.JLabel StudentTitle1;
    private javax.swing.JButton Submit;
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JLabel describtion;
    private javax.swing.JLabel describtion2;
    private javax.swing.JButton editData;
    private javax.swing.JLabel enrollCourseLabel1;
    private javax.swing.JLabel exitLabel;
    private javax.swing.JLabel exitLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField jlStudentName;
    private javax.swing.JLabel jstudentName1;
    private javax.swing.JLabel logoutLabel;
    private javax.swing.JLabel logoutLabel1;
    private javax.swing.JLabel submitAssignment;
    private javax.swing.JLabel viewassLabel;
    // End of variables declaration//GEN-END:variables
}