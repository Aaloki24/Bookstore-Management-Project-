/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patelaalokiproject3;
//package admin;

/**
 * This class is responsible for managing the store's basic functions
 * @author aalok
 */
public class Admin {

    public static long companyFund = 1000;
    // A public static void method for printing the welcome Message to the user   
    public static void welcomeMessage() 
    {
       System.out.println("Here are the choices");
       System.out.println("1. Register User");
       System.out.println("2. Login Existing User");
       System.out.println("3. Exit the system");
       System.out.println("5. Compare two items based on Price");
       System.out.println("6. To restock a product and display the inventory total");
    }

    // A public static void method that adds money to the total company fund
    public static void addToCompanyFund(double money) 
    {
        System.out.println("Amount " + money + " is being added to company fund");
        companyFund += money;
        System.out.println("New company fund is $" + companyFund);
    }

}