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
    private static String PAYMENT = "/paymentPage.jsp";
    private static String REPAYMENT = "/paymentPageRedo.jsp";

    private static String CUST_CHECK_OUT = "/custCheckOutPage.jsp";
    
    private static String CUST_CHECK_OUT_REDO = "/custCheckOutPageREDO.jsp";

    private static String CUST_RECEIPT = "/custReceipt.jsp";

    private cartDAO dao = new cartDAO();

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
        } else if (action.equals("checkOutCart")) {
            List<Cart> carts = cart.ListCart(Cust.customerID);
            forward = CUST_CHECK_OUT;
            request.setAttribute("carts", carts);
        } else if (action.equals("removeCartItem")) {

            int cartID = Integer.parseInt(request.getParameter("cart_id"));
            cart.removeCart(cartID);
            List<Cart> carts = cart.ListCart(Cust.customerID);
            forward = CUST_CHECK_OUT;
            request.setAttribute("carts", carts);
        } else if (action.equals("payment")) {
            //do the checkout actions
            //PAYMENt
            
            //check to see if they have more than 5 dvds already checked out
            //if 
            int rentalNum = dao.checkCheckedOut();
            int cartNum = dao.checkCartCount();
                    
            int x = rentalNum + cartNum;
            
            if (x > 5){
                  List<Cart> carts = cart.ListCart(Cust.customerID);
          //  forward = CUST_CHECK_OUT;
            request.setAttribute("carts", carts);
                forward = CUST_CHECK_OUT_REDO;
            }
            
            else {
                forward = PAYMENT; 
            }

        } else if (action.equals("paymentValidation")) {
            boolean isValid = false;
            String ccnum = request.getParameter("username");
            isValid = validatePayment(ccnum);
            if (isValid == true) {
                forward = CUST_RECEIPT;
                cart.checkOut();

            } else {
                forward = REPAYMENT;
            }
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);

        view.forward(request, response);

        processRequest(request, response);

    }

    public static boolean validatePayment(String cardNumber) {
        //Scanner input = new Scanner (System.in);

        //long CCNumber = Long.parseLong(cardNumber);
        String y = cardNumber;
        long CCNumber = Long.parseLong(cardNumber);
        int length = 0;
        int even = 0;
        int odd = 0;

        //CCNumber = input.nextLong();
        boolean isValid = false;
        //length = checkLength(CCNumber);

       // checkStartNumbers(CCNumber);

        even = sumDoubleSecondDigits(CCNumber);

        odd = sumOddDigits(CCNumber);

        int totalSum = even + odd;
        //checkValidity(totalSum);
       // int yes = 0;
        //This checks if the credit card number given fits all the criteria
        if (checkValidity(totalSum) == true && checkStartNumbers(CCNumber) == 0) {
            isValid = true;
        } else {
            isValid = false;
        }
        return isValid;
    }

    //I first check the length of the credit card number for validity
    public static int checkLength(long CCNumber) {
        int length = 0;
        while (CCNumber > 1) {
            CCNumber = CCNumber / 10;
            length++;
        }
        return length;
    }

    //Here I check the starting number of the credit card for validity
    public static int checkStartNumbers(long CCNumber) {
        int yes = 0;
        int no = 0;
        long whatItWas = 0;
        while (CCNumber > 0) {
            
            if (CCNumber == 37 || CCNumber == 4 || CCNumber == 5 || CCNumber == 6) {
                yes = 0;
                whatItWas = CCNumber;
            } else {
                if(whatItWas != 37){
                yes = -1;
                }
            }
            CCNumber = CCNumber / 10;
        }
        return yes;
    }

    //Here I add all the even digits from the right
    public static int sumDoubleSecondDigits(long CCNumber) {
        int sum = 0;
        CCNumber = CCNumber / 10;
        while (CCNumber != 0) {
            sum = sum + getDigit((int) (CCNumber % 10) * 2);
            CCNumber = CCNumber / 100;
        }
        return sum;
    }

    //Here I add all the odd digits from the right
    public static int sumOddDigits(long CCNumber) {
        int sum = 0;
        while (CCNumber != 0) {
            sum = sum + (int) (CCNumber % 10);
            CCNumber = CCNumber / 100;
        }
        return sum;
    }

    //Here is where I determine the individual digits of the credit card number
    public static int getDigit(int digit) {
        if (digit <= 9) {
            return digit;
        } else if (digit > 9) {
            return (digit % 10 + digit / 10);
        }
        return digit;
        //why do we need another return statement?
    }

    //This is where I check the results of dividing the sum of the odd and even numbers
    public static boolean checkValidity(int totalSum) {
        if (totalSum % 10 == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    
    
    //}

    // }
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
