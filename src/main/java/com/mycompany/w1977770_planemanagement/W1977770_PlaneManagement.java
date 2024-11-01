/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.w1977770_planemanagement;

import java.util.Scanner;

/**
 *
 * @author j_ngu
 */
public class W1977770_PlaneManagement {


    private char [][] seats;
    private Ticket [] tickets;
    private int ticketCount;
    
    public W1977770_PlaneManagement() {
        seats = new char[4][];
    
    // Initialize each row with the appropriate number of seats
        seats[0] = new char[14]; // This is labelled as row A with the maximum seat numbers to be 14
        seats[1] = new char[12]; // This is labelled as row B with the maximum seat numbers to be 12
        seats[2] = new char[12]; // This is labelled as row C with the maximum seat numbers to be 12
        seats[3] = new char[14]; // This is labelled as row D with the maximum seat numbers to be 14
        
        
        // Initialize seats and print the seating plan where i is the row number and j to be a seat number
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = 'O'; // Initialize each seat as 'O'
                System.out.print(seats[i][j]); // Print each seat
            }
            System.out.println();
        }
        System.out.println();
  
    }
    public void buy_seat(Scanner input) { // Creates a method called buy_seat
        System.out.println("Enter the row letter (A-D): "); // Prompts the user to enter a row letter
        char rowChar = input.next().charAt(0);
        int row = rowChar - 'A';
        
        System.out.println("Enter seat number: 1-" + seats[row].length); // Prompts the user to enter a seat number
        int col = input.nextInt();
        
        if (col < 0 || col > seats[row].length) {
            System.out.println("Wrong seat number\n");
            return;
        }
        col = col -1;
        
        if (!(seats[row][col] == 'O')) {
            
            System.out.println("Seat " + rowChar + (col + 1) + " is not available.\n");
            return;
        }
  
        double price;
        if (col >= 0 && col <= 4) {
            price = 200.0;            // Seats between 1-4 cost 200
        }        
        else if (col >= 5 && col <= 8) {
            price = 150.0;           // Seats between 6-9 cost 150
        }        
        else {
            price = 180.0;          // Seats between 10-14 cost 180
        }
        
        System.out.println("Enter your name: ");
        String name = input.next();
        System.out.println("Enter your surname: ");
        String surname = input.next();
        System.out.println("Enter your email: ");
        String email = input.next();
        
        Person jonny = new Person(name, surname, email);  // Creating an object      
        
        Ticket newTicket = new Ticket(String.valueOf(rowChar), col + 1, price, jonny);
        newTicket.save();
        
        addTicket(newTicket);  // We add the newTicket to the array tickets      
        
        
        seats[row][col] = 'X';
        
    }
    
    public void addTicket(Ticket ticket) {
        // Check if the tickets array is null, create it if it's null
        if (tickets == null) {
            tickets = new Ticket[52]; // Maximum seat number
            ticketCount = 0;
        }
    
    // Check if there is space in the tickets array
        if (ticketCount < tickets.length) {
            tickets[ticketCount] = ticket;
            ticketCount++;
            System.out.println("Ticket added");
        } 
    } 
    
    public void cancel_seat(Scanner input) {
        System.out.println("Enter your row letter A-D");
        char rowChar = input.next().charAt(0);
        int row = rowChar - 'A';
        
        System.out.println("Enter seat number: 1-" + seats[row].length);
        int col = input.nextInt();
        
        if (col < 1 || col > seats[row].length) {
            System.out.println("Wrong seat number\n");
            return;               
        }
        col = col - 1;
       
        if (seats[row][col] == 'O') {
            System.out.println("Seat " + rowChar + (col + 1) + " is already available. \n");
            return;
        }
       
        seats[row][col] = 'O';
        System.out.println("Seat " + rowChar + (col + 1) + " has been cancelled. \n");
        
        removeTicket(rowChar, col + 1);
        
        
    }
    
    public void removeTicket(char rowChar, int seatNumber) {
        for (int i = 0; i < ticketCount; i++) {
        Ticket ticket = tickets[i];
        if (ticket.getRow().equals(String.valueOf(rowChar)) && ticket.getSeat() == seatNumber) {
           
            for (int j = i; j < ticketCount - 1; j++) {
                tickets[j] = tickets[j + 1];
            }
            tickets[ticketCount - 1] = null;
            ticketCount--;
            System.out.println("Ticket is removed ");
            return;
        }
    }
}                                    
    
    public void find_first_available(){
        int print_col = 0;
        int set_col = 0;
        
        for(int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == 'O') {
                    print_col = (j+1);
                    set_col = (j-1);
                    System.out.println("First available seat is found at " + (char)('A' + i) + print_col);
                    seats[i][set_col] = 'X';
                    return;
                }
                
            }
        }
        
        
    }
    
    public void show_seating_plan() {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j]); // Print each seat
            }
            System.out.println();
        }
        System.out.println();
  
    }
    
    public void print_tickets_info() {
    
    double totalSales = 0;

    System.out.println("Tickets Sold During the Session:");
    for (int i = 0; i < ticketCount; i++) {
        Ticket ticket = tickets[i];
        System.out.println("Ticket " + (i + 1) + ":");
        ticket.printTicket();

        
        totalSales += ticket.getPrice();
    }

    System.out.println("Total Sales: £" + totalSales);
        
    }
    
    
    
    public void search_ticket(Scanner input) {
        System.out.println("Enter the row letter (A-D): ");
        char rowChar = input.next().charAt(0);
        int row = rowChar - 'A';
        
        System.out.println("Enter seat number: 1-" + seats[row].length);
        int col = input.nextInt();
        
        if (col < 0 || col > seats[row].length) {
            System.out.println("Wrong seat number\n");
            return;
        }
        col = col -1;
        
         boolean seatFound = false;
         for (int i = 0; i < ticketCount; i++) {
              Ticket ticket = tickets[i];
              if (ticket.getRow().equals(String.valueOf(rowChar)) && ticket.getSeat() == (col + 1)) {
                System.out.println("Ticket found for Seat " + rowChar + (col + 1));
                ticket.printTicket();
                seatFound = true;
                break;
        }
    }

    if (!seatFound) {
        System.out.println("This seat is available.");
    }
}  
    
    public static void main(String[] args) {
        W1977770_PlaneManagement seatingPlan = new W1977770_PlaneManagement();
        
        
        
        Scanner input = new Scanner(System.in);
        int choice; 
        
        do {                            
            System.out.println("Welcome to the Plane Management application");
            System.out.println("\n*   MENU OPTIONS   *");
            System.out.println("\n1. Buy a seat");
            System.out.println("\n2. Cancel a seat");
            System.out.println("\n3. Find first available seat");
            System.out.println("\n4. Show seating plan");
            System.out.println("\n5. Print tickets information and total sales");
            System.out.println("\n6. Search ticket");
            System.out.println("\n0. Quit");
            System.out.println("\n*************************");
            System.out.println("\nPlease select an option");
            choice = input.nextInt();
            
            switch(choice) {
                case 1:
                    seatingPlan.buy_seat(input);
                    break;
                case 2:
                    seatingPlan.cancel_seat(input);
                    break;
                case 3:
                    seatingPlan.find_first_available();
                    break;
                case 4:
                    seatingPlan.show_seating_plan();
                    break;
                case 5:
                    seatingPlan.print_tickets_info();
                    break;
                case 6:
                    seatingPlan.search_ticket(input);
                    break;
                 
            }
            
      } while (choice != 0);
       input.close();  
    }

}
