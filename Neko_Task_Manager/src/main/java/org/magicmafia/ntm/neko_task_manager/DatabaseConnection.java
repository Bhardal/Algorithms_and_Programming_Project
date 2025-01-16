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
            System.out.println("Table Employees created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        sql = "CREATE TABLE IF NOT EXISTS Tasks ("
                + " TaskName VARCHAR(50) NOT NULL,"
                + " TaskID INT PRIMARY KEY,"
                + " Priority INT,"
                + " Status VARCHAR(50),"
                + " Deadline datetime,"
                + " Comment VARCHAR(500),"
                + " Description VARCHAR(500),"
                + " FOREIGN KEY (ProjectID) REFERENCES Projects(ProjectID),"
                + " FOREIGN KEY (EmployeeID) REFERENCES Employees(EmployeeID));";

        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table Tasks created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        sql = "CREATE TABLE IF NOT EXISTS Projects ("
            + " ProjectName VARCHAR(50) NOT NULL,"
            + " ProjectID INT PRIMARY KEY,"
            + " Employees MEDIUMTEXT,"
            + " Tasks MEDIUMTEXT,"
            + " Deadline datetime);";

        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table Projects created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
