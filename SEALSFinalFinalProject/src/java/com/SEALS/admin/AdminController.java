package com.SEALS.admin;

import com.SEALS.customer.Address;
import com.SEALS.customer.City;
import com.SEALS.customer.Country;
import com.SEALS.customer.CustDAO;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ering
 */
//@WebServlet(urlPatterns = {"/AdminController"})
public class AdminController extends HttpServlet
{

    private static final long serialVersionUID = 1L;
    private static String REGISTER = "/adminRegisterPage.jsp";
    private static String RESPONSE = "/response.jsp";
    private static String ACTIONPAGE = "/adminActionPage.jsp";
    private static String EMPLOYEES = "/adminEmployees.jsp";
    private AdminDAO dao;

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
        dao = new AdminDAO();
        CustDAO custdao = new CustDAO(); 

        String action = "";
        if (request.getParameter("action") != null)
        {
            action = request.getParameter("action");
            
        }
        //   String key = request.getParameter("passKey");
        if (action.equalsIgnoreCase("Add New Staff Member"))
        {
            forward = REGISTER;
            List<Country> countries = custdao.getAllCountries();
            request.setAttribute("countries", custdao.getAllCountries());
        }

        //based off which action is sent, either delete, update or list all products
        else if (action.equalsIgnoreCase("delete"))
        {
            int adminId = Integer.parseInt(request.getParameter("staff_id"));
            dao.deleteAdmin(adminId);
            forward = RESPONSE;
            request.setAttribute("admins", dao.getAllAdmins());

        } else if (action.equalsIgnoreCase("edit"))
        {
            //forward = ;
            int adminId = Integer.parseInt(request.getParameter("staff_id"));
            Admin admin = dao.getAdminById(adminId);
            request.setAttribute("adminBean", admin);

        } else if (action.equalsIgnoreCase("list"))
        {

            forward = RESPONSE;
            request.setAttribute("adminBeans", dao.getAllAdmins());

        } else if (action.equals("custinfo"))
        {

            forward = "/adminCustView.jsp";
            request.setAttribute("cust", dao.getCustInfoById(request.getParameter("filmId") + ""));

        } else if (action.equals("custlist"))
        {

            forward = "/adminCustomers.jsp";
            request.setAttribute("c", dao.getAllCustomerInfo());

        } else if (action.equals("addcust"))
        {
            forward = "/custRegisterPage.jsp";
        } else if (action.equals("viewSales"))
        {
            forward = "/adminSales.jsp";
            request.setAttribute("sale", dao.getSalesByGenre());
            request.setAttribute("revenue", dao.getSalesByStore());

        } else if (action.equals("empinfo"))
        {

            forward = "/adminEmployeeView.jsp";
            //request.setAttribute("emp", dao.getAllAdmins());
            request.setAttribute("emp", dao.getAdminById(Integer.parseInt(request.getParameter("empid"))));

        } else if (action.equals("emplist"))
        {
            forward = EMPLOYEES;
            request.setAttribute("emps", dao.getAllAdmins());
        } else if (action.equals("addemp"))
        {
            forward = "/adminRegisterPage.jsp";
        } else if (action.equals("home")){
            forward = "adminActionPage.jsp";
            request.setAttribute("inStock", dao.getFilmsInStock());
           request.setAttribute("notRented", dao.getInventoryNotRentedForAYear());
           request.setAttribute("topMovies", dao.getTop10RentedMovies());
           request.setAttribute("botMovies", dao.getBottom10RentedMovies());
        }
            else
        {
            forward = "/adminCustomers.jsp";
            request.setAttribute("c", dao.getAllCustomerInfo());
        }

        //fowards it to the specific page
        RequestDispatcher view = request.getRequestDispatcher(forward);

        view.forward(request, response);

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
        String action = request.getParameter("action");

        Admin newAdmin = new Admin();

        if (action == "validateKey")
        {
            String key = request.getParameter("staff_id");
            //heres where you would actually need to validate that key
            forward = REGISTER;
        } 
        else if (action.equalsIgnoreCase("adminRegister"))
        {
            //forward = ACTIONPAGE;
            CustDAO custdao = new CustDAO();
            
            Admin admin = new Admin();
            Address adminAddress = new Address();
            Country adminCountry = new Country();
            City adminCity = new City();
            
            boolean active = true;  //still don't know how to get this to work correctly
            int adminAddress_id = custdao.lastCustAddressID() + 1;
            int adminCity_id = custdao.getLastCityID() + 1;
            int admin_id = dao.lastAdminID() + 1;
            
            //sets the rest of the needed information
            int store_id = Integer.parseInt(request.getParameter("store_id"));
            String first_name = request.getParameter("first_name");
            String last_name = request.getParameter("last_name");
            //do we want to drop the picture column from the table?
            String email = request.getParameter("email");
            //String address_id = null;
            String address = request.getParameter("address");           //for the address table
            String address2 = request.getParameter("address2");         //for address table
            String district = request.getParameter("district");         //for address table
            String city = request.getParameter("city");                 //for the city table
            String postal_code = request.getParameter("postal_code");   //for address table
            //real problem is that country is null here
            int country_id = Integer.parseInt(request.getParameter("countries"));
            //Date create_date = new java.sql.Date(System.currentTimeMillis());
            //     create_date = (java.sql.Date) Date.parse(request.getParameter("create_date"));
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date parsed = null;
            try {
                parsed = format.parse(request.getParameter("create_date"));
            } catch (ParseException ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
            java.sql.Date create_date = new java.sql.Date(parsed.getTime());
            
            String phone = request.getParameter("phone");
            //need help with this
//            if(custCheckBox.isChecked()){
//            } else {
//                active = false;
//            }
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            //handles the country
            String country = custdao.getCustCountry(country_id);
            adminCountry.setCountry_id(country_id);
            adminCountry.setCountry(country);
            adminCountry.setLast_update(create_date);
            
            //adds in the city
            adminCity.setCityID(adminCity_id);
            adminCity.setCity(city);
            adminCity.setCountry_id(country_id);
            adminCity.setLast_update(create_date);
            custdao.addCity(adminCity);
            
            //adds in the address
            adminAddress.setAddress_id(adminAddress_id);
            adminAddress.setAddress(address);
            adminAddress.setAddress2(address2);
            adminAddress.setDistrict(district);
            adminAddress.setCity_id(adminCity_id);    
            adminAddress.setPostal_code(postal_code);
            adminAddress.setPhone(phone);
            adminAddress.setLast_update(create_date);
            custdao.addCustAddress(adminAddress);
            
            //add in the new staff member
            admin.setStaff_id(admin_id);
            admin.setFirst_name(first_name);
            admin.setLast_name(last_name);
            admin.setAddress_id(adminAddress_id);
            //picture is currently being ignored
            admin.setEmail(email);
            admin.setStore_id(store_id);
            admin.setActive(true);
            admin.setUsername(username);
            admin.setPassword(password);
            admin.setLast_update(create_date);
            dao.addAdmin(admin);
            
            forward = EMPLOYEES; 
            request.setAttribute("emps", dao.getAllAdmins());
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);

        view.forward(request, response);
    }
}