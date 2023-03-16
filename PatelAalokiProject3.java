package patelaalokiproject3;
import java.util.*;
import java.io.*;
import java.lang.Class;
import static patelaalokiproject3.Inventory.inventoryList;
/**
 * This is the main tester class that process the user's inputs and provides options accordingly.
 * @author aalok
 */
public class PatelAalokiProject3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception 
    {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to MarketSystem");
        Admin.welcomeMessage();
        Inventory.generateInventoryList();
        while(sc.hasNext()) 
        {
            String s1 = sc.next();
            if(s1.equals("3")) 
            {
                System.out.println("Exiting");
                generateReport();
                updateInventoryFile();
                break;
            } 
            else if (s1.equals("1")) 
            {
                ManageUsers.registerUser(sc);
            } 
            else if (s1.equals("2")) 
            {
                ManageUsers.userLogin(sc);
            } 
            else if (s1.equals("4")) 
            {
                if (ManageUsers.loggedInUser != null) 
                {
             
                    System.out.println("Please enter the product you want to buy:");
                    Inventory.displayInventory();
                    int productId = sc.nextInt();
                    Inventory.buyProduct(ManageUsers.loggedInUser, productId);
                } 
                else 
                {
                    System.out.println("You need to login.");
                    Admin.welcomeMessage();
                }
            }
            else if (s1.equals("5"))
            {
                System.out.println("Please enter the first product's name to be compared");
                //Product product1 = Product.setName(sc.next());
                System.out.println("Please enter the other product's name to be compared");
                String product2Name = sc.next();
                
            }
            else if (s1.equals("6"))
            {
                
            }
            else 
            {
                System.out.println("Invalid Input. Please try again!");
                Admin.welcomeMessage();
            }
        }
    }
    
    
    //method to generate report at the end of day
    private static void generateReport() {
        try {
            //create a writer
            FileWriter myWriter = new FileWriter("Report.txt");
            
            // write the data
            
            myWriter.write("Following products were purchased today: \n\n");
            for(int i = 0; i < Inventory.productsPurchased.size(); i++){
                myWriter.write(Inventory.productsPurchased.get(i).toString() + "\n");
            }
            myWriter.write("\nFollowing members were registered today: \n\n");
            for (StoreMember user : ManageUsers.registeredUsers) 
            {
                myWriter.write(user.toString() + "\n");
            }
            myWriter.write("\nItems sold today: " + Inventory.totalSales+ "\n");
            myWriter.write("\nTotal Revenue: $" + String.format("%.2f",Inventory.totalRevenue)+ "\n");
            
            // close the writer
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    //method to save a new csv with the updated inventory at the end of day
    private static void updateInventoryFile() {
        try {
            // create a list of products
            List<String> records = new ArrayList<>();
            
            for (int i = 0; i < inventoryList.size(); i++) 
            {
                Product p = (Product) inventoryList.get(i);
                String record = p.getProductId() + "," + p.getType() + "," + p.getName() + "," + p.getAuthor() +"," + p.getStock() +"," + p.getPrice();
                records.add(record);
            }

            // create a writer
            BufferedWriter writer = new BufferedWriter(new FileWriter ("BookInventoryDay2.csv"));

            // write header record
            writer.write("productID,type,title,author/artist,numInStock,price");
            writer.newLine();

            // write all records
            for (String record : records) {
                writer.write(record);
                writer.newLine();
            }
            //close the writer
            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
    
