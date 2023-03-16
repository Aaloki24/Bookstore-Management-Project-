/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patelaalokiproject3;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author aalok
 */
public class StoreMember {
    
//package users;

    // private instance variable, not accessible from outside this class
    private String email;
    private String password;
    private String membershipType;
    private Date dateOfPayment;
    private int numPurchases;
    private List<Product> productsBought = new ArrayList<>();


    /**     
    * Constructs StoreMember with an email, password, membershipType, and dateOfPayment    
    *     
    * @param email the email of the store member     
    * @param password the password of the store member
    * @param membershipType the type of the membership of the store member
    * @param dateOfPayment is the payment date for the membership
    */
    public StoreMember(String email, String password, String membershipType, Date dateOfPayment) 
    {
        this.email = email;
        this.password = password;
        this.membershipType = membershipType;
        this.dateOfPayment = dateOfPayment;
    }

    /**
     * Constructs StoreMember with just an email
     * @param email 
     */
    public StoreMember(String email) 
    {
        this.email = email;
    }

    // A public method for retrieving the email    
    /**     
    *    
    * @return Returns a String value of the email of the member     
    */
    public String getEmail() 
    {
        return email;
    }

    // A public method for retrieving the password    
    /**     
    *    
    * @return Returns a String value of the password of the member     
    */
    public String getPassword() 
    {
        return password;
    }

    // A public method for retrieving the list of products brought by the member    
    /**     
    *    
    * @return Returns an array of the list of products brought by the member     
    */
    public List<Product> getProductsBought() 
    {
        return productsBought;
    }

    // A public method for retrieving the type of membership    
    /**     
    *    
    * @return Returns a String value of the type of membership of the member     
    */
    public String getMembershipType() 
    {
        return membershipType;
    }

    // A public method for retrieving the date of payment    
    /**     
    *    
    * @return Returns a Date value of the payment date done by the member     
    */
    public Date getDateOfPayment() 
    {
        return dateOfPayment;
    }

    // A public method for setting the dateOfPayment to the user entered date of payment   
    public void setDateOfPayment(Date dateOfPayment) 
    {
        this.dateOfPayment = dateOfPayment;
    }

    @Override // overrides the object class toString method
    public String toString() 
    {
        return " email = " + email + '\'' +
                ", membershipType = " + membershipType;
    }

    @Override // overrides the object class equals method
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
        StoreMember user = (StoreMember) o;
        return email.equals(user.email);
    }

    @Override // overrides the object class hashCode method
    public int hashCode() 
    {
        return Objects.hash(email);
    }
}


