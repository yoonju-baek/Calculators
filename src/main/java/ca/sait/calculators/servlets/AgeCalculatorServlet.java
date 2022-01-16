package ca.sait.calculators.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 * Determines the next age of the person.
 * @author Yoonju Baek
 */
public class AgeCalculatorServlet extends HttpServlet {

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
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
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
        
        String msg = "";
        String ageInput = request.getParameter("age");

        if(!ageInput.isEmpty()) {
            try {
                int age = Integer.parseInt(ageInput);
        
                age++;
        
                msg = String.format("Your age next birthday will be %d.", age);
                
            }
            catch(Exception ex) {
                msg = "You must enter a number.";
            }
        }
        else {
            msg = "You must give your current age.";
        }

        request.setAttribute("msg", msg);
        
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);

    }

}
