/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SEALS.cart;

import com.SEALS.storedproc.*;
import java.sql.*;
import com.SEALS.login.*;
import com.SEALS.admin.Admin;
import com.SEALS.customer.Cust;
import com.SEALS.film.Film;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.derby.client.am.Decimal;

/**
 *
 * @author Austin
 */
//@WebServlet(name = "loginController", urlPatterns =
//{
//    "/loginController"
//})
public class cartController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String ADMIN_HOME = "/adminActionPage.jsp";
    private static String CUST_HOME = "/custActionPage.jsp";

    private static String CUST_CHECK_OUT = "/custCheckOutPage.jsp";
    private loginDAO dao = new loginDAO();

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
            throws ServletException, IOException {
        String forward = "";

        cartDAO cart = new cartDAO();

        String action = request.getParameter("action");

        if (action.equals("addCart")) {
            String title = request.getParameter("title");
            String x = request.getParameter("film_id");
            int film_id = Integer.parseInt(request.getParameter("film_id"));
            float price = Float.parseFloat(request.getParameter("price"));
            int rental_duration = Integer.parseInt(request.getParameter("rental_duration"));

            cart.addCart(title, film_id, price, rental_duration);
            forward = CUST_HOME;
        } else if (action.equals("addWishList")) {
            String title = request.getParameter("title");
            String x = request.getParameter("film_id");
            int film_id = Integer.parseInt(request.getParameter("film_id"));
            float price = Float.parseFloat(request.getParameter("price"));
            int rental_duration = Integer.parseInt(request.getParameter("rental_duration"));

            cart.addWish(title, film_id, price, rental_duration);
            forward = CUST_HOME;
        }
  
        else if(action.equals("checkOutCart")){
            List<Cart> carts = cart.ListCart(Cust.customerID);
            forward = CUST_CHECK_OUT;
            request.setAttribute("carts", carts);
        }
        else if(action.equals("removeCartItem")){
       
            int cartID = Integer.parseInt(request.getParameter("cart_id"));
            cart.removeCart(cartID);
            List<Cart> carts = cart.ListCart(Cust.customerID);
            forward = CUST_CHECK_OUT;
            request.setAttribute("carts", carts);
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);

        view.forward(request, response);
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
        String forward = "";
        Admin admin = new Admin();
        Cust customer = new Cust();
        Film film = new Film();
        cartDAO cartdao = new cartDAO();

        // String action = request.getParameter("action");
        // String passKey = request.getParameter("passKey");
        // String forward="";
        String action = request.getParameter("action");

        if (action.equals("addToCart")) {
            int film_id = Integer.parseInt(request.getParameter("film_id"));
            int customer_id = Integer.parseInt(request.getParameter("customer_id"));
            cartdao.addToCart(film_id, customer_id);
            forward = "myMovies.jsp";
            Cust.customerID = customer_id;
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
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
