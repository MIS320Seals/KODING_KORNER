/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SEALS.login;

import com.SEALS.admin.Admin;
import com.SEALS.film.Film;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Austin
 */
public class loginDAO
{
     private Connection connection;

    public loginDAO() {
        connection = com.SEALS.db.DBConnectionUtil.getConnection();
    }
    
    public Admin getLonginWID(int staff_id){
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
    
}
