package ca.sait.calculators.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 * Arithmetic Calculator
 * @author Yoonju Baek
 */
public class ArithmeticCalculatorServlet extends HttpServlet {
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
        request.setAttribute("result", "---");
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
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
        
        String result="";
        
        String firstInput= request.getParameter("first");
        String secondInput = request.getParameter("second");
        
        if(!firstInput.isEmpty() && !secondInput.isEmpty()) {
            try {
                int firstNum = Integer.parseInt(firstInput);
                int secondNum = Integer.parseInt(secondInput);
                
                if(request.getParameter("add") != null) {
                        result = Integer.toString(firstNum + secondNum); 
                }
                else if(request.getParameter("subtract") != null) {
                        result = Integer.toString(firstNum - secondNum);
                }
                else if(request.getParameter("multiply") != null) {
                        result = Integer.toString(firstNum * secondNum);
                }
                else if(request.getParameter("divide") != null) {
                        result = String.format("%.2f", (firstNum*1.0) / secondNum);
                } 
            }
            catch(Exception e) {
                result = "invalid";
            }
        }
        else {
            result = "invalid";
        }
        
        request.setAttribute("firstInput", firstInput);
        request.setAttribute("secondInput", secondInput);
        request.setAttribute("result", result);
        
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
    }
}
