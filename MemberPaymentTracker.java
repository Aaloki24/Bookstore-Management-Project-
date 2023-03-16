/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patelaalokiproject3;

import java.util.Calendar;
import java.util.Date;

/**
 * This class tracks the member's payment 
 * @author aalok
 */
public class MemberPaymentTracker {
    

    public static void main(String[] args) 
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -9);
        StoreMember user = new StoreMember("s","s","regular", calendar.getTime());
        isMembershipFeeDue(user);
    }

    // A public static method for retriving a boolean value if the member paid their dues on time or not    
    /**     
    *    
    * @return Returns a Boolean value to represent if the member paid his dues on time or not     
    */
    public static boolean isMembershipFeeDue(StoreMember user)
    {
        if (null != user.getEmail()) 
        {
            Date lastMembershipDate = user.getDateOfPayment();
            Date currDate = new Date();
            
            long difference_In_Time
                    = currDate.getTime() - lastMembershipDate.getTime();
            
            long difference_In_Days
                    = (difference_In_Time
                    / (1000 * 60 * 60 * 24))
                    % 365;
            
            if (difference_In_Days > 30) 
            {
                return true;
            }
        }
        return false;
    }
}
    



