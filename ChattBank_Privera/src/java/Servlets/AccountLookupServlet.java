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

/*************************************************
    Document   : index
    Created on : Sep 26, 2020, 10:32:18 AM
    Author     : Patricia Rivera
    * I wrote this code
**************************************************/

@WebServlet(name = "AccountLookupServlet", urlPatterns = {"/AccountLookupServlet"})
public class AccountLookupServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        /*** Get info from Textboxes in accountLookup.jsp **/
        String acctNo, custID, type, balance;
        acctNo = request.getParameter("AcctNo");
        custID = request.getParameter("CustID");
        type = request.getParameter("type");
        balance = request.getParameter("balance");
        
        /** Info from LoginServlet **/
        String cust_id = (String)request.getAttribute("cust_id");
        String cust_pass = (String)request.getAttribute("cust_pass");
        
        System.out.println(cust_id);
        
        /****** Open The Account / Customer Business Object **********/
        Account a1 = new Account();
        
        /******* Find the account info *********/
        a1.selectDB(acctNo);
        
        /***** Display ************/
        System.out.println("*****************************");
        a1.display();
        System.out.println("*****************************");
        
        /*** Put Account Object in session ***/
        HttpSession ses2;
        
        ses2 = request.getSession();
        
        ses2.setAttribute("a1", a1);
        
        if(acctNo == ""){
            /*** Forward to DisplayAccount.jsp ***/
            RequestDispatcher rd = request.getRequestDispatcher("noAccounts.jsp");

            rd.forward(request, response);
        }
        else{
            /*** Forward to DisplayAccount.jsp ***/
            RequestDispatcher rd = request.getRequestDispatcher("DisplayAccounts.jsp");

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
