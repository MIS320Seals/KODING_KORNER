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
//                InputStream inputStream = DBConnectionUtil.class.getClassLoader().getResourceAsStream("/db.properties");
//                prop.load(inputStream);
//                String driver = prop.getProperty("driver");
                String url = prop.getProperty("jdbc:mysql://localhost:3306/mydatabase");
                String user = prop.getProperty("root");
                String password = prop.getProperty("nbuser");
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, password);
            //catches all possible exceptions
            } catch (ClassNotFoundException | SQLException e) {
                e.getMessage();
            }
            return connection;
        }

    }
}
//#these are the properties that allow access to the database, can be easily changed here
//driver=com.mysql.jdbc.Driver
//url=jdbc:mysql://localhost:3306/mydatabase
//user=root
//password=nbuser


