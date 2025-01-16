package org.magicmafia.ntm.neko_task_manager;

import java.sql.*;

public class TableDrops {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:mydatabase.db";
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Connected to the database.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        String sql = "DROP TABLE Employees;";
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table Employees dropped.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        sql = "DROP TABLE Projects;";
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table Projects dropped.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        sql = "DROP TABLE Tasks;";
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table Tasks dropped.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
