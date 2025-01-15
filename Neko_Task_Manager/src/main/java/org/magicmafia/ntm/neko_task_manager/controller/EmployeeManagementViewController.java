package org.magicmafia.ntm.neko_task_manager.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.magicmafia.ntm.neko_task_manager.management.Employee;

import java.io.IOException;
import java.util.ArrayList;

public class EmployeeManagementViewController {
    @FXML
    private TableView<Employee> employeeTableView;
    @FXML
    private TableColumn<Employee, Integer> employeeIDTableColumn;
    @FXML
    private TableColumn<Employee, String> employeeNameTableColumn;
    @FXML
    private ObservableList<Employee> employeeObservableList = FXCollections.observableArrayList();


    @FXML
    private void initialize() {
        employeeIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("Employee ID"));
        employeeNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("Employee Name"));

        employeeTableView.setItems(employeeObservableList);
    }


    @FXML
    public void setEmployeeInfo(String id, String name) {
        Integer tempEmployeeID = Integer.valueOf(id);
        employeeObservableList.add(new Employee(tempEmployeeID, name));
    }


    @FXML
    private void onCreateEmployeeClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/magicmafia/ntm/neko_task_manager/create-employee-view.fxml"));
            Parent root = fxmlLoader.load();
            Stage calendarView = new Stage();
            calendarView.setScene(new Scene(root));
            calendarView.setTitle("Employee Management");
            calendarView.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
