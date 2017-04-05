package com.SEALS.admin;

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
public class AdminDAO {
    
    //add admin
    //delete admin
    //get all admin
    //get admin by id

   

    private Connection connection;

    public AdminDAO() {
        connection = com.SEALS.db.DBConnectionUtil.getConnection();
    }
    
//    insert into statement / communication with database
    public void addAdmin(Admin admin) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into sakila.staff"
                            + "(first_name,last_name,address_id,email,store_id"
                            + "active,username,password,last_update) "
                            + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, admin.getFirst_name());
            preparedStatement.setString(2, admin.getLast_name());
            preparedStatement.setInt(3, admin.getAddress_id());
            preparedStatement.setString(4, admin.getEmail());
            preparedStatement.setInt(5, admin.getStore_id());
            preparedStatement.setBoolean(6, admin.isActive());
            preparedStatement.setString(7, admin.getUsername());
            preparedStatement.setString(8, admin.getPassword());
            preparedStatement.setDate(9, new java.sql.Date(admin.getLast_update().getTime()));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    delete product / remove from database 
    public void deleteAdmin(int admin_id) {
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement( "delete from sakila.staff where admin_id=?");
            preparedStatement.setInt(1, admin_id);
            preparedStatement.executeUpdate();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
  //  update film and refresh from database
    public void updateAdmin(Admin admin) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update sakila.staff set staff_id=?, first_name=?, last_name=?, "
                            + "address_id=?,email=?,store_id=?,active=?,username=?,password=?,last_update=?"
                            + "where staff_id=?");
            
            preparedStatement.setInt(1, admin.getStaff_id());
            preparedStatement.setString(2, admin.getFirst_name());
            preparedStatement.setString(3, admin.getLast_name());
            preparedStatement.setInt(4, admin.getAddress_id());
            preparedStatement.setString(5, admin.getEmail());
            preparedStatement.setInt(6, admin.getStore_id());
            preparedStatement.setBoolean(7, admin.isActive());
            preparedStatement.setString(8, admin.getUsername());
            preparedStatement.setString(9, admin.getPassword());
            preparedStatement.setDate(10, new java.sql.Date(admin.getLast_update().getTime()));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
//    method to display all products from database
    public List<Admin> getAllAdmins() {
        List<Admin> admins = new ArrayList<Admin>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from sakila.staff");
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setStaff_id(rs.getInt("staff_id"));
                admin.setFirst_name(rs.getString("first_name"));
                admin.setLast_name(rs.getString("last_name"));
                admin.setAddress_id(rs.getInt("address_id"));
                admin.setEmail(rs.getString("email"));
                admin.setStore_id(rs.getInt("store_id"));
                admin.setActive(rs.getBoolean("active"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                admin.setLast_update(rs.getDate("last_update"));
                admins.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admins;
    }
//    display product if productid is certain number
    public Admin getAdminById(int staff_id) {
        Admin admin = new Admin();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from sakila.staff where staff_id=?");
            preparedStatement.setInt(1, staff_id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            
                admin.setStaff_id(rs.getInt("staff_id"));
                admin.setFirst_name(rs.getString("first_name"));
                admin.setLast_name(rs.getString("last_name"));
                admin.setAddress_id(rs.getInt("address_id"));
                admin.setEmail(rs.getString("email"));
                admin.setStore_id(rs.getInt("store_id"));
                admin.setActive(rs.getBoolean("active"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                admin.setLast_update(rs.getDate("last_update"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admin;
    }
    
    
    
    
}
