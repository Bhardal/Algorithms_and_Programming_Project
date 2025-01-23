package org.magicmafia.ntm.neko_task_manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
                   + " EmployeeID INT PRIMARY KEY,"
                   + " Name VARCHAR(50) NOT NULL,"
                   + " Projects MEDIUMTEXT);";
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table Employees created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        sql = "CREATE TABLE IF NOT EXISTS Projects ("
            + " ProjectID INT PRIMARY KEY,"
            + " ProjectName VARCHAR(50) NOT NULL,"
            + " Employees MEDIUMTEXT,"
            + " Tasks VARCHAR(50),"
            + " Deadline date);";

        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table Projects created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        sql = "CREATE TABLE IF NOT EXISTS Tasks ("
            + " TaskID INT PRIMARY KEY,"
            + " TaskName VARCHAR(50) NOT NULL,"
            + " Priority INT,"
            + " Status VARCHAR(50),"
            + " Deadline date,"
            + " Comment VARCHAR(500),"
            + " Description VARCHAR(500),"
            + " ProjectID INT,"
            + " EmployeeID INT,"
            + " FOREIGN KEY (ProjectID) REFERENCES Projects(ProjectID),"
            + " FOREIGN KEY (EmployeeID) REFERENCES Employees(EmployeeID));";

        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table Tasks created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
