package org.magicmafia.ntm.neko_task_manager;

import java.sql.*;

public class DatabaseConnection {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:mydatabase.db";
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Connected to the database.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        String sql = "CREATE TABLE IF NOT EXISTS Employees ("
                + " Name VARCHAR(50) NOT NULL,"
                + " EmployeeID INT PRIMARY KEY,"
                + " Projects MEDIUMTEXT);";

        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
