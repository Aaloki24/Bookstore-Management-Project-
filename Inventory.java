/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patelaalokiproject3;

import java.util.*;
import java.io.*;


/**
 * This class manages the inventory list of the book store
 * @author aalok
 */
public class Inventory 
{
    public static List inventoryList = new ArrayList<>();
    public static List productsPurchased = new ArrayList<>();
    public static int totalSales = 0;
    public static double totalRevenue = 0;

    // A public static void method to display the updated inventory eachtime the method is called
    public static void displayInventory() 
    {
        for (int i = 0; i < inventoryList.size(); i++) 
        {
            Product product = (Product) inventoryList.get(i);
            System.out.println(product);
        }
    }

    // metod to generate inventory list from the csv file
    public static void generateInventoryList()
    {
      String line = "";  
      String splitBy = ",";  
      try   
      {  
      //parsing a CSV file into BufferedReader class constructor  
      BufferedReader br = new BufferedReader(new FileReader("ProductInventory-1.csv"));  
        while ((line = br.readLine()) != null)   //returns a Boolean value  
        {  
          String[] temp = line.split(splitBy);    // use comma as separator
          if(temp[1].equals("book")){
              Book newBook = new Book(Integer.valueOf(temp[0]),temp[1]);
              newBook.setName(temp[2]);
              newBook.setAuthor(temp[3]);
              newBook.setStock(Integer.valueOf(temp[4]));
              newBook.setPrice(Double.valueOf(temp[5]));
              inventoryList.add(newBook);
          }
          else if(temp[1].equals("cd")){
              CD newBook = new CD(Integer.valueOf(temp[0]),temp[1]);
              newBook.setName(temp[2]);
              newBook.setAuthor(temp[3]);
              newBook.setStock(Integer.valueOf(temp[4]));
              newBook.setPrice(Double.valueOf(temp[5]));
              inventoryList.add(newBook);
          }
          else if(temp[1].equals("dvd")){
              DVD newBook = new DVD(Integer.valueOf(temp[0]),temp[1]);
              newBook.setName(temp[2]);
              newBook.setAuthor(temp[3]);
              newBook.setStock(Integer.valueOf(temp[4]));
              newBook.setPrice(Double.valueOf(temp[5]));
              inventoryList.add(newBook);
          }
        }  
      } 
      //exception handling
      catch (FileNotFoundException e){  
        System.out.println("File not found! Please try again.");  
      }
      catch (IOException e){
          e.printStackTrace();
      }
    }


    // A public static void method to buy a product from the inventory list
    /**
     * 
     * @param user is the user that wants to buy a product at book store
     * @param productId is the Id of the product the user wants to buy
     */
    public static void buyProduct(StoreMember user, int productId) 
    {
        if (inventoryList.isEmpty()) 
        {
            System.out.println("You've bought all our products :). Inventory is being updated.");
            System.out.println("Press 3 to exit");
        } 
        else 
        {
            Iterator<Product> it = inventoryList.iterator();
            boolean productFound = false;
            while (it.hasNext()) 
            {
                Product product = it.next();
                if (product.getProductId() == productId) 
                {
                    // Money credited to company fund
                    Admin.addToCompanyFund(product.getPrice());
                    
                    // product added to users cart
                    user.getProductsBought().add(product);
                    
                    // Remove the product from the inventory List
                    if(product.getStock() <= 1){
                        it.remove();
                    } else{
                        product.setStock(product.getStock()-1);
                    }
                    productsPurchased.add(product.getName()); // adding purchased products to the puchased list for report purposes
                    totalSales++; // incrementing this everytime a product has been sold for report purposes
                    totalRevenue += product.getPrice(); // keep track of total revenue for the day report purposes
                    System.out.println("User " + user.getEmail() + " bought " + product.getName() + ". Total purchaces " + user.getProductsBought());
                    displayInventory();
                    Admin.welcomeMessage();
                    System.out.println("4. To continue shopping");
                    productFound = true;
                }
            }
            
            
            if (!productFound) 
            {
                System.out.println("Product " + productId + " Not found.");
                Admin.welcomeMessage();
                System.out.println("4. To continue shopping");
            }
        }
    }

}

interface BookstoreSpecification 
{
    /**
     * given a product id and a product quantity, update 
     * stock by adding amount to existing product quantity 
     * 
     * @param productId
     * @param amount
     * @return 
     */
    public int restockProduct (int productId, int amount);
   
    /**
     * calculate and return dollar amount for current inventory of products
     * that is in stock 
     * 
     * @return total in stock value 
     */
    public double inventoryValue();
}

    

