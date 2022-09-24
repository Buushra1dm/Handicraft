/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author PC
 */
import java.io.File; 
//use it for file
import java.io.FileWriter;
//use it for file
import java.io.IOException;
// for exception
import java.io.PrintWriter;
//use it for file
import java.util.Scanner;
//Scanner import

public class Customers {
    //filds of customers class
    
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_no;

    
    /**
     * constructor that accept all data members as arguments in Customers class 
     * @param id
     * @param first_name
     * @param last_name
     * @param email
     * @param phone_no 
     */

    
    public Customers(int id, String first_name, String last_name, String email, String phone_no) {
        
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_no = phone_no;

    }
    
    /**
     * this is a defult constructor
     */
    
    
    public Customers() {
        
        this.id = 0;
        this.first_name = "Undefined"; 
        this.last_name = "Undefined"; 
        this.email = "Undefined"; 
        this.phone_no = "0";

    }
 
    
    /**
     * this is copy constructor
     * copy each field of the input object into the new instance
     * @param c 
     */
    
    
    public Customers(Customers c) {
        
        this.id = c.id;
        this.first_name = c.first_name;
        this.last_name = c.last_name;
        this.email = c.email;
        this.phone_no = c.phone_no;
        
    }
    /**
     * set method for id field
     * @param id 
     */

    public void setId(int id){
        this.id = id;
    }
    
    /**
     * set method for first name field
     * @param fname 
     */
    
    public void setFirstName(String fname) {
        this.first_name = fname;
    }
    
    /**
     * set method for last name field
     * @param lname 
     */

    public void setLastName(String lname) {
        this.last_name = lname;
    }
    
    /**
     * set method for email field
     * @param email 
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * set method for phone number field
     * @param phone 
     */
    
    public void setPhone(String phone) {
        this.phone_no = phone;
        
    }

    /**
     * get method for id field
     * @return id 
     */
    
    public int getId(){
        return this.id;
    }
    /**
     * get method for first name field 
     * @return first_name
     */
    
    public String getFirstName() {
        return first_name;
    }

    /**
     * get method for last name field
     * @return last_name
     */
    public String getLastName() {
        return last_name;
    }
    /**
     * get method for email field
     * @return email
     */

    public String getEmail() {
        return email;
    }

    /**
     * get method for phone number field
     * @return phone_no
     */
    public String getPhoneNo() {
        return phone_no;
    }
    /**
     * get method that take get method First Name with get method last Name 
     * @return full  
     */
    
    public String getFullname() {
        String full;
        full = getFirstName()+" "+getLastName();
        return full;
    }

    /**
     * print Details of the object
     * @return print
     */
    
    @Override
    public String toString() {
        String print = "Customer ID: \n" + getId() + "\nCustomer Full name: \n" + getFullname();
        print += "\nEmail : \n" + getEmail() + "\nCustomer Phone number : \n" + getPhoneNo();
        return print;
    }
    
    /**
     * file for customers to print the details in file
     * @throws IOException 
     */
    
    public void Filecustomer() throws IOException{
        
        //appending the file
        
        FileWriter fw = new FileWriter("Customers.txt",true);
        //object from FileWriter
        PrintWriter pw = new PrintWriter(fw);
        //object from PrintWriter

        // here print customer details in file 
        
        pw.print(getId()+"\t");
        pw.print(getFullname()+"\t"+"\t");
        pw.print(getEmail()+"\t"+"\t");
        pw.println(getPhoneNo()+"\t"+"\t");
        
        
        //colse the file
        pw.close();
    }

    /**
     * read from Customer file 
     * @throws IOException 
     */
    
    public void showCustomer()throws IOException{
        
        // details to store the details on it
        String details; 
       
        
        
        System.out.println("***\tID \t\tFullname \t\t\tEmail\t\t\t  Phone number ");
        System.out.println("-----------------------------------------------------------------------------------------------");
        
        
        File f = new File("Customers.txt");
        Scanner inputfile = new Scanner(f); 
        

        
        //while is there more print it
        while(inputfile.hasNext()){
          
            
        
            details = inputfile.nextLine();
            
            System.out.println("-" +"\t"+details);
            
            

        }
        
        //colse the file
        inputfile.close();
    }
    
    
}
