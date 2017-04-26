package com.SEALS.film;

import com.SEALS.customer.Cust;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;
import java.text.ParseException;
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
public class FilmController extends HttpServlet
{
   
    private static final long serialVersionUID = 1L;
    //  private static final String MYMOVIES = "/myMovies.jsp";
    //  private static String RESPONSE = "/response.jsp";
    FilmDAO dao;

    
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
        dao = new FilmDAO();
        String forward = "/adminMovieUpdate.jsp";
        Film film = new Film();
        Cust customer = new Cust();

         String action = request.getParameter("action");
        // String user = request.getParameter("user");
        // based off which action is sent, either delete, update or list all products
        if (action.equals("delete"))
        {
            int filmId = Integer.parseInt(request.getParameter("filmId"));
            dao.deleteFilm(filmId);
            forward = "/adminMovie.jsp";
            request.setAttribute("films", dao.getAllFilms());
        }
        if (action.equals("edit")){
            forward = "/adminMovieUpdate.jsp";
            int filmId = Integer.parseInt(request.getParameter("filmId"));
            film = dao.getFilmById(filmId);
            request.setAttribute("film", film);
        }
        if (action.equals("list"))
        {
            forward = "/adminMovie.jsp";
            //List<Film> films = dao.getAllFilms();
            request.setAttribute("films", dao.getAllFilms());
        }
//        if (action.equalsIgnoreCase("userFilms"))
//        {
//            //needs to provide the customerID
//            request.setAttribute("CRfilms", dao.currentlyRentedFilms());
//            request.setAttribute("WLfilms", dao.customerWishListItems());
//            request.setAttribute("PRfilms", dao.previouslyRentedFilms());
//        }
//        if (action.equalsIgnoreCase("deleteWishItem"))
//        {
//            
//        }
//        if (action.equalsIgnoreCase("returnFilm"))
//        {
//            //code that Lauren is working on
//        }
        
        
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
        dao = new FilmDAO();
       
        RequestDispatcher view;
       
        view = request.getRequestDispatcher("/adminMovie.jsp");
        
        request.setAttribute("films", dao.getAllFilms());
        
        view.forward(request, response);
    }
}
