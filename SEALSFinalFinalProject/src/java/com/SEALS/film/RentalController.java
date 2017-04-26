package com.SEALS.film;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Austin
 */
public class RentalController extends HttpServlet
{
   
    private static final long serialVersionUID = 1L;
    //  private static final String MYMOVIES = "/myMovies.jsp";
    //  private static String RESPONSE = "/response.jsp";
    RentalDAO dao;

    
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
        dao = new RentalDAO();
        String forward = "/adminMovieUpdate.jsp";
        Rental rental = new Rental();

         String action = request.getParameter("action");
         List<Rental> rentals = new ArrayList<>();
        // String user = request.getParameter("user");
        // based off which action is sent, either delete, update or list all products
        
         if (action.equals("displayReturns")){
            request.setAttribute("returns", dao.getCurrentRentals());
            forward = "/returnsDisplay.jsp";
        }
        
        
        //fowards it to the specific page
        RequestDispatcher view = request.getRequestDispatcher(forward);

        view.forward(request, response);
    }

    
    /**
     * DOPOST METHOD
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        
    }
}
