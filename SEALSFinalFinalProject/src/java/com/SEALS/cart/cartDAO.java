/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SEALS.cart;

import com.SEALS.storedproc.*;
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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.derby.client.am.Decimal;

/**
 *
 * @author Austin
 */
public class cartDAO
{
     private Connection connection;

    public cartDAO() {
        connection = com.SEALS.db.DBConnectionUtil.getConnection();
    }
    

    void addToCart(int film_id, int customer_id) {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
        
    }

    void addCart(String title, int film_id, float price) {
         //To change body of generated methods, choose Tools | Templates.
    
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into cart(customer_id, film_id, title, price) values (?,?,?,?)");

            preparedStatement.setInt(1, Cust.customerID);
            preparedStatement.setInt(2, film_id);
            preparedStatement.setString(3, title);
            preparedStatement.setFloat(4, price);
            preparedStatement.executeUpdate();

            
          
        } catch (SQLException e) {
            e.printStackTrace();
        }
         
    }

    void addWish(String title, int film_id, float price) {
        
    
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into wishlist(customer_id, film_id, title, price) values (?,?,?,?)");

            preparedStatement.setInt(1, Cust.customerID);
            preparedStatement.setInt(2, film_id);
            preparedStatement.setString(3, title);
            preparedStatement.setFloat(4, price);
            preparedStatement.executeUpdate();

            
          
        } catch (SQLException e) {
            e.printStackTrace();
        }
     
    }
     
     
     
    
}
