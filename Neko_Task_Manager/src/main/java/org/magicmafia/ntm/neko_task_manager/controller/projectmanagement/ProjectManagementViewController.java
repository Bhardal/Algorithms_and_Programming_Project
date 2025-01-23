package org.magicmafia.ntm.neko_task_manager.controller.projectmanagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.magicmafia.ntm.neko_task_manager.management.Project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
    public ObservableList<Project> projectList  = FXCollections.observableArrayList();
    @FXML
    public TableView<Project> projectTableView;
    @FXML
    public TableColumn<Project, Integer> projectIDTableColumn;
    @FXML
    public TableColumn<Project, String> projectNameTableColumn;
    @FXML
    public TableColumn<Project, Date> projectDeadlineTableColumn;
    @FXML
    public Tab kanbanViewTab;
    @FXML
    public VBox todoVBox;
    @FXML
    public VBox inProgressVBox;
    @FXML
    public VBox doneVBox;
    @FXML
    public VBox discontinuedVBox;
    @FXML
    public Tab createTaskView;
    @FXML
    public Tab editTaskView;
    @FXML
    public Tab deleteTaskView;
    @FXML
    public TextField textFieldProjectID;
    @FXML
    public TextField textFieldTaskID;
    @FXML
    public DatePicker datePickerTaskDeadline;
    @FXML
    public TextField textFieldTaskPriority;
    @FXML
    public Label labelTaskStatus;
    @FXML
    public TextField textFieldTaskEmployee;
    @FXML
    public TextField textFieldTaskDescription;
    @FXML
    public TextField textFieldTaskComment;
    @FXML
    public Button buttonActionTask;


    public void initialize() {
        projectIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("ProjectID"));
        projectNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("ProjectName"));
        projectDeadlineTableColumn.setCellValueFactory(new PropertyValueFactory<>("Deadline"));
        projectTableView.setItems(projectList);
        UpdateProjectInfo();
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
    public void UpdateProjectInfo() {
        projectList.clear();
        String url = "jdbc:sqlite:mydatabase.db";
        String sql = "SELECT ProjectName, ProjectID, Deadline, Tasks, Employees FROM Projects";
        try (Connection conn = DriverManager.getConnection(url);
             Statement pstmt = conn.createStatement();
             ResultSet rs =  pstmt.executeQuery(sql)){
            while (rs.next()) {
                String name = rs.getString("ProjectName");
                int projectIDTemp = rs.getInt("ProjectID");
                Date deadline = rs.getDate("Deadline");
                String tasks = rs.getString("Tasks");
                String employees = rs.getString("Employees");
                Project project = new Project(projectIDTemp, name, deadline, employees, tasks);
                projectList.add(project);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        projectTableView.setItems(projectList);
    }


    @FXML
    public void onNewProjectClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/magicmafia/ntm/neko_task_manager/project-management-view/new-project-view.fxml"));
            Parent root = fxmlLoader.load();
            Stage newProjectButton = new Stage();
            NewProjectViewController controller = fxmlLoader.getController();
            controller.setProjectManagementViewController(this);
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
            EditProjectViewController controller = fxmlLoader.getController();
            controller.setProjectManagementViewController(this);
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
            DeleteProjectViewController controller = fxmlLoader.getController();
            controller.setProjectManagementViewController(this);
            deleteProjectButton.setTitle("Main Menu");
            deleteProjectButton.setScene(new Scene(root));
            deleteProjectButton.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void onButtonActionTask() {
    }


    @FXML
    public void updateTaskInfo() {
        todoVBox.getChildren().clear();
        inProgressVBox.getChildren().clear();
        doneVBox.getChildren().clear();
        discontinuedVBox.getChildren().clear();

        // String url = "jdbc:sqlite:mydatabase.db";
        // String sql = "INSERT INTO Tasks(TaskID, Priority, Status, Deadline, Comment, Description, ProjectID, EmployeeID) VALUES(?, ?, ?, ?, ?, ?, (SELECT ProjectID FROM Projects WHERE ProjectID = ?), (SELECT EmployeeID FROM Employees WHERE EmployeeID = ?))";
        // try (Connection conn = DriverManager.getConnection(url);
        //     PreparedStatement pstmt = conn.prepareStatement(sql)) {
        //     pstmt.setInt(1, taskIDInt);
        //     pstmt.setInt(2, priorityInt);
        //     pstmt.setString(3, statusText);
        //     pstmt.setDate(4, deadlineDate);
        //     pstmt.setString(5, commentText);
        //     pstmt.setString(6, descriptionText);
        //     pstmt.setInt(7, thisProjectID);
        //     pstmt.setInt(8, selectedEmployeeIDInt)
        //     pstmt.executeUpdate();
        //     System.out.println("Data inserted.");
        // } catch (SQLException e) {
        //     System.out.println(e.getMessage());
        // }

    }
}
