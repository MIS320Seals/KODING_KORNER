package com.SEALS.film;

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
            forward = "adminMovieUpdate.jsp";
            int filmId = Integer.parseInt(request.getParameter("filmId"));
            film = dao.getFilmById(filmId);
            request.setAttribute("film", film);
        }
        else if (action.equalsIgnoreCase("list"))
        {
            forward = "adminMovie.jsp";
            List<Film> films = dao.getAllFilms();
            request.setAttribute("films", dao.getAllFilms());
        } 
        else{
            forward = "adminMovieUpdate.jsp";
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
        FilmDAO dao = new FilmDAO();
        Film f = new Film();
        String forward = "FilmController?action=list";
        
        // Title
        try{
            f.setTitle(request.getParameter("title"));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        // Description
        try{
            f.setDescription(request.getParameter("description"));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        //Release
        try{
            Date release =(Date) new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("releaseYear"));
            f.setRelease_year(release);
        }catch(ParseException ex){
            System.out.println(ex.getMessage());
        }
        
        //Rental Rate
        try{
            float rate = Float.parseFloat(request.getParameter("rentalRate"));
            f.setRental_rate(rate);
        }catch(NumberFormatException ex){
            System.out.println(ex.getMessage());
        }
        
        //Length 
        try{
            int l = Integer.parseInt(request.getParameter("length"));
            f.setLength(l);
        }catch(NumberFormatException ex){
            System.out.println(ex.getMessage());
        }
        
        //Replacement cost
        try{
            float replace = Float.parseFloat(request.getParameter("replacementCost"));
            f.setReplacement_cost(replace);
        }catch(NumberFormatException ex){
            System.out.println(ex.getMessage());
        }
        
        //Rating
        try{
            f.setRating(request.getParameter("rating"));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
       
        f.setSpecial_features("NA");
        f.setLanguage_id(1);
        f.setOriginal_language_id(1);
        
        
        Date d = new Date(Calendar.getInstance().getTime().getTime());
        f.setLast_update(d);
        
        
        String filmId = request.getParameter("filmId");
        if(filmId == null || filmId.isEmpty()){
            dao.addFilm(f);
        }else{
            f.setFilm_id(Integer.parseInt(filmId));
            dao.updateFilm(f);
        }
        
        RequestDispatcher view = request.getRequestDispatcher(forward);
        request.setAttribute("films", dao.getAllFilms());
        view.forward(request, response);
    }
}
