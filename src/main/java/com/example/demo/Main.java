package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Students", "postgres", "yura2002");
            stmt = c.createStatement();


            String sql = "SELECT Name FROM Students";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Получаем значения
                int age = rs.getInt("Age");
                String first = rs.getString("Name");
                String last = rs.getString("Surname");

                //Вывод данных
                System.out.print("Age: " + age);
                System.out.print(", First name: " + first);
                System.out.println(", Last name: " + last);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }

}
