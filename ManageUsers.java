/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patelaalokiproject3;

import java.util.*;

/**
 * This class manages the users at the book store
 * @author aalok
 */
public class ManageUsers {
    
    public static Set<StoreMember> registeredUsers = new HashSet<>();
    public static StoreMember loggedInUser = null;

    static 
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 0);
        StoreMember userPrimary1 = new StoreMember("firstUser@firstuser.com","pass1","PREMIUM", calendar.getTime());
        StoreMember userRegular1 = new StoreMember("secondUser@secondUser.com","pass2","REGULAR", calendar.getTime());
        registeredUsers.add(userPrimary1);
        registeredUsers.add(userRegular1);
    }

     
    /**
     * A public static void method that logins the existing user
     * @param sc is the user's input
     */
    public static void userLogin(Scanner sc) 
    {
        if (null == loggedInUser) 
        {
            System.out.println("Type in your email:");
            String email = sc.next();
            System.out.println("Type in your password:");
            String password = sc.next();
            Iterator<StoreMember> it = registeredUsers.iterator();
            boolean userFound = false;
            while(it.hasNext()) 
            {
                StoreMember user = it.next();
                if (user.getEmail().equals(email) && user.getPassword().equals(password))
                {
                    loggedInUser = user;
                    userFound = true;
                    System.out.println("When did you pay the premium fee?");
                    int days = sc.nextInt();
                    if (days >30) {
                        System.out.println("Your premium membership fee of $30 is due. It is being deducted from your account");
                        Admin.addToCompanyFund(30);
                        user.setDateOfPayment(new Date());
                    }
                
                    System.out.println("You are successfully logged in.");
                    System.out.println("Press 4 to continue shopping");
                }
            }
            if (!userFound) 
            {
                System.err.println("Incorrect email/password combination. press 2 to Try again.");
            }
        } 
        else 
        {
            System.out.println("User is already logged in: "+ loggedInUser + ".");
            System.out.println("Press 4 to continue shopping");
        }
    }

     
    /**
     * A public static void method to register the user and print the registered members list.
     * @param sc is the user's input 
     * @throws Exception when other options than provided are entered by the user in the validateUser method
     */
    public static void registerUser(Scanner sc) throws Exception 
    {
        StoreMember member = validateUser(sc);
        addUser(member);
        System.out.println("User " + member.getEmail() + " registered.");
        System.out.println("Press 4 to continue shopping");
        System.out.println("List of users:");
        for (StoreMember user : registeredUsers) 
        {
            System.out.println(user);
        }
        ManageUsers.loggedInUser = member;
    }

    
    /**
     * A public static void method to add the user to the premium membership users list
     * @param user is the user at the book store
     */
    public static void addUser(StoreMember user)
    {
        if (user.getMembershipType().equals("PREMIUM")) 
        {
            System.out.println("Premium membership fee of $30 is deducted from your account");
            Admin.addToCompanyFund(30);
        }
        registeredUsers.add(user);
    }

    
    /**
     * A private static method to validate if the user's entered email is already registered or not
     * @param sc is the user's input 
     * @return Returns a toString of the StoreMember class with the user's email, password, membership type, and date of the payment
     * @throws Exception when other options than provided are entered by the user
     */
    private static StoreMember validateUser(Scanner sc) throws Exception 
    {
        System.out.println("Enter your Email");
        String email = sc.next();
        boolean existingUser = true;
        do 
        {
            if (registeredUsers.contains(new StoreMember(email))) 
            {
                System.out.println("Email "+ email +" is already taken. Try with another email");
                email = sc.next();
                continue;
            }
            existingUser = false;
        } while (existingUser);
        
        
        System.out.println("Enter your password");
        String password = sc.next();
        System.out.println("Enter your membership: type 1 for Regular or type 2 for Premium");
        String membership = "REGULAR";
        int membershipType = sc.nextInt();
        
        if (membershipType == 1) 
        {
            membership = "REGULAR";
        } 
        else if (membershipType == 2) 
        {
            membership = "PREMIUM";
        } 
        else 
        {
            throw new Exception("Illegal Membership Id: "+ membershipType + ". Valid ones are 1 or 2");
        }
        
        return new StoreMember(email, password, membership, new Date());
    }
}


