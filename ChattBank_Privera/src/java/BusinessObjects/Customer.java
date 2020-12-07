package BusinessObjects;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/************************************************
    Document   : index
    Created on : Sep 26, 2020, 10:32:18 AM
    Author     : Patricia Rivera
    I wrote this code
************************************************/
public class Customer {
    	// ********************************** Properties ********************************** 
	private String custId;
	private String custPassword;
	private String custFirstName;
	private String custLastName;
	private String custAddress;
	private String custEmail;
        
        public AccountList blist = new AccountList();

    	// ********************************** Constructors ********************************** 
	
	public Customer(){
		custId = "";
		custPassword = "";
		custFirstName = "";
		custLastName = "";
		custAddress = "";
		custEmail = "";
	}
	
	public Customer(String id, String pass, String fn, String ln, String address, String email){
		this.custId = id;
		this.custPassword = pass;
		this.custFirstName = fn;
		this.custLastName = ln;
		this.custAddress = address;
		this.custEmail = email;
	}
        
        // ********************************** Setter/Getter ********************************** 
        
        // Set & get custId
        public void setCustID(String id){
            this.custId = id;
        }
        
        public String getCustID(){
            return this.custId;
        }
        
        // Set & get custPassword
        public void setCustPassword(String pass){
            this.custPassword = pass;
        }
        
        public String getCustPassword(){
            return this.custPassword;
        }
        
        // Set & get custFirstName
        public void setCustFirstName(String fn){
            this.custFirstName = fn;
        }
        
        public String getCustFirstName(){
            return this.custFirstName;
        }
        
        // Set & get custLastName
        public void setCustLastName(String ln){
            this.custLastName = ln;
        }
        
        public String getCustLastName(){
            return this.custLastName;
        }
        
        // Set & get custAddress
        public void setCustAddress(String address){
            this.custAddress = address;
        }
        
        public String getCustAddress(){
            return this.custAddress;
        }
        
        // Set & get custEmail
        public void setCustEmail(String email){
            this.custEmail = email;
        }
        
        public String getCustEmail(){
            return this.custEmail;
        }
	
        // ********************************** Database Behaviors ********************************** 
        
	public void selectDB(String id){
            try {
                // Set custId
                setCustID(id);
                
		//Load DB Driver
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection c1 = DriverManager.getConnection("jdbc:ucanaccess://" +
                        "C:\\Users\\HP\\Desktop\\ChattBank_Privera\\build\\web\\WEB-INF\\classes\\database\\ChattBankMDB.mdb");
                
                //Create SQL Statement
                String sql = "Select * from Customers where CustID = " + getCustID();
                
                //Execute Statement
                Statement stmt = c1.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                
                // Run Statement
                rs.next();
                
                // Set information
                setCustID(rs.getString(1));
                setCustPassword(rs.getString(2));
                setCustFirstName(rs.getString(3));
                setCustLastName(rs.getString(4));
                setCustAddress(rs.getString(5));
                setCustEmail(rs.getString(6));
                
                c1.close();
                
                getAccounts();
                
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            }

	}
        
        /***************** Add Accounts to a List *************************/
        public void getAccounts(){
            try {
                //Load DB Driver
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection c2 = DriverManager.getConnection("jdbc:ucanaccess://" +
                        "C:\\Users\\HP\\Desktop\\ChattBank_Privera\\build\\web\\WEB-INF\\classes\\database\\ChattBankMDB.mdb");

                //Create SQL Statement
                String sql = "Select AcctNo from Accounts where Cid = " + getCustID();
                
                //Execute SQL Statement
                Statement stmt = c2.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                
                // New Properties
                String an;
                Account a1;
                
                while(rs.next()){
                    an = rs.getString(1);
                    a1 = new Account();
                    a1.selectDB(an);
                    blist.addAcc(a1);        
                }
                
                c2.close();
                
                
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
	
	public void insertDB(String id, String pass, String fn, String ln, String address, String email){
            try {
                
                // Set All the values
                setCustID(id);
                setCustPassword(pass);
                setCustFirstName(fn);
                setCustLastName(ln);
                setCustAddress(address);
                setCustEmail(email);
                
                //Load DB Driver
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection c3 = DriverManager.getConnection("jdbc:ucanaccess://" +
                        "C:\\Users\\HP\\Desktop\\4th Semester\\Java 3\\Week 4\\Objects\\database\\ChattBankMDB.mdb");
                
                // Execute SQL Statement
                Statement stmt = c3.createStatement();
                
                String sql = "Insert into Customers values('"+getCustID()+"',"+
                                                        "'"+getCustPassword()+"',"+ 
                                                        "'"+getCustFirstName()+"',"+ 
                                                        "'"+getCustLastName()+"',"+ 
                                                        "'"+getCustAddress()+"',"+ 
                                                        "'"+getCustEmail()+"')";
                
                int n1 = stmt.executeUpdate(sql);
                if(n1 == 1){
                    System.out.println("Update Successfull!");
                }
                else{
                    System.out.println("Update failed!");
                }
                c3.close();
                
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
	
        public void deleteDB(){
            try {
                //Load DB Driver
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection c4 = DriverManager.getConnection("jdbc:ucanaccess://" +
                        "C:\\Users\\HP\\Desktop\\ChattBank_Privera\\build\\web\\WEB-INF\\classes\\database\\ChattBankMDB.mdb");
                
                //Execute SQL Statement
                Statement stmt = c4.createStatement();
                String sql = " Delete from Customers where CustID = " + getCustID();
                
                System.out.println(sql);
                
                int n = stmt.executeUpdate(sql);
                
                if (n==1)
                    System.out.println("Delete Successful!");
                else
                    System.out.println("Delete failed!");
                c4.close();
                
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        // ********************************** Testing ********************************** 
        
	public void display(){
            System.out.println("====================================");
            System.out.println("ID: " + getCustID());
            System.out.println("Password " + getCustPassword());
            System.out.println("First Name: " + getCustFirstName());
            System.out.println("Last Name: " + getCustLastName());
            System.out.println("Address: " + getCustAddress());
            System.out.println("Email: " + getCustEmail());
            System.out.println("====================================");
            
            blist.displayList();
	}
	
	public static void main(String[] args){
		
            // Test selectDB(); method
            Customer c1 = new Customer(); // Creates empty Customer Object

            c1.selectDB("3001"); // Does the Database lookup to find customer

            c1.display(); // Display the information
            
	}
}
