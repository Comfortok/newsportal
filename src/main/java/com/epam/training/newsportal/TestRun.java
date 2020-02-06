package com.epam.training.newsportal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestRun {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Connection connection = null;


            String url = "jdbc:oracle:thin:@localhost:1521/ORCLCDB.localdomain";

            String username = "dummy";
            String password = "dummy";

            connection = DriverManager.getConnection(url, username, password);

            Statement stmt = connection.createStatement();

            ResultSet rset = stmt.executeQuery("select * from article");

            while (rset.next())
            {
                System.out.println(rset.getInt(1));
                System.out.println(rset.getString(2));
                System.out.println(rset.getString(3));
                System.out.println(rset.getDate(4));
            }
            stmt.close();

        } catch (Exception e) {
            System.out.println("Hai " + e);
        }
    }
}
