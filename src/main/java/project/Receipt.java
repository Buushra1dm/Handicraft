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

public class Receipt {
    //filds of Receipt class
    
    private double totalprice;
    // Agreegation 
    private Customers customer;
    private Product product;
    private boolean discounts;
    private double tax;
    private String owner; 

   
    /**
     * constructor that accept all data members as arguments in Receipt class
     * @param totalprice
     * @param c
     * @param p
     * @param discounts
     * @param tax
     * @param owner 
     */

    
    public Receipt(double totalprice, Customers c, Product p, boolean discounts, double tax, String owner) {
        
        this.totalprice = totalprice;
        this.customer = new Customers(c);
        this.discounts = discounts;
        this.tax = tax;
        this.owner = owner;
        this.product = new Product(p);
    }
    
    /**
     * this is a defult constructor
     */

    public Receipt() {
        
        this.discounts = false;
        this.totalprice = 0;
        this.tax = 1.15; //include tax
        this.customer = null;
        this.owner = "";
        this.product = null; 
    }

    
    /**
     * set method for owner field
     * @param owner 
     */

    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    /**
     * get method for owner field
     * @return owner
     */
    
    public String getOwner() {
        return owner;
    }
    
    /**
     * set method for products field
     * @param products 
     */

    
    public void setProducts(Product products) {
        this.product = new Product(products);
    }

    /**
     * set method for customer number field
     * @param customer 
     */
    
    
    public void setCustomer(Customers customer) {
        this.customer = new Customers(customer);
    }
    
    
    /**
     * get method for product field
     * @return product
     */

    public Product getProducts() {
        return new Product(this.product);
    }
    
    /**
     * get method for customer field
     * @return customer
     */

    public Customers getCustomer() {
        return new Customers(this.customer);
    }
    
    
    /**
     * get method for total price field
     * @return totalprice
     */

    public double getTotalPrice() {
        return this.totalprice;
    }

    
    /**
     * set method for discount field
     * @param discounts 
     */
    public void setDiscounts(boolean discounts) {

        this.discounts = discounts;

    }

    /**
     * get method for discount field
     * @return discounts
     */
    public boolean getDiscounts() {
        return this.discounts;
    }

    /**
     * get method for tax  field
     * @return tax
     */
    public double getTax() {
        return this.tax;
    }

    /**
     * set method for tax field
     * @param tax 
     */
    public void setTax(double tax) {
        this.tax = tax;
    }
    
    
    /**
     * this method to make sure that have discount or not
     * return true if they have and false if they not have discount
     * @param owner
     * @return discounts
     */
    
    public boolean discount(String owner) {
        
        this.discounts = false;
        if (owner.equalsIgnoreCase("bushra") || owner.equalsIgnoreCase("rawan")) {
            System.out.println("you put correct code discount :) ");
            this.discounts = true;
        }
        return this.discounts;
    }
    
    
    /**
     * this method to calculate price with discount 
     * @return totalprice
     */

    public double calculatePrice() {
        this.totalprice = 0;
        
        this.totalprice += (product.getProduct_price() * (this.tax));
        if (this.discounts) {
            this.totalprice -= 30;
            return this.totalprice;
        }
        return this.totalprice;
        
    }
    
    
    /**
     * print Details of the object
     * @return print
     */
    
    @Override
    public String toString() {
        String print = "RECEITS DETAILS:"+ "\nProducts : " + this.product.toString() + "\nCustomer " + this.customer.toString() + "\nTotal Price: " + calculatePrice() + "SR with";
        if (!this.discounts) {
            //if they have discount or not
            print += " no discount";
        } else {
            System.out.println("discount 30 SR from total applied");
        }
        return print;
    }

    
    
    /**
     * file for Receipts to print the details in file
     * @throws IOException 
     */

    public void FileReceipts() throws IOException {
        
        //appending the file

        FileWriter fw = new FileWriter("Receipts.txt", true);
        //object from FileWriter
        
        PrintWriter pw = new PrintWriter(fw);
        //object from PrintWriter

        
     
        
        pw.print(this.customer.getId()+"\t"+"\t");
        pw.print(this.customer.getFullname()+"\t"+"\t");
        pw.print(this.product.getProduct_no()+"\t"+"\t");
        pw.print(this.product.getProduct_price()+"\t"+"\t");
        pw.print(this.discounts +"\t"+"\t");
        pw.println(calculatePrice());
        
        //colse the file
        pw.close();
        
    }

    /**
     * read from receipts file
     * @throws IOException 
     */
    public void showReceipts() throws IOException {
        
        

        
        System.out.println("****\t Customer id \t\tCustomer name\t\tproduct No\tprice\t\t discount\t  totalprice");
        System.out.println("-------------------------------------------------------------------------------"+
                "--------------------------------------");
        File f = new File("Receipts.txt");
        Scanner inputfile = new Scanner(f);

        

        //while is there more print it
        while (inputfile.hasNext()) {

            // details to store the details on it
            String details;
            details = inputfile.nextLine();
            // number of receipts  
            System.out.println("-" +"\t"+ details);
            
            

            
        }
        

        //colse the file
        inputfile.close();
    }

}
    

