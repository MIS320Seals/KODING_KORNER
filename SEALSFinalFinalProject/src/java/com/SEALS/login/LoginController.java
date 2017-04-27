package com.SEALS.login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.SEALS.admin.Admin;
import com.SEALS.customer.Country;
import com.SEALS.customer.Cust;
import com.SEALS.customer.CustDAO;
import com.SEALS.film.Film;
import com.SEALS.film.FilmDAO;
import com.SEALS.film.Rental;
import com.SEALS.film.RentalDAO;
import com.SEALS.login.loginDAO;
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
    private static String CUST_REGISTER = "/custRegisterPage.jsp";
    private static String MY_MOVIES = "/myMovies.jsp";
    //Cust cust = new Cust();
    
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
        String forward = "";
        
        CustDAO custdao = new CustDAO(); 
        FilmDAO filmdao = new FilmDAO();
        String action = request.getParameter("action");
        RentalDAO dao = new RentalDAO();
        if(action.equalsIgnoreCase("returnHome"))
        {
            List<Film> films = custdao.getStaffMovies();
            request.setAttribute("films", films);
            forward = CUST_HOME;
        }
        //fills out the three tables on the movies page
        else if (action.equalsIgnoreCase("userFilms"))
        {
            //needs to provide the customerID
//            List<Film> currentlyRentedFilms = filmdao.currentlyRentedFilms(Cust.customerID);
//            request.setAttribute("CRfilms", currentlyRentedFilms);     //code being done by lauren
            request.setAttribute("returns", dao.getCurrentRentals());
            List<Film> wishListFilms = filmdao.customerWishListItems(Cust.customerID);
            request.setAttribute("WLfilms", wishListFilms);
            List<Rental> previouslyRentedFilms = filmdao.previouslyRentedFilms(Cust.customerID);
            request.setAttribute("PRfilms", previouslyRentedFilms);    //need to create a whole new table for this, should see if people still want to do this or nah
            forward = MY_MOVIES; 
        }
        //deletes the item from the wishlist
        else if (action.equalsIgnoreCase("deleteWishItem"))
        {
            int film_id = Integer.parseInt(request.getParameter("film_id"));
            filmdao.removeFromWishlist(Cust.customerID, film_id);
            request.setAttribute("returns", dao.getCurrentRentals());
            List<Film> wishListFilms = filmdao.customerWishListItems(Cust.customerID);
            request.setAttribute("WLfilms", wishListFilms);
            List<Rental> previouslyRentedFilms = filmdao.previouslyRentedFilms(Cust.customerID);
            request.setAttribute("PRfilms", previouslyRentedFilms);    //need to create a whole new table for this, should see if people still want to do this or nah
            forward = MY_MOVIES; 
        }
        //will return a film so it so no longer currently rented
        else if (action.equalsIgnoreCase("returnFilm"))
        {
            //code that Lauren is working on
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
            throws ServletException, IOException
    {
        String forward = "";
        Admin admin = new Admin();
        Cust customer = new Cust();

        loginDAO dao = new loginDAO();
        CustDAO custdao = new CustDAO(); 

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
                forward = ADMIN_HOME; //have to add LoginController=? for the home action 
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
                List<Film> films = custdao.getStaffMovies();
                request.setAttribute("films", films);
                forward = CUST_HOME;
                Cust.customerID = customer.getCustomer_id();
            }
            else{
                forward = CUST_RELOGIN;//check customer
            }
        }
        else if(action.equalsIgnoreCase("returnHome"))
        {
            List<Film> films = custdao.getStaffMovies();
            request.setAttribute("films", films);
            forward = CUST_HOME;
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
