package org.magicmafia.ntm.neko_task_manager.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import org.magicmafia.ntm.neko_task_manager.DatabaseManagement;

public class MainMenuController {
    @FXML
    public Button projectManagementButton;
    @FXML
    public Button employeeManagementButton;

    @FXML
    public void onProjectManagementViewButtonClick(){
        try {
            Stage stage = (Stage) projectManagementButton.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/magicmafia/ntm/neko_task_manager/project-management-view/project-management-view.fxml"));
            Parent root = fxmlLoader.load();
            Stage ProjectManagementView = new Stage();
            ProjectManagementView.setScene(new Scene(root));
            ProjectManagementView.setTitle("Project Management");
            ProjectManagementView.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onEmployeeManagementViewButtonClick(){
        try {
            Stage stage = (Stage) employeeManagementButton.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/magicmafia/ntm/neko_task_manager/employee-management-view/employee-management-view.fxml"));
            Parent root = fxmlLoader.load();
            Stage EmployeeManagementView = new Stage();
            EmployeeManagementView.setScene(new Scene(root));
            EmployeeManagementView.setTitle("Employee Management");
            EmployeeManagementView.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void onResetButtonClick(){
        DatabaseManagement.TablesDrop();
        DatabaseManagement.TablesCreate();
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Database reset.");
        a.show();
    }


    @FXML
    public void onExitButtonClick(){
        Stage stage = (Stage) projectManagementButton.getScene().getWindow();
        stage.close();
    }
