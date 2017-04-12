package com.SEALS.customer;

import com.SEALS.admin.Admin;
import com.SEALS.film.Film;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ering
 */
public class CustDAO {
    
    private Connection connection;

    public CustDAO() {
        connection = com.SEALS.db.DBConnectionUtil.getConnection();
    }
    
//    insert into statement / communication with database
    public void addCust(Cust cust) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into sakila.customer"
                            + "(store_id,first_name,last_name,email,address_id,active,create_date,"
                            + "last_update) values (?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, cust.getStore_id());
            preparedStatement.setString(2, cust.getFirst_name());
            preparedStatement.setString(3, cust.getLast_name());
            preparedStatement.setString(4, cust.getEmail());
            preparedStatement.setInt(5, cust.getAddress_id());
            preparedStatement.setBoolean(6, cust.isActive());
            preparedStatement.setDate(7, new java.sql.Date(cust.getCreate_date().getTime()));
            preparedStatement.setDate(8, new java.sql.Date(cust.getLast_update().getTime()));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    delete product / remove from database 
    public void deleteCust(int customer_id) {
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement( "delete from sakila.customer where customer_id=?");
            preparedStatement.setInt(1, customer_id);
            preparedStatement.executeUpdate();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
  //  update film and refresh from database
    public void updateCustomer(Cust cust) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update sakila.customer set customer_id=?, store_id=?, "
                            + "first_name=?,last_name=?,email=?,address_id=?,active=?,"
                            + "create_date=?,last_update=?"
                            + "where customer_id=?");
            
            preparedStatement.setInt(1, cust.getCustomer_id());
            preparedStatement.setInt(2, cust.getStore_id());
            preparedStatement.setString(3, cust.getFirst_name());
            preparedStatement.setString(4, cust.getLast_name());
            preparedStatement.setString(5, cust.getEmail());
            preparedStatement.setInt(6, cust.getAddress_id());
            preparedStatement.setBoolean(7, cust.isActive());
            preparedStatement.setDate(10, new java.sql.Date(cust.getCreate_date().getTime()));
            preparedStatement.setDate(10, new java.sql.Date(cust.getLast_update().getTime()));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
//    method to display all products from database
    public List<Cust> getAllCustomers() {
        List<Cust> customers = new ArrayList<Cust>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from sakila.customer");
            while (rs.next()) {
                Cust cust = new Cust();
                cust.setCustomer_id(rs.getInt("customer"));
                cust.setStore_id(rs.getInt("store_id"));
                cust.setFirst_name(rs.getString("first_name"));
                cust.setLast_name(rs.getString("last_name"));
                cust.setEmail(rs.getString("email"));
                cust.setAddress_id(rs.getInt("address_id"));
                cust.setActive(rs.getBoolean("active"));
                cust.setCreate_date(rs.getDate("create_date"));
                cust.setLast_update(rs.getDate("last_update"));
                customers.add(cust);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }
//    display product if productid is certain number
    public Cust getCustById(int customer_id) {
        Cust cust = new Cust();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from sakila.customer where customer_id=?");
            preparedStatement.setInt(1, customer_id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            
                cust.setCustomer_id(rs.getInt("customer"));
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
    //creates and returns an array list of actors
    public List<Actor> getAllActors()
    {
        List<Actor> actors = new ArrayList<Actor>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from sakila.actor");
            while (rs.next()) 
            {
                Actor actor = new Actor();
                actor.setActor_id(rs.getInt("actor_id"));
                actor.setFirst_name(rs.getString("first_name"));
                actor.setLast_name(rs.getString("last_name"));
                actors.add(actor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actors;
    }
    //creates and returns an array list of the movie categories
    public List<Category> getAllCategories()
    {
        List<Category> categories = new ArrayList<Category>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from sakila.category");
            while (rs.next()) 
            {
                Category categ = new Category();
                categ.setCategory_id(rs.getInt("category_id"));
                categ.setName(rs.getString("name"));
                categories.add(categ);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories; 
    }
    //creates a list of all the movies that are found in the search
    public List<Film> getAllSearchedFilms(String cat_name, String act_name, int store_id)
    {
        List<Film> films = new ArrayList<Film>();
        try {
            Statement statement = connection.createStatement();
            //select all the films from the database
            if (cat_name.isEmpty() && act_name.isEmpty())
            {
                ResultSet rs = statement.executeQuery("select * from sakila.film");
                while (rs.next())
                {
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
            }
            //select all the films that have the specified category
            else if (cat_name.length() > 0 && act_name.isEmpty())
            {
                ResultSet rs = statement.executeQuery
        ("select title "
                + "from sakila.film as f "
                + "join sakila.film_actor as FA"
                + "on f.film_id = fa.film_id"
                + "join sakila.film_category"
                + "on fa.film_id = fc.film_id"
                        + "where fa.actor_id = @actor_id AND fc.category_id = @category_id");
            }
            //select all the films that have the specified actor
            else if (cat_name.isEmpty() && act_name.length() > 0)
            {
                ResultSet rs = statement.executeQuery
        ("select title "
                + "from sakila.film as f"
                + "join sakila.film_actor as FA"
                + "on f.film_id = FA.film_id"
                        + "where fa.actor_id = @actor_id");    
            }
            //select all the films specified by BOTH category AND actor
            else
            {
                ResultSet rs = statement.executeQuery
        ("select title"
                + " from sakila.film as f"
                + "join sakila.film_category as FC"
                + "on f.film_id = fc.film_id"
                        + "where fc.category_id = @category_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return films;
    }
}
