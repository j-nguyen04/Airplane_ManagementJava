/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w1977770_planemanagement;

/**
 *
 * @author j_ngu
 */

public class Person {
    private String name; //Setting the 3 attributes to the class Person
    private String surname;
    private String email;
    
    public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
    
    public String getName() { // Using the getters to retrieve the value of the attributes of Person
        return name;                  
    }
    
    public String getSurname() {
        return surname;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setname(String name) { // Using setters to modify the value of the variable
        this.name = name;
    }
    
    public void setsurname(String surname) {
        this.surname = surname;
    }
    
    public void setemail(String email) {
        this.email = email;
    }
    
    public void person_info() {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Email: " + email);
    }
}
