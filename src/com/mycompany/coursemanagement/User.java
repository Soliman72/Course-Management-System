/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.coursemanagement;

public abstract class User {
    // Attributes
    private String name;
        private String email;
    private String password;
    
    // Empty Constructor
    public User(){}
    
    // Parameterized Constructor 
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }    

    // Setter User name
    public void setName(String name) {
        this.name = name;
    }
    
    // Getter User name
    public String getName() {
        return name;
    }
    
    // Setter User email
    public void setEmail(String email) {
        this.email = email;
    }
    
    // Getter User email
    public String getEmail() {
        return email;
    }
    
    // Setter User password
    public void setPassword(String password) {
        this.password = password;
    }
    
    // Getter User password
    public String getPassword() {
        return password;
    }

    // Convert object(Student, Admin) to string
    public String objectToString() {
        return this.getName() + "," + this.getEmail() + "," + this.getPassword();
    }
    
    // check if the user has account in website or not 
    public abstract boolean logIn(String email,String password);
    
    //Confirm the existence of the object and then delete it from the file
    public abstract void logOut();
}
