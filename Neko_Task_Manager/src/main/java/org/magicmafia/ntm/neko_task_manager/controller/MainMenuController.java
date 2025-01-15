package org.magicmafia.ntm.neko_task_manager.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {
    @FXML
    public void onKanbanViewButtonClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/magicmafia/ntm/neko_task_manager/kanban-view.fxml"));
            Parent root = fxmlLoader.load();
            Stage kanbanView = new Stage();
            kanbanView.setScene(new Scene(root));
            kanbanView.setTitle("kanban");
            kanbanView.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onCalendarViewButtonClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/magicmafia/ntm/neko_task_manager/calendar-view.fxml"));
            Parent root = fxmlLoader.load();
            Stage calendarView = new Stage();
            calendarView.setScene(new Scene(root));
            calendarView.setTitle("Calendar");
            calendarView.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onProjectManagementViewButtonClick(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/magicmafia/ntm/neko_task_manager/project-management-view.fxml"));
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/magicmafia/ntm/neko_task_manager/employee-management-view.fxml"));
            Parent root = fxmlLoader.load();
            Stage EmployeeManagementView = new Stage();
            EmployeeManagementView.setScene(new Scene(root));
            EmployeeManagementView.setTitle("Employee Management");
            EmployeeManagementView.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
