/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
// for file
import java.util.ArrayList;
// to arraylist
import java.util.Scanner;
// Scanner object

/**
 *
 * @author PC
 */
public class HandicraftDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        // use object from Scanner
        Scanner keyboard = new Scanner(System.in);

        // each object from Product saved in Product list
        ArrayList<Product> products = new ArrayList<>();
        // each object from customers saved in customers list
        ArrayList<Customers> customers = new ArrayList<>();
        // each object from receipts saved in receipts list
        ArrayList<Receipt> receipts = new ArrayList<>();

        
        int option = 0;
        int id;
        int num;
        String fname, lname, email, mobile;
        // choose which products
        int nump = 0; 
        String dis, owner;
        
     

        //creat object from Customers class
        Customers c1 = new Customers();
        //creat object from Product class
        Product p = new Product();
        //creat object from Receipt class
        Receipt r = new Receipt();
        
        //here is do-while loop 
        
        do {
            
            
            System.out.println("-----------------------------------");
            System.out.println("");
            System.out.println("    WELCOME TO HANDICRAFT PROGRAM ");
            System.out.println("");
            System.out.println("-----------------------------------");
            
            
            printMenu1(); // print menu using this method
            
            // prompt user to enter value
            System.out.print("Enter your choice :"); 
            // read the value from user
            option = keyboard.nextInt(); 
            
            keyboard.nextLine();
            
            // switch for what user option
            switch (option) {
                
                case 1:
                    //ask user to put his infomation
                    
                    // prompt user to enter value
                    System.out.print("Enter Customer first name: ");
                    // read the value from user
                    fname = keyboard.nextLine();
                    
                    //send to object
                    c1.setFirstName(fname);
                    
                    // prompt user to enter value
                    System.out.print("Enter Customer last name: ");
                    // read the value from user
                    lname = keyboard.nextLine();
                    
                    //send to object
                    c1.setLastName(lname);
                    
                    // prompt user to enter value
                    System.out.print("Enter Customer ID number: ");
                    // read the value from user
                    id = keyboard.nextInt();
                    
                    // vaildation if user dont enter 0 or less
                    while (id <= 0){
                    System.out.println("wrong input !");
                    System.out.println("try again");
                    System.out.print("Enter Customer ID number: ");
                    id = keyboard.nextInt();
                    }
                    
                    //send to object
                    c1.setId(id);
                    
                    keyboard.nextLine();
                    
                    // prompt user to enter value
                    System.out.print("Enter Customer email: ");
                    // read the value from user
                    email = keyboard.nextLine();
                    
                    //send to object
                    c1.setEmail(email);
                    
                    // prompt user to enter value
                    System.out.print("Enter Customer Phone number: ");
                    // read the value from user
                    mobile = keyboard.nextLine();
 
                    //send to object
                    c1.setPhone(mobile);
                    //send to object and save it there
                    c1.Filecustomer();
                    
                    // now add the object with taken information to the arraylist
                    customers.add(c1); 
                    
                    //object 
                    r = new Receipt();
                    //send the infomation to object 
                    r.setCustomer(c1);
                    
                    System.out.println("Customer has been added to the system");
                    System.out.println("");
                    System.out.println("");
                    
                    
                  
                    p.menuproduct();
                    // prompt user to enter value
                    System.out.print("Enter your choice :"); 
                    // read the value from user
                    nump = keyboard.nextInt();
                    
                    keyboard.nextLine();

                    //object
                    p = new Product();
                    
                    
                    while (nump < 1 || nump > 4){
                        
                        System.out.println("wrong input ! tey again");
                        // prompt user to enter value
                        System.out.print("Enter your choice :"); 
                        // read the value from user
                        nump = keyboard.nextInt();
                    }
                 

                    if (nump == 1) {
                        
                        p.setProduct_no(1);
                        p.setProduct_name("Course for Pottery art - children");
                        p.setProduct_price(75);

                        p.FileProducts();

                        System.out.println("");
                        //print deatils that user choose
                        System.out.println(p.toString());

                    

                    } else if (nump == 2) {
                        

                        //send to object
                        p.setProduct_no(2);
                        p.setProduct_name("Course for Pottery art  - Senior");
                        p.setProduct_price(100);

                        //send to object
                        p.FileProducts();

                        System.out.println("");
                        //print deatils that user choose
                        System.out.println(p.toString());

                    } else if (nump == 3) {

                        //send to object
                        p.setProduct_no(3);
                        p.setProduct_name("Ceramic Paste Course - Senior");
                        p.setProduct_price(150);

                        //send to object
                        p.FileProducts();

                        System.out.println("");
                        //print deatils that user choose
                        System.out.println(p.toString());

                    } else  {

                        //send to object
                        p.setProduct_no(4);
                        p.setProduct_name("Resin education course");
                        p.setProduct_price(200);

                        //send to object
                        p.FileProducts();

                        System.out.println("");
                        //print deatils that user choose
                        System.out.println(p.toString());
                    }
                    
                    // now add the object with taken information to the arraylist
                    products.add(p);
                    
                    keyboard.nextLine();
                    // prompt user to enter value
                    System.out.print("Do you have discount ?\n");
                    System.out.println("write Y or N ");
                    // read the value from user
                    dis = keyboard.nextLine();
                    dis = "" + dis.charAt(0);
                    
                    if (dis.equalsIgnoreCase("Y")) {
                        
                        // prompt user to enter value
                        System.out.println("please enter the code :");
                        // read the value from user
                        owner = keyboard.nextLine();
                        //send to the object 
                        r.discount(owner);
                        
                    }else {
                        
                        System.out.println("No discount");
                        
                    }
                    
                    System.out.println("");
                    System.out.println("");
                    
                    //send to the object 
                    r.setProducts(p);
                    //wite in file on object
                    r.FileReceipts();
                    
                    r.calculatePrice();
                    
                    //print deatils for receipts
                    System.out.println(r.toString());
                    // now add the object with taken information to the arraylist
                    receipts.add(r);
                    
                    break;
                    
                    
                case 2:
                   
                    //here to display all customers has been saved
                    c1.showCustomer();
                    
                    break;
                    
                case 3:
                    
                    //here to display all receipts has been saved
                    r.showReceipts();
                    
                    break;
               
                case 4:
                    break;
                
                default:
                    System.out.println("Please Enter a number from 1 to 5");
                    System.out.println("try again ! ");
                    break;
            }

            // while do not choose 5 
        } while (option != 4);

    }

    
    public static void printMenu1() {
        
        System.out.println("1. Add new customer with products ( make reservation )" );
        //read from customers file
        System.out.println("2. Show customers details for owner"); 
        System.out.println("3. Display view past reservations"); 
        //read from Recripte file
        System.out.println("4. Exit");
    }


    
}
    
    

