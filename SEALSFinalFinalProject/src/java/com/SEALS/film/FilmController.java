package com.SEALS.film;

import java.io.IOException;
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
    private static final String MYMOVIES = "/myMovies.jsp";
    //  private static String RESPONSE = "/response.jsp";
    

    
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
        FilmDAO dao = new FilmDAO();
        String forward = "";
        Film film = new Film();

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
        else if(action.equalsIgnoreCase("edit")){
            forward = ;
            int productId = Integer.parseInt(request.getParameter("productId"));
            Film film = dao.getFilmById(filmId);
            request.setAttribute("film", film);
        }
        else if (action.equalsIgnoreCase("list"))
        {

            forward = "adminMovie.jsp";
            List<Film> films = dao.getAllFilms();
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
        FilmDAO dao = new FilmDAO();
        String forward = "adminMovie.jsp";
        
        
        RequestDispatcher view = request.getRequestDispatcher(forward);

        view.forward(request, response);
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
    }


}
