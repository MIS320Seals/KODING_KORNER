package com.SEALS.admin;

import com.SEALS.film.Film;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.time.LocalDateTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ering
 */
public class AdminDAO
{

    //add admin
    //delete admin
    //get all admin
    //get admin by id
    private Connection connection;

    public AdminDAO()
    {
        connection = com.SEALS.db.DBConnectionUtil.getConnection();
    }

//    insert into statement / communication with database
    public void addAdmin(Admin admin)
    {
        try
        {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into sakila.staff"
                            + "(staff_id,"
                            + "first_name,"
                            + "last_name,"
                            + "address_id,"
                            + "email,"
                            + "store_id,"
                            + "active,"
                            + "username,"
                            + "password,"
                            + "last_update) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, admin.getStaff_id());
            preparedStatement.setString(2, admin.getFirst_name());
            preparedStatement.setString(3, admin.getLast_name());
            preparedStatement.setInt(4, admin.getAddress_id());
            preparedStatement.setString(5, admin.getEmail());
            preparedStatement.setInt(6, admin.getStore_id());
            preparedStatement.setBoolean(7, admin.isActive());
            preparedStatement.setString(8, admin.getUsername());
            preparedStatement.setString(9, admin.getPassword());
            preparedStatement.setDate(10, admin.getLast_update());
            preparedStatement.executeUpdate();

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

//    delete product / remove from database 
    public void deleteAdmin(int admin_id)
    {
        try
        {
            PreparedStatement preparedStatement
                    = connection.prepareStatement("delete from sakila.staff where admin_id=?");
            preparedStatement.setInt(1, admin_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    //  update film and refresh from database

    public void updateAdmin(Admin admin)
    {
        try
        {
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
            preparedStatement.setDate(10, admin.getLast_update());
            preparedStatement.executeUpdate();

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //returns the last admin id that was saved to the database
    public int lastAdminID()
    {
        int admin_id = 0;
        try
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select staff_id from sakila.staff order by staff_id desc");
            if (rs.next())
            {
                admin_id = rs.getInt("staff_id");
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return admin_id;
    }

//    method to display all products from database
    public List<Admin> getAllAdmins()
    {
        List<Admin> admins = new ArrayList<Admin>();
        try
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from sakila.staff");
            while (rs.next())
            {
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
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return admins;
    }

    public List<CustInfo> getAllCustomerInfo()
    {
        List<CustInfo> custs = new ArrayList<CustInfo>();
        try
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM sakila.customer_list");
            while (rs.next())
            {
                CustInfo admin = new CustInfo();
                admin.setId((rs.getInt("ID")) + "");
                admin.setName(rs.getString("name"));
                admin.setAddress(rs.getString("address"));
                admin.setZip(rs.getString("zip code"));
                admin.setPhoneNumber(rs.getString("phone"));
                admin.setCity(rs.getString("city"));
                admin.setCountry(rs.getString("country"));
                admin.setNotes(rs.getString("notes"));
                admin.setStoreId(rs.getInt("SID") + "");
                custs.add(admin);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return custs;
    }
//    display product if productid is certain number

    public Admin getAdminById(int staff_id)
    {
        Admin admin = new Admin();
        try
        {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from sakila.staff where staff_id=?");
            preparedStatement.setInt(1, staff_id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next())
            {

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
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return admin;
    }

    public CustInfo getCustInfoById(String id)
    {
        //Admin admin = new Admin();
        CustInfo admin = new CustInfo();
        try
        {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from sakila.customer_list where id = " + id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next())
            {

                admin.setId((rs.getInt("ID")) + "");
                admin.setName(rs.getString("name"));
                admin.setAddress(rs.getString("address"));
                admin.setZip(rs.getString("zip code"));
                admin.setPhoneNumber(rs.getString("phone"));
                admin.setCity(rs.getString("city"));
                admin.setCountry(rs.getString("country"));
                admin.setNotes(rs.getString("notes"));
                admin.setStoreId(rs.getInt("SID") + "");

            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return admin;
    }

    public List<Sales> getSalesByGenre()
    {
        List<Sales> s = new ArrayList<Sales>();

        try
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM sakila.sales_by_film_category");
            while (rs.next())
            {
                Sales sale = new Sales();
                sale.setGenre(rs.getString("category"));
                sale.setRevenue(rs.getString("total_sales"));
                s.add(sale);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return s;
    }

    public List<Sales> getSalesByStore()
    {
        List<Sales> s = new ArrayList<Sales>();

        try
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM sakila.sales_by_store");
            while (rs.next())
            {
                Sales sale = new Sales();
                sale.setGenre(rs.getString("store"));
                sale.setRevenue(rs.getString("total_sales"));
                s.add(sale);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return s;
    }

//     public List<Film> getNotCheckedOut() {
//        List<Film> f = new ArrayList<Film>();
//        Date localDate;
//        localDate = new Date();
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("SELECT * FROM sakila.inventory");
//            while (rs.next()) {
//
//                Film film = new Film();
//                film.setLast_update(rs.getDate("last_update"));
//
//                if(film.getLast_update().after((Date)localDate)){
//
//                }
//
//
//                f.add(film);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return f;
//    }
    public int currentInventory(int p_film_id, int p_store_id, int p_film_count) throws SQLException
    {
        String query = "{call film_in_stock(?,?,?)";

        CallableStatement callableStatement = connection.prepareCall(query);
        callableStatement.setInt(1, p_film_id);
        callableStatement.setInt(2, p_store_id);
        callableStatement.registerOutParameter(3, java.sql.Types.INTEGER);

        callableStatement.executeUpdate();

        return callableStatement.getInt(3);

    }

    public int currentCheckedOut(int p_film_id, int p_store_id, int p_film_count) throws SQLException
    {
        String query = "{call film_not_in_stock(?,?,?)";

        CallableStatement callableStatement = connection.prepareCall(query);
        callableStatement.setInt(1, p_film_id);
        callableStatement.setInt(2, p_store_id);
        callableStatement.registerOutParameter(3, java.sql.Types.INTEGER);

        callableStatement.executeUpdate();

        return callableStatement.getInt(3);

    }

    public List<Film> getFilmsInStock()
    {
        List<Film> f = new ArrayList<Film>();

        try
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("Select film_id , last_update from inventory");
            while (rs.next())
            {

                Film film = new Film();
                film.setFilm_id(rs.getInt("film_id"));
                film.setLast_update(rs.getDate("last_update"));
                //film.setStore_id(rs.getInt("store_id"));
                f.add(film);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return f;
    }

    public List<Film> getInventoryNotRentedForAYear()
    {
        List<Film> f = new ArrayList<Film>();

        try
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery
            ("SELECT  distinct(i.film_id), i.last_update, f.title, f.description, f.rating " +
            "FROM sakila.inventory i join sakila.film f " +
            "on i.film_id = f.film_id ");
            Date yearAgo;
            yearAgo = new Date(LocalDateTime.now().getYear() - 1,
                    LocalDateTime.now().getMonthValue(), LocalDateTime.now().getDayOfMonth());
            Film film;
            while (rs.next())
            {
                film = new Film();
                film.setLast_update(rs.getDate("last_update"));
                if (film.getLast_update().getTime() < yearAgo.getTime())
                {
                    film.setFilm_id(rs.getInt("film_id"));
                    film.setTitle(rs.getString("title"));
                    film.setDescription(rs.getString("description"));
                    film.setRating(rs.getString("rating"));
                    f.add(film);
                }

            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return f;
    }

    public List<Film> getTop10RentedMovies()
    {
        List<Film> f = new ArrayList<Film>();

        try
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery
            ("select count(i.film_id), f.title, f.description, f.rating " +
             "from (sakila.rental r  " +
             "    join sakila.inventory i " +
             "        on r.inventory_id = i.inventory_id " +
             "    join sakila.film f " +
             "        on i.film_id = f.film_id) " +
             "group by i.film_id " +
             "order by count(i.film_id) desc " +
             "LIMIT 10");
            
            Film film;
            while (rs.next())
            {
                film = new Film();
                    film.setFilm_id(rs.getInt("count(i.film_id)"));
                    film.setTitle(rs.getString("title"));
                    film.setDescription(rs.getString("description"));
                    film.setRating(rs.getString("rating"));
                    f.add(film);
            }
        } catch (SQLException e)
        {
            e.getStackTrace();
        }

        return f;
    }
            
    public List<Film> getBottom10RentedMovies()
    {
        List<Film> f = new ArrayList<Film>();

        try
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery
            ("select count(i.film_id), f.title, f.description, f.rating " +
             "from (sakila.rental r  " +
             "    join sakila.inventory i " +
             "        on r.inventory_id = i.inventory_id " +
             "    join sakila.film f " +
             "        on i.film_id = f.film_id) " +
             "group by i.film_id " +
             "order by count(i.film_id) " +
             "LIMIT 10");
            
            Film film;
            while (rs.next())
            {
                film = new Film();
                    film.setFilm_id(rs.getInt("count(i.film_id)"));
                    film.setTitle(rs.getString("title"));
                    film.setDescription(rs.getString("description"));
                    film.setRating(rs.getString("rating"));
                    f.add(film);
            }
        } catch (SQLException e)
        {
            e.getStackTrace();
        }

        return f;
    }
    
    
}
