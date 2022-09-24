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

public class Product {
    //filds of Product class
    
    private int product_no;
    private String product_name;
    private double product_price;
    
    /**
     * constructor that accept all data members as arguments in product class
     * @param product_no
     * @param product_name
     * @param product_price 
     */

    public Product(int product_no, String product_name, double product_price) {
        
        this.product_no = product_no;
        this.product_name = product_name;
        this.product_price = product_price; 
    }

    /**
     * this is a defult constructor
     */
    
    public Product() {
        
        this.product_no = 0;
        this.product_name = "";
        this.product_price = 0;
        
    }
    
    /**
     * this is copy constructor
     * copy each field of the input object into the new instance
     * @param products 
     */

    public Product(Product products) {
        
        this.product_no = products.product_no;
        this.product_name = products.product_name;
        this.product_price = products.product_price;
    }

    /**
     * set method for product number field
     * @param product_no 
     */
    
    public void setProduct_no(int product_no) {
        this.product_no = product_no;
    }

    /**
     * set method for product name field
     * @param product_name
     */
    
    public void setProduct_name(String product_name) {
        
        this.product_name = product_name;  
    }
    
    /**
     * set method for product price field
     * @param product_price 
     */
    

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
        
    }

    /**
     * get method for product number field
     * @return product_no
     */
    public int getProduct_no() {
        return product_no;
    }
    /**
     * get method for product name field
     * @return product_name
     */

    public String getProduct_name() {    
        return product_name;
        
    }
    
    /**
     * get method for product price field
     * @return product_price
     */
   
    public double getProduct_price() {
        return product_price;
    }
    
    /**
     * this is method for print the menu of products 
     */

    
    public void menuproduct(){
        System.out.println("1--Course for Pottery art - children --75\n" +
                            "2--Course for Pottery art - Senior--100\n" +
                            "3--Ceramic Paste Course - Senior--150\n" +
                            "4--Resin education course--200");
    }
    
    /**
     * print Details of the object
     * @return print
     */
    
    @Override
    public String toString() {
        String print = "Producst Details:\nNo: " + getProduct_no() + "\tName: " + getProduct_name() + "\tPrice: " + getProduct_price();
        return print;
    }
    
    /**
     * file for products to print the details in file
     * @throws IOException 
     */
    
    public void FileProducts() throws IOException{
        
        //appending the file
        
        FileWriter fw = new FileWriter("Products.txt",true);
        //object from FileWriter
        
        PrintWriter pw = new PrintWriter(fw);
        //object from PrintWriter
        
        
        // here print customer details in file 
        
        pw.println("Product Number:");
        pw.println(this.getProduct_no());
        
        pw.println("Product Name:");
        pw.println(this.getProduct_name());
        
        pw.println("Product price:");
        pw.println(this.getProduct_price());
        
        pw.println("");
        pw.println("---------------");
        
        //colse the file
        pw.close();
    }
    
    /**
     * read from products file
     * @throws IOException 
     */
    
    public void showProducts()throws IOException{
        
        // details to store the details on it
        String details;
        
        
        File f = new File("Products.txt");
        Scanner inputfile = new Scanner(f); 
        
        //while is there more print it
        
        while(inputfile.hasNext()){
            
            details = inputfile.nextLine();
            System.out.println(details + "\n");
            
        }
        
        //colse the file
        inputfile.close();
        
    }
    
    
    
}
