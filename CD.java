/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patelaalokiproject3;

//package inventory;
/**
 * The child class to the parent class Product that contains the information of CDs
 * @author aalok
 */

public class CD extends Product{
    private String name;
    private String artist;
    private double price;
    private int stock;
    private int productId;

    /**     
    * Constructs a CD with a given productId and productType    
    *     
     * @param productId
     * @param productType  
    */
    public CD(int productId, String productType) 
    {
        super(productId,productType);
        this.productId = productId;
    }
    
    public int getProductId(){
        return this.productId;
    }
    
    public String getType(){
       return "cd";
   }

   public String getName() 
    {
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getAuthor() 
    {
        return this.artist;
    }
    
    public void setAuthor(String artist){
        this.artist = artist;
    }
    
    public double getPrice() 
    {
        return this.price;
    }
    
    public void setPrice(Double price){
        this.price = price;
    }
    
    public int getStock() 
    {
        return this.stock;
    }
    
    public void setStock(int stock){
        this.stock = stock;
    }
    
    @Override
    public String toString() 
    {
        return "{ " + getProductId() +
                " name = " + getName() +
                ", artist = " + getAuthor() +
                ", price = " + getPrice() +
                ", stock = " + getStock() +
                ", type = " + getType() +
                " }";
    }
}


