package com.SEALS.customer;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.SEALS.film.Film;
import com.SEALS.film.FilmDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
//@WebServlet(urlPatterns = {"/CustController"})
public class CustController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String ADD_TO_CART = "/myMovies.jsp";
    private static String CUST_HOME =  "/custActionPage.jsp";
    private static String CUST_SEARCH_RESULT =  "/custSearchResultPage.jsp";

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
        Cust cust = new Cust();
        //when the user goes to search something it forwards to the search page, and send the list of actors to that page
        if (action.equalsIgnoreCase("search"))
        {
            forward = "custSearch.jsp";
            List<Actor> actors = dao.getAllActors();
            request.setAttribute("actors", dao.getAllActors());
            List<Category> categories = dao.getAllCategories();
            request.setAttribute("categories", dao.getAllCategories());
        }
        else if(action.equals("TestAddToCart")){
            forward = ADD_TO_CART;
            int customer_id = Integer.parseInt(request.getParameter("customer_id"));
            cust.setCustomer_id(customer_id);
            request.setAttribute("custBean", cust);  
        }
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
        CustDAO custdao = new CustDAO();
        FilmDAO filmdao = new FilmDAO();
        String action = request.getParameter("action");
        //if the user has decided on a search function and has clicked search
        if (action.equalsIgnoreCase("searchResults"))
        {
            //initializes values to empty
            String cat_name = "";
            String act_name = "";
            int store_id = 1;
            //if they selected a category set the name to their selection
            if (request.getParameter("categories") != null)
            {
                cat_name = request.getParameter("categories");
            }
            //if they selected an actor set the name to their selection
            else if (request.getParameter("actorsFullName") != null)
            {
                act_name = request.getParameter("actorsFullName");
            }
        }
        //if the user searched by multiple results 
        else if(action.equals("searchMultiples")){
            String actor = request.getParameter("actorsFullName");
            String category = request.getParameter("categories");
            List<Film> films = custdao.getAllSearchedFilms(category, actor, 1);
            request.setAttribute("films", films);
            forward = CUST_SEARCH_RESULT;
        }
        //registers the customer in both the customer table AND address table
        else if (action.equalsIgnoreCase("custRegister"))
        {
            forward = CUST_HOME;
            
            //sets initial needed values
            Cust cust = new Cust();
            Address custAddress = new Address();
            //for now is just set to true no matter what
            boolean active = true;
            
            //sets the rest of the needed information
            int store_id = Integer.parseInt(request.getParameter("store_id"));
            String first_name = request.getParameter("first_name");
            String last_name = request.getParameter("last_name");
            String email = request.getParameter("email");
            //String address_id = null;
            String address = request.getParameter("address"); //for the address table
            String address2 = request.getParameter("address2"); //for address table
            String district = request.getParameter("district"); //for address table
            String postal_code = request.getParameter("postal_code"); //for address table
            Date create_date = null;
            try { create_date = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("create_date"));
            } catch (ParseException e){
                e.printStackTrace();
            }
            String phone = request.getParameter("phone");
            //need help with this
//            if(custCheckBox.isChecked()){
//            } else {
//                active = false;
//            }
            String username = request.getParameter("username");
            String password = request.getParameter("password"); 
            
            //adds in the address
            //custAddress.setAddress_id(Integer.parseInt(address_id));
            custAddress.setAddress(address);
            custAddress.setAddress2(address2);
            custAddress.setDistrict(district);
            custAddress.setCity_id(100);    //we dont know how this is determined so just made it up
            custAddress.setPostal_code(postal_code);
            custAddress.setPhone(phone);
            //skipped location
            custAddress.setLast_update(create_date);
            custdao.addCustAddress(custAddress);
            
            //gets the address id of the address that was just saved into the database
            int add_id = custdao.lastCustAddressID(custAddress);
            
            //adds in the customer
            cust.setStore_id(store_id);
            cust.setFirst_name(first_name);
            cust.setLast_name(last_name);
            cust.setEmail(email);
            cust.setAddress_id(add_id);
            cust.setActive(active);
            cust.setCreate_date(new java.sql.Date(create_date.getTime()));
            cust.setLast_update(new java.sql.Date(create_date.getTime()));
            cust.setUsername(username);
            cust.setPassword(password);
            custdao.addCust(cust);
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
