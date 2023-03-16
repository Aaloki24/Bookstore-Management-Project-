/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patelaalokiproject3;
import java.util.Objects;
import java.lang.Class;


/**
 * This class contains the information of the product and it is the parent class of DVD, CD and Book classes
 * @author aalok
 */


public abstract class Product implements Comparable<Product> {
    
    private int productId;
    private String ProductType;
    
    public Product(int productId, String productType){
        this.productId = productId;
        this.ProductType = productType;
    }
    
    public int getProductId() {
        return productId;
    }
    public String getType() {
        return null;
    }
    
    public String getName() 
    {
        return null;
    }
    
    public void setName(String name){
        
    }
    
    public String getAuthor() 
    {
        return null;
    }
    
    public void setAuthor(String author){
        
    }
    
    public double getPrice() 
    {
        return 0;
    }
    
    public void setPrice(Double price){
        
    }
    
    public int getStock() 
    {
        return 0;
    }
    
    public void setStock(int stock){
        
    }
    
    public void decrementCount(Product product){
        
    }

    @Override
    public boolean equals(Object o) 
    {
        if (this == o)
        {
            return true;
        }   
        if (o == null || getClass() != o.getClass()) 
        {
            return false;
        }
        
        Product product = (Product) o;
        return this.getName().equals(product.getName());
    }
     
    @Override
    public int hashCode() 
    {
        return Objects.hash(this.getName());
    }
     
    @Override
    public String toString() 
    {
        return "{ " +
                " name = " + getName() +
                ", price = " + getPrice() +
                ", type = " + getType() +
                " }";
    }
    
    @Override
    public int compareTo(Product newProduct) 
    {
       if(this.getPrice() == newProduct.getPrice())
       {
           return 0;
       }
       else if(this.getPrice() > newProduct.getPrice())
       {
           return 1;
       }
       else
       {
           return -1;
       }
    }
       
    
    
    
    
}
