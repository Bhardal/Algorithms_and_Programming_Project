package org.magicmafia.ntm.neko_task_manager.controller.projectmanagement;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.magicmafia.ntm.neko_task_manager.management.Project;

import java.io.IOException;
import java.sql.*;

public class ProjectManagementViewController{
    @FXML
    public MenuItem newProject;
    @FXML
    public MenuItem editProject;
    @FXML
    public MenuItem deleteProject;
    @FXML
    public MenuItem newTask;
    @FXML
    public MenuItem editTask;
    @FXML
    public MenuItem deleteTask;
    @FXML
    public MenuItem assignTaskToStaff;
    @FXML
    public Button backButton;
    @FXML
    public ObservableList<Project> projectList;


    @FXML
    public ObservableList<Project> updateProjectInfo() {
        String url = "jdbc:sqlite:mydatabase.db";
        String sql = "SELECT ProjectName, ProjectID, Deadline FROM Projects";
        String name;
        int projectIDTemp;
        Date deadline;
        try (Connection conn = DriverManager.getConnection(url);
             Statement pstmt = conn.createStatement();
             ResultSet rs =  pstmt.executeQuery(sql)){
            while (rs.next()) {
                name = rs.getString("ProjectName");
                projectIDTemp = rs.getInt("ProjectID");
                deadline = rs.getDate("Deadline");

                projectList.add(new Project(name, projectIDTemp, deadline));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return projectList;
    }


    @FXML
    public void onNewProjectClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/magicmafia/ntm/neko_task_manager/project-management-view/new-project-view.fxml"));
            Parent root = fxmlLoader.load();
            Stage newProjectButton = new Stage();
            newProjectButton.setTitle("Main Menu");
            newProjectButton.setScene(new Scene(root));
            newProjectButton.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void onEditProjectClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/magicmafia/ntm/neko_task_manager/project-management-view/edit-project-view.fxml"));
            Parent root = fxmlLoader.load();
            Stage editProjectButton = new Stage();
            editProjectButton.setTitle("Main Menu");
            editProjectButton.setScene(new Scene(root));
            editProjectButton.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void onDeleteProjectClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/magicmafia/ntm/neko_task_manager/project-management-view/delete-project-view.fxml"));
            Parent root = fxmlLoader.load();
            Stage deleteProjectButton = new Stage();
            deleteProjectButton.setTitle("Main Menu");
            deleteProjectButton.setScene(new Scene(root));
            deleteProjectButton.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void onNewTaskClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/magicmafia/ntm/neko_task_manager/project-management-view/new-task-view.fxml"));
            Parent root = fxmlLoader.load();
            Stage newTaskButton = new Stage();
            newTaskButton.setTitle("Main Menu");
            newTaskButton.setScene(new Scene(root));
            newTaskButton.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void onEditTaskClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/magicmafia/ntm/neko_task_manager/project-management-view/edit-task-view.fxml"));
            Parent root = fxmlLoader.load();
            Stage editTaskButton = new Stage();
            editTaskButton.setTitle("Main Menu");
            editTaskButton.setScene(new Scene(root));
            editTaskButton.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void onDeleteTaskClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/magicmafia/ntm/neko_task_manager/project-management-view/delete-task-view.fxml"));
            Parent root = fxmlLoader.load();
            Stage deleteTaskButton = new Stage();
            deleteTaskButton.setTitle("Main Menu");
            deleteTaskButton.setScene(new Scene(root));
            deleteTaskButton.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void onAssignTaskToStaffClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/magicmafia/ntm/neko_task_manager/project-management-view/assign-task-to-staff-view.fxml"));
            Parent root = fxmlLoader.load();
            Stage assignTaskToStaffButton = new Stage();
            assignTaskToStaffButton.setTitle("Main Menu");
            assignTaskToStaffButton.setScene(new Scene(root));
            assignTaskToStaffButton.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void onBackButtonClick() {
        try {
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/magicmafia/ntm/neko_task_manager/project-management-view/main-menu.fxml"));
            Parent root = fxmlLoader.load();
            Stage backButton = new Stage();
            backButton.setTitle("Main Menu");
            backButton.setScene(new Scene(root));
            backButton.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void updateProjectTable() {
        TableView<Project> projectTableView = new TableView<>();
        TableColumn<Project, Integer> projectIDTableColumn = new TableColumn<>("Project ID");
        projectIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("projectIDTemp"));
        TableColumn<Project, String> projectNameTableColumn = new TableColumn<>("Project Name");
        projectNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("projectIDTemp"));
        TableColumn<Project, String> projectDeadlineTableColumn = new TableColumn<>("Project Deadline");
        projectDeadlineTableColumn.setCellValueFactory(new PropertyValueFactory<>("projectIDTemp"));

        projectTableView.getColumns().addAll(projectIDTableColumn, projectNameTableColumn, projectDeadlineTableColumn);

        projectList = updateProjectInfo();
    }
}
