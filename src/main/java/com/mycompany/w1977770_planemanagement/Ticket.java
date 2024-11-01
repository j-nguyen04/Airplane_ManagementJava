/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w1977770_planemanagement;

import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author j_ngu
 */

public class Ticket { // Created a class Ticket with 4 attributes
    private String row;
    private int seat;       
    private double price;
    private Person person;
    
    public Ticket(String row, int seat, double price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
        
    }
    
    public String getRow() {
        return row;
    }
    
    public int getSeat() {
        return seat;
    }
    
    public double getPrice() {
        return price;
    }
   
    public Person getPerson() {
        return person;
    }
    
    
    
    public void setRow(String row) {
        this.row = row;
        
    }
    
    public void setSeat(int seat) {
        this.seat = seat;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }
    
    public void printTicket() {
        System.out.println("Seat " + row +seat);
        System.out.println("Price " + price);
        person.person_info();
        
    }
    
    public void save() { // Creating a file 
        String fileName = row + seat + ".txt";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Seat: " + row + seat + "\n");
            writer.write("Price: £" + price + "\n");
            //writer.write("Person Information: " + person.person_info());
            writer.write("Name: " + person.getName() + "\n");
            writer.write("Surname: " + person.getSurname() + "\n");
            writer.write("Email: " + person.getEmail() + "\n");
            System.out.println("Ticket information saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error occurred while saving ticket information: " + e.getMessage());
        }
    }
} 
    



