package com.SEALS.db;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 *
 * @author ering
 */
public class DBConnectionUtil {
    private static Connection connection = null;

    //creates the connection to the database through the db.properties file that has the data base information
    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
            	Properties prop = new Properties();
////                InputStream inputStream = DBConnectionUtil.class.getClassLoader().getResourceAsStream("/db.properties");
////                prop.load(inputStream);
                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull";
                String user = "root";
                String password = "nbuser";
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            //catches all possible exceptions
            } catch (ClassNotFoundException | SQLException e) {
                
            }
            return connection;
        }

    }
}