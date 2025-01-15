package org.magicmafia.ntm.neko_task_manager.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.magicmafia.ntm.neko_task_manager.management.Employee;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeManagementViewController implements Initializable {
    @FXML
    public TableView<Employee> employeeTableView;
    @FXML
    public TableColumn<Employee, Integer> employeeIDTableColumn;
    @FXML
    public TableColumn<Employee, String> employeeNameTableColumn;
    @FXML
    public TableColumn<Employee, String> employeeProjectHistoryTableColumn;
    @FXML
    ObservableList<Employee> employeeInfos;


    public ObservableList<Employee> addEmployeeInfo(int ID, String name) {
        employeeInfos = FXCollections.observableArrayList(
            new Employee(ID, name)
        );
        return employeeInfos;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        employeeIDTableColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("Employee ID"));
//
//        employeeNameTableColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("Employee Name"));
//
//        employeeProjectHistoryTableColumn.setCellValueFactory(new PropertyValueFactory<>("Project History (past and present)"));
//
//        employeeTableView.getColumns().addAll(employeeIDTableColumn, employeeNameTableColumn, employeeProjectHistoryTableColumn);
//
//        employeeTableView.setItems(employeeInfos);

    }


    @FXML
    public void onCreateEmployeeClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/magicmafia/ntm/neko_task_manager/create-employee-view.fxml"));
            Parent root = fxmlLoader.load();
            CreateEmployeeViewController controller = fxmlLoader.getController();
            controller.setEmployeeManagementViewController(this);
            Stage calendarView = new Stage();
            calendarView.setScene(new Scene(root));
            calendarView.setTitle("Employee Management");
            calendarView.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
