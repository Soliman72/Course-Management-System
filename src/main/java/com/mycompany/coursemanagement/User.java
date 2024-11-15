/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.coursemanagement;

import java.util.*;

public abstract class User {
    // Attributes
    private String name;
    private String password;
    private String email;
    
    //constructor
    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }
    
    //setter and getters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String objectToString() {
        return this.getName() + "," + this.getEmail() + "," + this.getPassword();
    }
//    public Object StringToObject(String line){
//        String[] parts = line.split(",");
//        // Ensure the data has exactly 3 parts (name, email, password)
//        if (parts.length == 3) {
//            return new Admin(parts[0], parts[1], parts[2]);
//        } else {
//            // Log error message for invalid data
//            System.err.println("Invalid admin data: " + Arrays.toString(parts));
//            return null;  // Handle invalid data (e.g., skip this entry)
//        }
//    }
    
    
    // check if the user has account in website or not 
    public abstract void logIn(String email,String password);
    
    public abstract void logOut();
}
