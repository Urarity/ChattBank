package Servlets;




import BusinessObjects.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/****************************************
*
*   Patricia Rivera
*
*   LoginServlettDB
*
*   I wrote this code myself...
*
*****************************************/

@WebServlet(urlPatterns = {"/LoginServletDB"})
public class LoginServletDB extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        /** Get the info from the TextBoxes **/
        String cust_id, cust_pass;
        cust_id = request.getParameter("customerID");
        cust_pass = request.getParameter("pass");

        Customer c1 = new Customer(); // Make an empty object

        c1.selectDB(cust_id); // Find the information in the Database

        String pwd = c1.getCustPassword(); // Get the Password
        
        // Check if the Password is the same
        if (cust_pass.equals(pwd)){
            System.out.println("Valid Login");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServletDB</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Valid Login </h1>");
            out.println("</body>");
            out.println("</html>");
        }
        else {
            System.out.println("InValid Login");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServletDB</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> InValid Login </h1>");
            out.println("</body>");
            out.println("</html>");
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
