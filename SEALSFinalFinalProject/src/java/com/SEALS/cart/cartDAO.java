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
public class cartDAO {

    private Connection connection;

    public cartDAO() {
        connection = com.SEALS.db.DBConnectionUtil.getConnection();
    }

    void addToCart(int film_id, int customer_id) {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.

    }

    void addCart(String title, int film_id, float price, int rental_duration) {
        //To change body of generated methods, choose Tools | Templates.

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into sakila.cart(customer_id, film_id, title, price, rental_duration) values (?,?,?,?,?)");

            preparedStatement.setInt(1, Cust.customerID);
            preparedStatement.setInt(2, film_id);
            preparedStatement.setString(3, title);
            preparedStatement.setFloat(4, price);
            preparedStatement.setInt(5, rental_duration);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    void addWish(String title, int film_id, float price, int rental_duration) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into sakila.wishlist(customer_id, film_id, title, price, rental_duration) values (?,?,?,?,?)");

            preparedStatement.setInt(1, Cust.customerID);
            preparedStatement.setInt(2, film_id);
            preparedStatement.setString(3, title);
            preparedStatement.setFloat(4, price);
            preparedStatement.setInt(5, rental_duration);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    List<Cart> ListCart(int customerID) {

        List<Cart> carts = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from sakila.cart where customer_id=?");

            preparedStatement.setInt(1, Cust.customerID);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Cart cart = new Cart();
                
                cart.setTitle(rs.getString("title"));
                cart.setFilmID(rs.getInt("film_id"));
                cart.setPrice(rs.getFloat("price"));
                cart.setCustomerID(rs.getInt("customer_id"));
                cart.setCartID(rs.getInt("cart_id"));
                cart.setDateAdded((rs.getDate("date_added")));
                cart.setRentalDuration((rs.getInt("rental_duration")));
                carts.add(cart);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carts;
    }

    void removeCart(int cartID) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from sakila.cart where cart_id=?");

            preparedStatement.setInt(1, cartID);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    int getInventoryID(int filmID) {
        int x = -1;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Select Distinct I.inventory_id \n"
                    + "From sakila.inventory as I\n"
                    + "Join sakila.rental as R \n"
                    + "where I.film_id = ? and R.return_date is not null\n");

            preparedStatement.setInt(1, filmID);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                x = rs.getInt("inventory_id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }

    int getStoreID(int inventoryID) {
        int x = -1;
        try {
            PreparedStatement preparedStatement
                    = connection.prepareStatement("select store_id from sakila.inventory where inventory_id = ? ");

            preparedStatement.setInt(1, inventoryID);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                x = rs.getInt("store_id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }

    int getStaffID(int storeID) {
        int x = -1;
        try {
            PreparedStatement preparedStatement
                    = connection.prepareStatement("select manager_staff_id from sakila.store where store_id =?");

            preparedStatement.setInt(1, storeID);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                x = rs.getInt("manager_staff_id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }

    float checkOut() {

        List<Cart> carts = ListCart(Cust.customerID);


        float total = 0;
        int count = 0;



            while (count < carts.size()) {
                int i = getInventoryID(carts.get(count).getFilmID());
                if (i != -1) {
                    try {
                        PreparedStatement preparedStatement = connection
                                .prepareStatement("insert into sakila.rental(inventory_id, customer_id, staff_id) values (?,?,?)");

                        int s = getStoreID(i);
                        int staffID = getStaffID(s);

                        preparedStatement.setInt(1, i);
                        preparedStatement.setInt(2, Cust.customerID);
                        preparedStatement.setInt(3, staffID);

                        preparedStatement.executeUpdate();
                        total += carts.get(count).getPrice();

                        removeCart(carts.get(count).getCartID());
                        count++;

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                else{
               
                    removeCart(carts.get(count).getCartID());
                    count++;
                }
            }
        

        return total;

    }

    void removeFromCart(int inID) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from sakila.cart where customer_id =?");

            //  preparedStatement.setInt(1, inID);
            preparedStatement.setInt(1, Cust.customerID);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int checkCheckedOut() {
        int x = 0;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select count(*) as total from sakila.rental where "
                            + "return_date is null AND customer_id=?");

            preparedStatement.setInt(1, Cust.customerID);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                x = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }

    public int checkCartCount() {
        int x = 0;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select count(*) as total from sakila.cart where "
                            + "customer_id=?");

            preparedStatement.setInt(1, Cust.customerID);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                x = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }

}
