package com.SEALS.film;

import static com.SEALS.cart.cartController.validatePayment;
import com.SEALS.customer.Cust;
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
public class RentalController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String PAYMENT_PAGE_LATE_FEE = "/paymentPageLateFee.jsp";
    private static final String PAYMENT_PAGE_LATE_FEE_REDO = "/paymentPageLateFeeRedo.jsp";
        private static String PAYMENT_LATE_FEE = "/paymentPageLateFee.jsp";
    private static String PAYMENT_LATE_FEE_REDO = "/paymentPageLateFeeRedo.jsp";
    private static String CUST_CHECK_OUT_REDO = "/custCheckOutPageREDO.jsp";
    private static String CUST_RECEIPT = "/custReceipt.jsp";
    private static String RETURNS = "/returnsDisplay.jsp";
    private static String MY_MOVIES = "/myMovies.jsp";
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
            throws ServletException, IOException {
        dao = new RentalDAO();
        String forward = "/adminMovieUpdate.jsp";
        Rental rental = new Rental();

        RentalDAO dao = new RentalDAO();
        String action = request.getParameter("action");
        List<Rental> rentals = new ArrayList<>();
        // String user = request.getParameter("user");
        // based off which action is sent, either delete, update or list all products

        if (action.equals("displayReturns")) {
            request.setAttribute("returns", dao.getCurrentRentals());
            forward = "/returnsDisplay.jsp";
        } else if (action.equals("returnItem")) {

            int returnID = Integer.parseInt(request.getParameter("rentalID"));
            rental.setRentalID(returnID);
            double price = Double.parseDouble(request.getParameter("rentalRate"));
            int daysLeft = Integer.parseInt(request.getParameter("daysLeft"));
            if (daysLeft < 0) {

                double lateFee = daysLeft * (-1) * (price * .2);

                rental.setLateFee((lateFee));
                //payment info

                forward = PAYMENT_PAGE_LATE_FEE;
                request.setAttribute("rental", rental);

            } else {
               dao.returnMovie(Integer.parseInt(request.getParameter("rentalID")));
               //request.setAttribute("returns", dao.getCurrentRentals());
               //forward = RETURNS;
               FilmDAO filmdao = new FilmDAO();
               request.setAttribute("returns", dao.getCurrentRentals());
               List<Film> wishListFilms = filmdao.customerWishListItems(Cust.customerID);
               request.setAttribute("WLfilms", wishListFilms);
               List<Rental> previouslyRentedFilms = filmdao.previouslyRentedFilms(Cust.customerID);
               request.setAttribute("PRfilms", previouslyRentedFilms);    //need to create a whole new table for this, should see if people still want to do this or nah
               forward = MY_MOVIES;
            }

        }
        else if (action.equals("paymentLateFeeValidation")){
            
            boolean isValid = false;
            String ccnum = request.getParameter("username");
            int rentalID = Integer.parseInt(request.getParameter("rentalID"));
            isValid = validatePayment(ccnum);
            if (isValid == true) {
                forward = RETURNS;
                
                dao.returnMovie(rentalID);
                request.setAttribute("returns", dao.getCurrentRentals());
 
            } else {
                forward = PAYMENT_LATE_FEE_REDO;
            }
        }
        //fowards it to the specific page
        RequestDispatcher view = request.getRequestDispatcher(forward);

        view.forward(request, response);
    
    }

    /**
     * DOPOST METHOD
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
    

