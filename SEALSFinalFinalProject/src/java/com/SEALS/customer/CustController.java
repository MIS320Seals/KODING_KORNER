package com.SEALS.customer;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ering
 */
@WebServlet(urlPatterns = {"/CustController"})
public class CustController extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CustController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CustController at " + request.getContextPath() + "</h1>");
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
        CustDAO dao = new CustDAO();
        String forward = "";
        String action = request.getParameter("action");
        
        //when the user goes to search something it forwards to the search page, and send the list of actors to that page
        if (action.equalsIgnoreCase("search"))
        {
            forward = "custSearch.jsp";
            List<Actor> actors = dao.getAllActors();
            request.setAttribute("actors", dao.getAllActors());
            List<Category> categories = dao.getAllCategories();
            request.setAttribute("categories", dao.getAllCategories());
        }
//        if (action.equalsIgnoreCase("searchResults"))
//        {
//            forward = "custSearchResultPage.jsp";
//            
//        }
        //fowards it to the specific page
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
        //processRequest(request, response);
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
        CustDAO dao = new CustDAO();
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("searchResults"))
        {
            String cat_name = "";
            String act_name = "";
            int store_id = 1;
            if (request.getParameter("categories") != null)
            {
                cat_name = request.getParameter("categories");
            }
            else if (request.getParameter("actorsFullName") != null)
            {
                act_name = request.getParameter("actorsFullName");
            }
        }
        //processRequest(request, response);
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
