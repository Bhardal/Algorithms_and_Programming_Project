package org.magicmafia.ntm.neko_task_manager.controller.employeemanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.magicmafia.ntm.neko_task_manager.management.Employee;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EmployeeManagementViewController implements Initializable {
    @FXML
    public TableView<String> employeeTableView;
    @FXML
    public TableColumn<String, Integer> employeeIDTableColumn;
    @FXML
    public TableColumn<String, String> employeeNameTableColumn;
    @FXML
    public TableColumn<String, String> employeeProjectHistoryTableColumn;
    @FXML
    public ObservableList<String> employeeInfos;
    @FXML
    public Button backButton;


    public void UpdateEmployeeInfo() {
        employeeInfos = FXCollections.observableArrayList();
        String url = "jdbc:sqlite:mydatabase.db";
        String sql = "SELECT Name, EmployeeID, Projects FROM Employees;";
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<Integer> employeeIDs = new ArrayList<Integer>();
        ArrayList<String> projects = new ArrayList<String>();
        try (Connection conn = DriverManager.getConnection(url);
             Statement pstmt = conn.createStatement();
             ResultSet rs =  pstmt.executeQuery(sql)){
            while (rs.next()) {
                names.add(rs.getString("Name"));
                employeeIDs.add(rs.getInt("EmployeeID"));
                projects.add(rs.getString("Projects"));
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        employeeIDTableColumn.setCellValueFactory(new PropertyValueFactory<String, Integer>("Employee ID"));
        employeeNameTableColumn.setCellValueFactory(new PropertyValueFactory<String, String>("Employee Name"));
        employeeProjectHistoryTableColumn.setCellValueFactory(new PropertyValueFactory<>("Project History (past and present)"));
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
