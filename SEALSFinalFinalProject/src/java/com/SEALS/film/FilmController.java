package com.SEALS.film;

import java.io.IOException;
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
    private static final String MYMOVIES = "/myMovies.jsp";
    //  private static String RESPONSE = "/response.jsp";
    private FilmDAO dao;

    public FilmController()
    {
        super();
        dao = new FilmDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String forward = "";

        String action = request.getParameter("action");
        // String user = request.getParameter("user");
        // based off which action is sent, either delete, update or list all products
        if (action.equalsIgnoreCase("delete"))
        {
            int filmId = Integer.parseInt(request.getParameter("filmId"));
            dao.deleteFilm(filmId);
            forward = "adminMovie.jsp";
            request.setAttribute("films", dao.getAllFilms());
        } 
        else if (action.equalsIgnoreCase("edit")){
            
        } 
        else if (action.equalsIgnoreCase("list")){
            forward = "adminMovie.jsp";
            request.setAttribute("films", dao.getAllFilms());
        } 
        else{
            forward = "adminRegisterPage.jsp";
        }
        
        //fowards it to the specific page
        RequestDispatcher view = request.getRequestDispatcher(forward);

        view.forward(request, response);
    }

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String forward = "adminMovie.jsp";
        
        
        RequestDispatcher view = request.getRequestDispatcher(forward);

        view.forward(request, response);
    }

   

}
