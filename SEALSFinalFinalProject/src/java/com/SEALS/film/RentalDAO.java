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
public class RentalDAO {

    Connection connection;

    public RentalDAO() {
        connection = com.SEALS.db.DBConnectionUtil.getConnection();
    }

//    insert into statement / communication with database
    //make method to display rentals for each customer
    List<Rental> getCurrentRentals() {

        List<Rental> rentals = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select r.inventory_id, r.rental_id, r.rental_date, f.title, f.rental_rate, f.rental_duration,\n"
                    + " DATEDIFF(CURRENT_TIMESTAMP, rental_date) as DaysRented\n"
                    + "from rental as r\n"
                    + "join inventory as i\n"
                    + "on r.inventory_id = i.inventory_id\n"
                    + "join film as f\n"
                    + "on f.film_id = i.film_id\n"
                    + "where return_date is null and customer_id =" + Cust.customerID);
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

}
