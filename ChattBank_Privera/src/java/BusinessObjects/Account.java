package BusinessObjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*************************************************
    Document   : Account Business Object
    Created on : Sep 11, 2020
    Author     : Patricia Rivera
    * I wrote this code
**************************************************/

public class Account {
    // ********************************** Properties ********************************** 
    private String acctNo;
    private String custId;
    private String type;
    private double balance;
    
    // ********************************** Constructors ********************************** 
    public Account(){
        this.acctNo = "";
        this.custId = "";
        this.type = "";
        this.balance = 0.0;
    }
    
    public Account(String acc, String id, String type, double bal){
        this.acctNo = acc;
        this.custId = id;
        this.type = type;
        this.balance = bal;
    }
    
    // ********************************** Setter/Getter ********************************** 
    
    // Set & get acctNo
    public void setAcctNo(String acc){
        this.acctNo = acc;
    }
    
    public String getAcctNo(){
        return this.acctNo;
    }
    
    // Set & get custId
    public void setCustId(String id){
        this.custId = id;
    }
    
    public String getCustId(){
        return this.custId;
    }
    
    // Set & get type
    public void setType(String type){
        this.type = type;
    }
    
    public String getType(){
        return this.type;
    }
    
    // Set & get balance
    public void setBalance(double balance){
        this.balance = balance;
    }
    
    public double getBalance(){
        return this.balance;
    }
    
    // ********************************** Database Behaviors ********************************** 
    public void selectDB(String acctN){
        try {
            // Set custId
            setAcctNo(acctN);

            //Load DB Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection c1 = DriverManager.getConnection("jdbc:ucanaccess://" +
                    "C:\\Users\\HP\\Desktop\\ChattBank_Privera\\build\\web\\WEB-INF\\classes\\database\\ChattBankMDB.mdb");

            //Create SQL Statement
            String sql = "Select * from Accounts where AcctNo = " + getAcctNo();

            //Execute Statement
            Statement stmt = c1.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Run Statement
            rs.next();
            setAcctNo(rs.getString(1));
            setCustId(rs.getString(2));
            setType(rs.getString(3));
            setBalance(rs.getDouble(4));

            System.out.println(rs.getString(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
            System.out.println(rs.getString(4));

            c1.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void selectCidDB(String custID){
        try {
            // Set custId
            setCustId(custID);

            //Load DB Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection c1 = DriverManager.getConnection("jdbc:ucanaccess://" +
                    "C:\\Users\\HP\\Desktop\\ChattBank_Privera\\build\\web\\WEB-INF\\classes\\database\\ChattBankMDB.mdb");

            //Create SQL Statement
            String sql = "Select * from Accounts where Cid = " + getCustId();

            //Execute Statement
            Statement stmt = c1.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Run Statement
            rs.next();
            setAcctNo(rs.getString(1));
            setCustId(rs.getString(2));
            setType(rs.getString(3));
            setBalance(rs.getDouble(4));
            
            c1.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        
    public void insertDB(String acc, String id, String type, double bal){
        try {

            // Set All the values
            setAcctNo(acc);
            setCustId(id);
            setType(type);
            setBalance(bal);

            //Load DB Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection c1 = DriverManager.getConnection("jdbc:ucanaccess://" +
                    "C:\\Users\\HP\\Desktop\\4th Semester\\Java 3\\Week 4\\Objects\\database\\ChattBankMDB.mdb");

            // Execute SQL Statement
            Statement stmt = c1.createStatement();

            String sql = "Insert into Accounts values('"+getAcctNo()+"',"+
                                                    "'"+getCustId()+"',"+ 
                                                    "'"+getType()+"',"+
                                                    "'"+getBalance()+"')";

            int n1 = stmt.executeUpdate(sql);
            if(n1 == 1){
                System.out.println("Update Successfull!");
            }
            else{
                System.out.println("Update failed!");
            }
            c1.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteDB(){
        try {
            //Load DB Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection c1 = DriverManager.getConnection("jdbc:ucanaccess://" +
                    "C:\\Users\\HP\\Desktop\\ChattBank_Privera\\build\\web\\WEB-INF\\classes\\database\\ChattBankMDB.mdb");

            //Execute SQL Statement
            Statement stmt = c1.createStatement();
            String sql = " Delete from Accounts where AcctNo = " + getAcctNo();

            System.out.println(sql);

            int n = stmt.executeUpdate(sql);

            if (n==1)
                System.out.println("Delete Successful!");
            else
                System.out.println("Delete failed!");
            c1.close();

        } catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        
        
    // ********************************** Testing ********************************** 

    public void display(){
            System.out.println("**********************************");
            System.out.println("ID: " + this.custId);
            System.out.println("Type: " + this.type);
            System.out.println("Balance: " + this.balance);
            System.out.println("**********************************");
    }

    public static void main(String[] args){

        // Test selectDB(); method
        Account a1 = new Account(); // Creates Empty Account Object

        a1.selectDB("90000"); // Calls selectDB() method

        a1.display(); // Displays the information

    }
}
