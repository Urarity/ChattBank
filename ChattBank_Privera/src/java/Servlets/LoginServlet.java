package Servlets;




import BusinessObjects.Account;
import BusinessObjects.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*********************************************
    Document   : LoginServlet
    Created on : August 4, 2020 
    Author     : Patricia Rivera
    I wrote this code
**********************************************/

@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        /*** Get info from Textboxes **/
        String cust_id, cust_pass;
        cust_id = request.getParameter("customerID");
        cust_pass = request.getParameter("pass");
            
        /*** Printing out the info ***/
        System.out.println("****************************");
        System.out.println("ID = " + cust_id);
        
        System.out.println("Password = " + cust_pass);
        System.out.println("****************************");
        
        /*** Call the Customer / Account Object **/
        Customer c1 = new Customer();
        Account a1 = new Account();
        
        /** Find the database **/
        c1.selectDB(cust_id);
        a1.selectCidDB(cust_id);
        
        /** Get the password from the database **/
        String data_pass = c1.getCustPassword();
        
        System.out.println(data_pass);
        
        /*** Put Customer Object in session ***/
        HttpSession ses1;
        
        ses1 = request.getSession();
        
        ses1.setAttribute("c1", c1);
        ses1.setAttribute("a1", a1);
        
        /** If cust_pass equals the password from the database searched up)**/
        if (cust_pass.equals(data_pass)){
            /** Prints in Console Valid Login **/
            System.out.println("Valid Login");
            
            /** Transfer the cust_id and cust_pass variable to the page **/
            request.setAttribute("custID",cust_id);
            request.setAttribute("custPass",cust_pass);
            
            /** Redirects to the accountLookup page **/
            RequestDispatcher rd = request.getRequestDispatcher("accountLookup.jsp");
            
            rd.forward(request, response);
            
        }
        else {
            /** Prints in Console InValid Login **/
            System.out.println("InValid Login");
            
            /** Redirects to the ErrorPage **/
            RequestDispatcher rd = request.getRequestDispatcher("LoginError.jsp");
            
            rd.forward(request, response);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
