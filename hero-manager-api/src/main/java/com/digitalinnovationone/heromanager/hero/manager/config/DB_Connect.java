package com.digitalinnovationone.heromanager.hero.manager.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class DB_Connect {

    public  static Connection getConnection(){
        Connection connection = null;

        try(InputStream inputStream = DB_Connect.class.getClassLoader().getResourceAsStream("myconfig.properties")) {

            var prop = new Properties();
            prop.load(inputStream);

            String drivename = prop.getProperty("jdbc.driver");
            String addressdatabase = prop.getProperty("db.addres");
            String namedatabase= prop.getProperty("db.name");
            String passwdatabase= prop.getProperty("db.user.password");
            String logidatabase= prop.getProperty("db.user.login");

            var pg = new StringBuilder("jdbc:").append(drivename).append("://")
            .append(addressdatabase).append("/").append(namedatabase);
            connection = DriverManager.getConnection(String.valueOf(pg),logidatabase,passwdatabase);




        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
