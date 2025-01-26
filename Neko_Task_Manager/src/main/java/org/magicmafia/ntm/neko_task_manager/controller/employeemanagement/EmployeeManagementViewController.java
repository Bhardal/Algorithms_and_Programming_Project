package org.magicmafia.ntm.neko_task_manager.controller.employeemanagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.magicmafia.ntm.neko_task_manager.management.Employee;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class EmployeeManagementViewController {
    @FXML
    public TableView<Employee> employeeTableView;
    @FXML
    public TableColumn<Employee, Integer> employeeIDTableColumn;
    @FXML
    public TableColumn<Employee, String> employeeNameTableColumn;
    @FXML
    public TableColumn<Employee, String> employeeProjectHistoryTableColumn;
    @FXML
    public ObservableList<Employee> employeeInfos = FXCollections.observableArrayList();
    @FXML
    public Button backButton;


    public void initialize() {
        employeeIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        employeeNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        employeeProjectHistoryTableColumn.setCellValueFactory(new PropertyValueFactory<>("projects"));
        employeeTableView.setItems(employeeInfos);
        UpdateEmployeeInfo();
    }


    public void UpdateEmployeeInfo() {
        employeeInfos.clear();
        String url = "jdbc:sqlite:mydatabase.db";
        String sql = "SELECT Name, EmployeeID FROM Employees;";
        String sql1, sql2;
        try (Connection conn = DriverManager.getConnection(url);
             Statement pstmt = conn.createStatement();
             ResultSet rs =  pstmt.executeQuery(sql)){
            while (rs.next()) {
                int employeeID = rs.getInt("EmployeeID");
                String name = rs.getString("Name");
                Employee employee = new Employee(employeeID, name);
                
                sql1 = "SELECT ProjectID FROM Tasks WHERE EmployeeID = "+employeeID+";";
                try (Statement pstmt1 = conn.createStatement();
                    ResultSet rs1 =  pstmt1.executeQuery(sql1)) {
                    while (rs1.next()) {
                        int projectID = rs1.getInt("ProjectID");
                        sql2 = "SELECT ProjectName FROM Projects WHERE ProjectID = " + projectID + ";";
                        try (Statement pstmt2 = conn.createStatement();
                            ResultSet rs2 =  pstmt2.executeQuery(sql2)) {
                            while (rs2.next()) {
                                String projectName = rs2.getString("ProjectName");
                                employee.addProject(projectName);
                            }
                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                employeeInfos.add(employee);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

//       String sql2;
//       for (String workedProjectsList : projectIDs) {
//           String[] workedProjectIDs = workedProjectsList.split(",");
//           for (String id : workedProjectIDs) {
//               sql2 = "SELECT ProjectName FROM Projects WHERE ProjectID = " + id + ";";
//               try (Connection conn = DriverManager.getConnection(url);
//                    Statement pstmt = conn.createStatement();
//                    ResultSet rs =  pstmt.executeQuery(sql2)){
//                   projectNames.add(rs.getString("ProjectName"));
//               } catch (SQLException e) {
//                   System.out.println(e.getMessage());
//               }
//           }
//       }
        employeeTableView.setItems(employeeInfos);
    }


    @FXML
    public void onBackButtonClick() {
        try {
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/magicmafia/ntm/neko_task_manager/main-menu.fxml"));
            Parent root = fxmlLoader.load();
            Stage backButton = new Stage();
            backButton.setTitle("Main Menu");
            backButton.setScene(new Scene(root));
            backButton.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void onCreateEmployeeClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/magicmafia/ntm/neko_task_manager/employee-management-view/create-employee-view.fxml"));
            Parent root = fxmlLoader.load();
            CreateEmployeeViewController controller = fxmlLoader.getController();
            controller.setEmployeeManagementViewController(this);
            Stage createEmployeeView = new Stage();
            createEmployeeView.setScene(new Scene(root));
            createEmployeeView.setTitle("Create Employee");
            createEmployeeView.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void onEditEmployeeClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/magicmafia/ntm/neko_task_manager/employee-management-view/edit-employee-view.fxml"));
            Parent root = fxmlLoader.load();
            EditEmployeeViewController controller = fxmlLoader.getController();
            controller.setEmployeeManagementViewController(this);
            Stage editEmployeeView = new Stage();
            editEmployeeView.setScene(new Scene(root));
            editEmployeeView.setTitle("Edit Employee");
            editEmployeeView.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void onDeleteEmployeeClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/magicmafia/ntm/neko_task_manager/employee-management-view/delete-employee-view.fxml"));
            Parent root = fxmlLoader.load();
            DeleteEmployeeViewController controller = fxmlLoader.getController();
            controller.setEmployeeManagementViewController(this);
            Stage deleteEmployeeView = new Stage();
            deleteEmployeeView.setScene(new Scene(root));
            deleteEmployeeView.setTitle("Delete Employee");
            deleteEmployeeView.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
