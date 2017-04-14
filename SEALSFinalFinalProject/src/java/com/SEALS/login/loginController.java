package com.SEALS.login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.SEALS.admin.Admin;

import com.SEALS.customer.Cust;
import com.SEALS.login.loginDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Austin
 */
//@WebServlet(name = "LoginController", urlPatterns =
//{
//    "/LoginController"
//})
public class LoginController extends HttpServlet
{
    
    private static final long serialVersionUID = 1L;
    private static String ADMIN_HOME = "/adminActionPage.jsp";
    private static String CUST_HOME =  "/custActionPage.jsp";

    private static String ADMIN_RELOGIN =  "/adminValidationPageError.jsp";
    private static String CUST_RELOGIN =  "/loginPageError.jsp";
    
   

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
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
            throws ServletException, IOException
    {
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
            throws ServletException, IOException
    {
        String forward = "";
        Admin admin = new Admin();
        Cust customer = new Cust();

        loginDAO dao = new loginDAO();

        // String action = request.getParameter("action");
        // String passKey = request.getParameter("passKey");
        // String forward="";
        String action = request.getParameter("action");

        //   String key = request.getParameter("passKey");
        if (action.equals("adminLogin"))
        {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            int x = dao.confirmAdminLogin(username, password);
            if(x != -1 ){
                admin = dao.getAdminLoginWID(x);
                request.setAttribute("adminBean", admin);
                forward = ADMIN_HOME;
            }
            else{
                forward= ADMIN_RELOGIN;//check customer
            }
        }
        else if(action.equals("custLogin")){
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            int x = dao.confirmCustomerLogin(username, password);
            if(x != -1 ){
                customer = dao.getCustomerWID(x);
                request.setAttribute("custBean", customer);
                forward = CUST_HOME;
                Cust.customerID = customer.getCustomer_id();
            }
            else{
                forward = CUST_RELOGIN;//check customer
            }
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);

        view.forward(request, response);
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
