package com.SEALS.film;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.SEALS.*;
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

    


   

    private Connection connection;

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
            preparedStatement.setDate(12, new java.sql.Date(film.getLast_update().getTime()));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    delete product / remove from database 
    public void deleteProduct(int product_id) {
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement( "delete from mydatabase.product where product_id=?");
            preparedStatement.setInt(1, product_id);
            preparedStatement.executeUpdate();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
//    update product and refresh from database
//    public void updateProduct(Product product) {
//        try {
//            PreparedStatement preparedStatement = connection
//                    .prepareStatement("update mydatabase.product set customer_id=?, order_num=?, quality=?, "
//                            + "shipping_cost=?, sales_date=?, shipping_date=? where product_id=?");
//            
//            preparedStatement.setInt(1, product.getCustomer_id());
//            preparedStatement.setInt(2, product.getOrder_num());
//            preparedStatement.setInt(3, product.getQuality());
//            preparedStatement.setInt(4, product.getShipping_cost());
//            preparedStatement.setDate(5, new java.sql.Date(product.getSales_date().getTime()));
//            preparedStatement.setDate(6, new java.sql.Date(product.getShipping_date().getTime()));
//            preparedStatement.setInt(7, product.getProduct_id());
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    
////    method to display all products from database
//    public List<Product> getAllProducts() {
//        List<Product> products = new ArrayList<Product>();
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("select * from mydatabase.product");
//            while (rs.next()) {
//                Product product = new Product();
//                product.setProduct_id(rs.getInt("product_id"));
//                product.setCustomer_id(rs.getInt("customer_id"));
//                product.setOrder_num(rs.getInt("order_num"));
//                product.setQuality(rs.getInt("quality"));
//                product.setShipping_cost(rs.getInt("shipping_cost"));
//                product.setSales_date(rs.getDate("sales_date"));
//                product.setShipping_date(rs.getDate("shipping_date"));
//                products.add(product);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return products;
//    }
////    display product if productid is certain number
//    public Product getProductById(int product_id) {
//        Product product = new Product();
//        try {
//            PreparedStatement preparedStatement = connection.
//                    prepareStatement("select * from mydatabase.product where product_id=?");
//            preparedStatement.setInt(1, product_id);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            if (rs.next()) {
//             
//                product.setProduct_id(rs.getInt("product_id"));
//                product.setCustomer_id(rs.getInt("customer_id"));
//                product.setOrder_num(rs.getInt("order_num"));
//                product.setQuality(rs.getInt("quality"));
//                product.setShipping_cost(rs.getInt("shipping_cost"));
//                product.setSales_date(rs.getDate("sales_date"));
//                product.setShipping_date(rs.getDate("shipping_date"));
//               
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return product;
//    }
}
