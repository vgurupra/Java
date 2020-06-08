package com.company.DB;

import com.company.basics.collections.Customer;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Date;

public class CustomersDAO {
    private class Customers{
        public int customer_id;
        public String first_name;
        public String last_name;
        public String birth_date;
        public String phone;
        public String address;
        public String city;
        public String state;
        public String points;

        @Override
        public String toString() {
            return "Customers{" +
                    "customer_id=" + customer_id +
                    ", first_name='" + first_name + '\'' +
                    ", last_name='" + last_name + '\'' +
                    '}';
        }
    }

    private String url;
    private String user;
    private String password;

    public CustomersDAO(){
        url = "jdbc:mysql://localhost:3306/sql_store";
        user = "root";
        password = "admin";
    }

    public Customers getCustomerById(int id){
        String query = "SELECT * FROM customers WHERE customer_id="+id;

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet =  statement.executeQuery(query);

            if(!resultSet.next())return null;

            var customer = new Customers();
            customer.customer_id = resultSet.getInt(1);
            customer.first_name = resultSet.getString(2);
            customer.last_name = resultSet.getString(3);
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addCustomer(String first_name, String last_name, String address, String city, String state){
        String query = "INSERT INTO customers (first_name, last_name, address, city, state) VALUES(?, ?, ?, ?, ?)";
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, first_name);
            statement.setString(2, last_name);
            statement.setString(3, address);
            statement.setString(4, city);
            statement.setString(5, state);
            int count = statement.executeUpdate();
            System.out.println(count+" rows affected.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
