package com.SEALS.film;

import com.SEALS.customer.Cust;

import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//import com.SEALS.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ering
 */
public class FilmDAO {

    Connection connection;

    public FilmDAO() {
        connection = com.SEALS.db.DBConnectionUtil.getConnection();
    }

//    insert into statement / communication with database
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
            preparedStatement.setDate(12, film.getLast_update());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    delete product / remove from database 
    public void deleteFilm(int film_id) {
        try {
            PreparedStatement preparedStatement
                    = connection.prepareStatement("delete from sakila.film where film_id =" + film_id);
            // preparedStatement.setInt(1, film_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }
    //  update film and refresh from database

    public void updateFilm(Film film) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update sakila.film set title=?, description=?, "
                            + "rental_rate=?, length=?, replacement_cost=?, rating=?, "
                            + "last_update=?"
                            + "where film_id=?");

            //preparedStatement.setInt(1, film.getFilm_id());
            preparedStatement.setString(1, film.getTitle());
            preparedStatement.setString(2, film.getDescription());
            //preparedStatement.setDate(4, new java.sql.Date(film.getRelease_year().getTime()));
            //preparedStatement.setInt(5, film.getLanguage_id());
            //preparedStatement.setInt(6, film.getOriginal_language_id());
            //preparedStatement.setInt(7, film.getRental_duration());
            preparedStatement.setFloat(3, film.getRental_rate());
            preparedStatement.setInt(4, film.getLength());
            preparedStatement.setFloat(5, film.getReplacement_cost());
            preparedStatement.setString(6, film.getRating());
            //preparedStatement.setString(12, film.getSpecial_features());
            preparedStatement.setDate(7, film.getLast_update());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    method to display all products from database
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
//    display product if productid is certain number

    public Film getFilmById(int film_id) {
        Film film = new Film();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from sakila.film where film_id=?");
            preparedStatement.setInt(1, film_id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

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

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return film;
    }

    //gets all the currently rented films
    public List<Film> currentlyRentedFilms(int customer_id) {
        //will be filled with Lauren's code
        List<Film> films = new ArrayList<>();
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("select * from sakila.film where");
//            while (rs.next()) {
//                Film film = new Film();
//                film.setFilm_id(rs.getInt("film_id"));
//                film.setTitle(rs.getString("title"));
//                film.setDescription(rs.getString("description"));
//                film.setRelease_year(rs.getDate("release_year"));
//                film.setLanguage_id(rs.getInt("language_id"));
//                film.setOriginal_language_id(rs.getInt("original_language_id"));
//                film.setRental_duration(rs.getInt("rental_duration"));
//                film.setRental_rate(rs.getFloat("rental_rate"));
//                film.setLength(rs.getInt("length"));
//                film.setReplacement_cost(rs.getFloat("replacement_cost"));
//                film.setRating(rs.getString("rating"));
//                film.setSpecial_features(rs.getString("special_features"));
//                film.setLast_update(rs.getDate("last_update"));
//                films.add(film);
//            }
//        } catch (Exception ex) {
//        }
        return films;
    }

    //gets all the previously rented movies by customer
    public List<Rental> previouslyRentedFilms(int customer_id) {
        List<Rental> rentals = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select r.inventory_id, r.rental_id, r.rental_date, f.title, f.rental_rate, f.rental_duration,\n"
                    + " DATEDIFF(CURRENT_TIMESTAMP, rental_date) as DaysRented\n"
                    + "from sakila.rental as r\n"
                    + "join sakila.inventory as i\n"
                    + "on r.inventory_id = i.inventory_id\n"
                    + "join sakila.film as f\n"
                    + "on f.film_id = i.film_id\n"
                    + "where customer_id =" + Cust.customerID);
            while (rs.next()) {
                Rental rental = new Rental();
                rental.setInventoryID(rs.getInt("inventory_id"));
                rental.setRentalID(rs.getInt("rental_id"));
                rental.setRentalDate(rs.getDate("rental_date"));
                rental.setMovieTitle(rs.getString("title"));
                rental.setRentalRate(rs.getInt("rental_rate"));
                rental.setRentalDuration(rs.getInt("rental_duration"));
                rental.setDaysRented(rs.getInt("DaysRented"));
                rental.setDaysLeft(rental.getRentalDuration() - rental.getDaysRented());
                rentals.add(rental);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentals;
    }

    //gets all the wishlist films
    public List<Film> customerWishListItems(int customer_id) {
        List<Film> films = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from sakila.wishlist where customer_id=?");
            preparedStatement.setInt(1, customer_id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                PreparedStatement ps = connection.prepareStatement("select * from sakila.film where film_id=?");
                ps.setInt(1, rs.getInt("film_id"));
                ResultSet rs2 = ps.executeQuery();
                //returns each films info and adds it to the list
                while (rs2.next())
                {
                    Film film = new Film();
                    film.setFilm_id(rs2.getInt("film_id"));
                    film.setTitle(rs2.getString("title"));
                    film.setDescription(rs2.getString("description"));
                    film.setRelease_year(rs2.getDate("release_year"));
                    film.setLanguage_id(rs2.getInt("language_id"));
                    film.setOriginal_language_id(rs2.getInt("original_language_id"));
                    film.setRental_duration(rs2.getInt("rental_duration"));
                    film.setRental_rate(rs2.getFloat("rental_rate"));
                    film.setLength(rs2.getInt("length"));
                    film.setReplacement_cost(rs2.getFloat("replacement_cost"));
                    film.setRating(rs2.getString("rating"));
                    film.setSpecial_features(rs2.getString("special_features"));
                    film.setLast_update(rs2.getDate("last_update"));
                    films.add(film);
                }
            }
        } catch (Exception ex) {
        }
        return films;
    }

    public void removeFromWishlist(int customer_id, int film_id) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from sakila.wishlist where customer_id =? AND film_id=?");
            preparedStatement.setInt(1, customer_id);
            preparedStatement.setInt(2, film_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //make method to display rentals for each customer

}
