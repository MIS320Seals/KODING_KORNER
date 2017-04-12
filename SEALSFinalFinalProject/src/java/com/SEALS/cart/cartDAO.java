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
    
    public void addFilm(Film film) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into sakila.film"
                            + "(title,description,release_year,language_id,original_language_id,"
                            + "rental_duration, rental_rate,length,replacement_cost, rating,"
                            + "special_features,last_update) "
                            + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, film.getTitle());
            preparedStatement.setString(2, film.getDescription());
            preparedStatement.setDate(3, new java.sql.Date(film.getRelease_year().getTime()));
            preparedStatement.setInt(4, film.getLanguage_id());
            preparedStatement.setInt(5, film.getOriginal_language_id());
            preparedStatement.setInt(6, film.getRental_duration());
            preparedStatement.setFloat(7, film.getRental_rate());
            preparedStatement.setInt(8, film.getLength());
            preparedStatement.setFloat(9, film.getReplacement_cost());
            preparedStatement.setString(10, film.getRating());
            preparedStatement.setString(11, film.getSpecial_features());
            preparedStatement.setDate(12, new java.sql.Date(film.getLast_update().getTime()));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    delete product / remove from database 
    public void deleteFilm(int film_id) {
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement( "delete from sakila.film where film_id=?");
            preparedStatement.setInt(1, film_id);
            preparedStatement.executeUpdate();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
  //  update film and refresh from database
    public void updateFilm(Film film) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update sakila.film set film_id=?, title=?, description=?, "
                            + "release_year=?, language_id=?, original_language_id=?, rental_duration=?,"
                            + "rental_rate=?, length=?, replacement_cost=?, rating=?, special_features=?,"
                            + "last_update=?"
                            + "where film_id=?");
            
            preparedStatement.setInt(1, film.getFilm_id());
            preparedStatement.setString(2, film.getTitle());
            preparedStatement.setString(3, film.getDescription());
            preparedStatement.setDate(4, new java.sql.Date(film.getRelease_year().getTime()));
            preparedStatement.setInt(5, film.getLanguage_id());
            preparedStatement.setInt(6, film.getOriginal_language_id());
            preparedStatement.setInt(7, film.getRental_duration());
            preparedStatement.setFloat(8, film.getRental_rate());
            preparedStatement.setInt(9, film.getLength());
            preparedStatement.setFloat(10, film.getReplacement_cost());
            preparedStatement.setString(11, film.getRating());
            preparedStatement.setString(12, film.getSpecial_features());
            preparedStatement.setDate(13, new java.sql.Date(film.getLast_update().getTime()));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public List<Film> getAllFilms() {
        List<Film> films = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from sakila.film");
            while (rs.next()) {
                Film film = new Film();
                film.setFilm_id(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setDescription(rs.getString("description"));
                film.setRelease_year(rs.getDate("release_year"));
                film.setLanguage_id(rs.getInt("language_id"));
                film.setOriginal_language_id(rs.getInt("original_language_id"));
                film.setRental_duration(rs.getInt("rental_duration"));
                film.setRental_rate(rs.getFloat("rental_rate"));
                film.setLength(rs.getInt("length"));
                film.setReplacement_cost(rs.getFloat("replacement_cost"));
                film.setRating(rs.getString("rating"));
                film.setSpecial_features(rs.getString("special_features"));
                film.setLast_update(rs.getDate("last_update"));
                films.add(film);
            }
        } catch (Exception ex) {
        }
        return films;
    }
    
    
    
//    
//    public Admin getLoginWID(int staff_id){
//        Admin admin = new Admin();
//        
//         try {
//            PreparedStatement preparedStatement = connection.
//                    prepareStatement("select * from sakila.staff where staff_id=?");
//            preparedStatement.setInt(1, staff_id);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            if (rs.next()) {
//             
//               admin.setStaff_id(staff_id);
//               admin.setFirst_name(rs.getString("first_name"));
//               admin.setLast_name(rs.getString("last_name"));
//               admin.setAddress_id(rs.getInt("address_id"));
//               admin.setEmail(rs.getString("email"));
//               admin.setStore_id(rs.getInt("store_id"));
//               admin.setActive(rs.getBoolean("active"));
//               admin.setUsername(rs.getString("username"));
//               admin.setPassword(rs.getString("password"));
//               admin.setLast_update(rs.getDate("last_update"));
//
//               //get the rest if that shit
//              
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        
//        return admin;
//                
//    }
//    
//    public int confirmAdminLogin(String username, String password){
//        //Select staff_id From staff where username ='Jon' and password is null
//        
//        int x = -1;
//        try {
//            PreparedStatement preparedStatement = connection.
//                    prepareStatement("select staff_id from sakila.staff where username=? and password=?");
//            preparedStatement.setString(1, username);
//            preparedStatement.setString(2, password);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            if (rs.next()) {
//             
//                x = (rs.getInt("staff_id"));
//              
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return x;
//
//    
//    
//    }
//    
//     public int confirmCustomerLogin(String email, String id){
//        //Select staff_id From staff where username ='Jon' and password is null
//        
//        int x = -1;
//        try {
//            PreparedStatement preparedStatement = connection.
//                    prepareStatement("select address_id from sakila.customer where customer_id=? and email=?");
//            preparedStatement.setInt(1, Integer.parseInt(id));
//            preparedStatement.setString(1, email);
//           
//            ResultSet rs = preparedStatement.executeQuery();
//
//            if (rs.next()) {
//             
//                x = (rs.getInt("address_id"));
//                
//              
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return x;
//
//   
//    }
     
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
     
     
     
    
}
