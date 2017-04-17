package com.SEALS.admin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.SEALS.admin.Admin;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
//@WebServlet(urlPatterns = {"/AdminController"})
public class AdminController extends HttpServlet
{

    private static final long serialVersionUID = 1L;
    private static String REGISTER = "/adminRegisterPage.jsp";
    private static String RESPONSE = "/response.jsp";
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

        String action = "";
        if (request.getParameter("action") != null)
        {
            action = request.getParameter("action");
        }
        //   String key = request.getParameter("passKey");
        if (action == null)
        {
            forward = REGISTER;
        }

        //based off which action is sent, either delete, update or list all products
        if (action.equalsIgnoreCase("delete"))
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

        } else
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
        } else if (action.equals("adminRegister"))
        {
            newAdmin.setFirst_name(request.getParameter("first_name"));
            newAdmin.setLast_name(request.getParameter("last_name"));
            newAdmin.setAddress_id(Integer.parseInt(request.getParameter("address_id")));
            newAdmin.setEmail(request.getParameter("email"));
            newAdmin.setStore_id(Integer.parseInt(request.getParameter("store_id")));
            //newAdmin.setActive(Boolean.parseBool(request.getParameter("Active")));
            String active = request.getParameter("Active");
            newAdmin.setUsername(request.getParameter("username"));
            newAdmin.setPassword(request.getParameter("password"));
            try
            {
                Date last_update = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("last_update"));
                newAdmin.setLast_update(new java.sql.Date(last_update.getTime()));
            } catch (ParseException e)
            {
                e.printStackTrace();
            }
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);

        view.forward(request, response);
    }
}
