/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SEALS.storedproc;

import com.SEALS.login.*;
import com.SEALS.admin.Admin;
import com.SEALS.customer.Cust;
import com.SEALS.film.Film;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Austin
 */
public class storedProcDAO
{
     private Connection connection;

    public storedProcDAO() {
        connection = com.SEALS.db.DBConnectionUtil.getConnection();
    }
    
    public Admin getLoginWID(int staff_id){
        Admin admin = new Admin();
        
         try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from sakila.staff where staff_id=?");
            preparedStatement.setInt(1, staff_id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
             
               admin.setStaff_id(staff_id);
               admin.setFirst_name(rs.getString("first_name"));
               admin.setLast_name(rs.getString("last_name"));
               admin.setAddress_id(rs.getInt("address_id"));
               admin.setEmail(rs.getString("email"));
               admin.setStore_id(rs.getInt("store_id"));
               admin.setActive(rs.getBoolean("active"));
               admin.setUsername(rs.getString("username"));
               admin.setPassword(rs.getString("password"));
               admin.setLast_update(rs.getDate("last_update"));

               //get the rest if that shit
              
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return admin;
                
    }
    
    public int confirmAdminLogin(String username, String password){
        //Select staff_id From staff where username ='Jon' and password is null
        
        int x = -1;
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select staff_id from sakila.staff where username=? and password=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
             
                x = (rs.getInt("staff_id"));
              
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;

    
    
    }
    
     public int confirmCustomerLogin(String email, String id){
        //Select staff_id From staff where username ='Jon' and password is null
        
        int x = -1;
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select address_id from sakila.customer where customer_id=? and email=?");
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.setString(1, email);
           
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
             
                x = (rs.getInt("address_id"));
                
              
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;

   
    }
     
     public Cust getCustomerWID(String custID){
        Cust cust = new Cust();
        
         try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from sakila.customer where customer_id=?");
            preparedStatement.setInt(1, Integer.parseInt(custID));
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
             
               cust.setCustomer_id(rs.getInt("customer_id"));
               cust.setStore_id(rs.getInt("store_id"));
               cust.setFirst_name(rs.getString("first_name"));
               cust.setLast_name(rs.getString("last_name"));
               cust.setEmail(rs.getString("email"));
               cust.setAddress_id(rs.getInt("address_id"));
               cust.setActive(rs.getBoolean("active"));
               cust.setCreate_date(rs.getDate("create_date"));
               cust.setLast_update(rs.getDate("last_update"));
               
               
              
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return cust;
                
    }
     //
     //
     // stored procedures
     //
     //
     
     
     //customer_create_date
     public void create_date(){
         String query = "{call customer_create_date }";
     
     /*    try
         {
             
             
             
         }
         
       /*  catch()
                 {
                     
                 }*/
     
     }
     
     //del_film
     public void deleteFilm(){
         
     }
     
     //film_in_stock
      public int filmInStock(int film_id, int store_id) throws SQLException{
          String query = "{call film_in_stock(?,?,?)";
          
          CallableStatement callableStatement = connection.prepareCall(query);
          callableStatement.setInt(1, film_id);
          callableStatement.setInt(2, store_id);
          callableStatement.registerOutParameter(3, java.sql.Types.INTEGER);

          callableStatement.executeUpdate();
          
          
          return callableStatement.getInt(3);
      }
     
     
     //film_not_in_stock
      public int notInStock(int film_id, int store_id) throws SQLException{
      String query = "{call film_not_in_stock(?,?,?)";
          
          CallableStatement callableStatement = connection.prepareCall(query);
          callableStatement.setInt(1, film_id);
          callableStatement.setInt(2, store_id);
          callableStatement.registerOutParameter(3, java.sql.Types.INTEGER);

          callableStatement.executeUpdate();
          
          
          return callableStatement.getInt(3);
          
      }
     
     //get_customer_balance
      public void customerBalance(int customer_id, Date effective_date) throws SQLException{
          String query = "{call get_customer_balance}";
          
          CallableStatement callableStatement = connection.prepareCall(query);
          callableStatement.setInt(1, customer_id);
          callableStatement.setDate(2, effective_date);
          
          callableStatement.executeUpdate();
      }
     
     //ins_film
     // public void insertFilm 
     
     //inventory_held_by_customer
     
     //inventory_in_stock
     
     //payment_date
     
     //rental_date
     
     //rewards_report
     
     //upd_film
     
     
    
}
