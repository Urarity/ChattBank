package BusinessObjects;

import java.util.ArrayList;

/****************************************
*
*   Patricia Rivera
*   AccountList Business Object | 9/19/2020
*   I wrote this code myself...
*
*****************************************/

public class AccountList {
    
    /*********** Properties *************/
    public int count = 0; // For count
    public ArrayList<Account> accArr = new ArrayList<Account>(); // Making an arrayList
    
    /*********** Methods ***************/
    public void addAcc(Account accs){
        accArr.add(accs); // Adds the account to our list
        count++; // Increment the count
    }
    
    public void displayList(){
        for(int x = 0; x<count; x++){
            accArr.get(x).display(); // Displays the list from the Account
        }
    }
    
    /*********** Test Methods **********/
    public static void main(String args[]){
        
        AccountList alist = new AccountList(); // Call an empty object
        
        // Add lists
        Account a = new Account("7777", "3001", "SAV", 500.00);
        Account b = new Account("8888", "3002", "CHK", 700.00);
        
        // Add the new lists to the accounts
        alist.addAcc(a);
        alist.addAcc(b);
        
        // Display the List
        alist.displayList();
    }
}
