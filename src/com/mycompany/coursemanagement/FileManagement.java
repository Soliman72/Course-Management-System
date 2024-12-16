/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.coursemanagement;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileManagement {

    // Generic method to write a list of objects to a file
    public static <T> void writeToFile(ArrayList<T> objects, String filename, Function<T, String> objectToString) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (T object : objects) {
            writer.write(objectToString.apply(object));
            writer.newLine();
        }
        writer.close();
    }

    // Generic method to read a list of objects from a file
    public static <T> ArrayList<T> readFromFile(String filename, Function<String, T> stringToObject) throws IOException {
        ArrayList<T> objects = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            objects.add(stringToObject.apply(line));
        }
        reader.close();
        return objects;
    }

    // Generic method to write a single object to a file
    public static <T> void writeSingleObjectToFile(T object, String filename, Function<T, String> objectToString) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
        writer.write(objectToString.apply(object));
        writer.newLine();
        writer.close();
    }

    // To confirm the oneness of the email
    public static boolean emailExists(String email, String filename) {
        File file = new File(filename);

        // Check if the file exists before trying to read it
        if (!file.exists()) {
            return false;
        }

        try {
            // Read each line as a simple String object
            ArrayList<String> lines = readFromFile(filename, line -> line);

            for (String line : lines) {
                String[] parts = line.split(",");
                // Email is the second part of the line
                if (parts.length > 1 && parts[1].trim().equals(email)) {
                    return true;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, "Failed to read from " + filename, ex);
        }
        return false;
    }

    // Method to search for objects by email in a file
    public static String[] search(String email, String filename) {
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
                    return parts;  // Return the matched object immediately
                }
            }

            reader.close(); // Close the file if no match is found
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, "Failed to read from " + filename, ex);
        }

        return null; // Return null if no match is found
    }

    // Method to search for Assignment by course name in a file
    public static String[] searchAssignment(String courseName, String filename) {
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
                // course name is the third part of the line (adjust index if course name position changes)
                if (parts.length > 1 && parts[2].trim().equals(courseName)) {
                    reader.close(); // Close the file after finding the match
                    return parts;  // Return the matched object immediately
                }
            }

            reader.close(); // Close the file if no match is found
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, "Failed to read from " + filename, ex);
        }

        return null; // Return null if no match is found
    }

    // Method to search for Course by course name in a file
    public static String[] searchCourse(String courseName, String filename) {
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
                // course name is the third part of the line (adjust index if course name position changes)
                if (parts.length > 1 && parts[0].trim().equals(courseName.trim())) {
                    reader.close(); // Close the file after finding the match
                    return parts;  // Return the matched object immediately
                }
            }

            reader.close(); // Close the file if no match is found
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, "Failed to read from " + filename, ex);
        }

        return null; // Return null if no match is found
    }

    // To verify the validity of the email
    public static boolean validEmail(String email) {
        // Regular expression for validating email
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        // Validate the email format
        if (email.matches(emailRegex)) {
            return true;
        }
        return false;
    }

}
