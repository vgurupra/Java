package com.company.DB;

import java.sql.*;

public class SqlQuery {
    public void getCustomers(){
        String url = "jdbc:mysql://localhost:3306/sql_store";
        String user = "root";
        String password = "admin";
        String query = "SELECT * FROM customers";
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet =  statement.executeQuery(query);

            while (resultSet.next()){
                String userData = resultSet.getInt(1) + " - " + resultSet.getString(2);
                System.out.println(userData);
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertCustomers(){
        String url = "jdbc:mysql://localhost:3306/sql_store";
        String user = "root";
        String password = "admin";
        String query = "INSERT INTO customers (first_name, last_name, address, city, state) VALUES('Vishal', 'Guruprasad', '1234 Avenue', 'Los Angeles', 'CA')";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            int count = statement.executeUpdate(query);
            System.out.println(count+" rows affected.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
