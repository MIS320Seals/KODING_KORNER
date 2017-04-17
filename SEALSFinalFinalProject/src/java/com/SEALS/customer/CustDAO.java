package com.SEALS.customer;

import com.SEALS.admin.Admin;
import com.SEALS.film.Film;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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
                            + "last_update,username,password) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, cust.getStore_id());
            preparedStatement.setString(2, cust.getFirst_name());
            preparedStatement.setString(3, cust.getLast_name());
            preparedStatement.setString(4, cust.getEmail());
            preparedStatement.setInt(5, cust.getAddress_id());
            preparedStatement.setBoolean(6, cust.isActive());
            preparedStatement.setDate(7, new java.sql.Date(cust.getCreate_date().getTime()));
            preparedStatement.setDate(8, new java.sql.Date(cust.getLast_update().getTime()));
            preparedStatement.setString(9, cust.getUsername());
            preparedStatement.setString(10, cust.getPassword());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //adds a new address entry
    public void addCustAddress(Address custAdd) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into sakila.address"
                + "(address,address2,district,city_id,postal_code,phone,last_update)"
                + "values (?, ?, ?, ?, ?, ?, ?");
            //ps.setInt(1, custAdd.getAddress_id());
            ps.setString(1, custAdd.getAddress());
            ps.setString(2, custAdd.getAddress2());
            ps.setString(3, custAdd.getDistrict());
            ps.setInt(4, custAdd.getCity_id());
            ps.setString(5, custAdd.getPostal_code());
            ps.setString(6, custAdd.getPhone());
            //I would like to drop this column from the table??
            //ps.setInt(7, custAdd.getLocation());
            ps.setDate(7, new java.sql.Date(custAdd.getLast_update().getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //returns back the address id of the last address saved into the database
    public int lastCustAddressID(Address custAdd)
    {
        int address_id = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT address_id FROM sakila.address "
                    + "ORDER BY address_id DESC LIMIT 1");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address_id; 
    }

//    delete product / remove from database 
    public void deleteCust(int customer_id) {
        try {
            PreparedStatement preparedStatement
                    = connection.prepareStatement("delete from sakila.customer where customer_id=?");
            preparedStatement.setInt(1, customer_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
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
    public List<Actor> getAllActors() {
        List<Actor> actors = new ArrayList<Actor>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from sakila.actor");
            while (rs.next()) {
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
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<Category>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from sakila.category");
            while (rs.next()) {
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
    public List<Film> getAllSearchedFilms(String cat_name, String act_name, int store_id) {
        int actor_id = -1;
        int category_id = -1;
        if (!act_name.equalsIgnoreCase("Select Actor")) {
            actor_id = Integer.parseInt(act_name);
            //get films with actor

        }
        //if they searched by category
        if (!cat_name.equalsIgnoreCase("Select Category")) {
            //get films by category
            category_id = Integer.parseInt(cat_name);
        }
        List<Film> films = new ArrayList<Film>();
        try {
            Statement statement = connection.createStatement();
            //select all the films from the database
            if (category_id == -1 && actor_id == -1) {
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
            } //select all the films that have the specified category
            else if (category_id != -1 && actor_id == -1) {

                try {
                    PreparedStatement preparedStatement = connection
                            .prepareStatement("select f.film_id, f.title,f.description,f.rating,f.rental_rate,f.release_year, f.rental_duration\n"
                                    + "from sakila.film as f \n"
                                    + "join sakila.film_actor as FA\n"
                                    + "on f.film_id = fa.film_id\n"
                                    + "join sakila.film_category as FC\n"
                                    + "on fa.film_id = fc.film_id\n"
                                    + "where FC.category_id = ?");

                    preparedStatement.setInt(1, category_id);
                    ResultSet rs = preparedStatement.executeQuery();
                    while (rs.next()) {
                        Film film = new Film();
                        film.setTitle(rs.getString("title"));
                        film.setFilm_id(rs.getInt("film_id"));
                        film.setRental_rate(rs.getFloat("rental_rate"));
                        film.setDescription(rs.getString("description"));
                        film.setRating(rs.getString("rating"));
                        film.setRelease_year((rs.getDate("release_year")));
                        film.setRental_duration((rs.getInt("rental_duration")));
                        films.add(film);
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } //select all the films that have the specified actor
            else if (category_id == -1 && actor_id != -1) {
                try {
                    PreparedStatement preparedStatement = connection
                            .prepareStatement("select f.rental_duration, f.film_id, f.title,f.description,f.rating,f.rental_rate,f.release_year\n"
                                    + "from sakila.film as f\n"
                                    + "join sakila.film_actor as FA\n"
                                    + "on f.film_id = FA.film_id\n"
                                    + "where fa.actor_id =?");

                    preparedStatement.setInt(1, actor_id);
                    ResultSet rs = preparedStatement.executeQuery();
                    while (rs.next()) {
                        Film film = new Film();
                        film.setTitle(rs.getString("title"));
                        film.setFilm_id(rs.getInt("film_id"));
                        film.setDescription(rs.getString("description"));
                        film.setRating(rs.getString("rating"));

                        film.setRental_rate(rs.getFloat("rental_rate"));

                        film.setRelease_year((rs.getDate("release_year")));
                        film.setRental_duration((rs.getInt("rental_duration")));
                        films.add(film);
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            } //select all the films specified by BOTH category AND actor
            else {
                PreparedStatement preparedStatement = connection
                        .prepareStatement("select f.rental_duration, f.film_id, f.title,f.rental_rate, f.description,f.rating,f.release_year\n"
                                + "from sakila.film as f\n"
                                + "join sakila.film_actor as FA\n"
                                + "on f.film_id = fa.film_id\n"
                                + "join sakila.film_category as FC\n"
                                + "on fa.film_id = fc.film_id\n"
                                + "where FC.category_id = ? AND FA.actor_id=? ");

                preparedStatement.setInt(1, category_id);
                preparedStatement.setInt(1, actor_id);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    Film film = new Film();
                    film.setTitle(rs.getString("title"));
                    film.setFilm_id(rs.getInt("film_id"));
                    film.setRental_rate(rs.getFloat("film_id"));

                    film.setDescription(rs.getString("description"));
                    film.setRating(rs.getString("rating"));
                    film.setRelease_year((rs.getDate("release_year")));
                    film.setRental_duration((rs.getInt("rental_duration")));

                    films.add(film);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return films;
    }
}
