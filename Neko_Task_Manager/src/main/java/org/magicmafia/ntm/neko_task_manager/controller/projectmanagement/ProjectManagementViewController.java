package org.magicmafia.ntm.neko_task_manager.controller.projectmanagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.magicmafia.ntm.neko_task_manager.management.Project;
import org.magicmafia.ntm.neko_task_manager.management.Task;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.MenuButton;
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
    public VBox todoVBox, inProgressVBox, doneVBox, discontinuedVBox;
    @FXML
    public Tab createTaskView, editTaskView, deleteTaskView;
    @FXML
    public TextField textFieldNewProjectID, textFieldEditProjectID, textFieldDeleteProjectID;
    @FXML
    public TextField textFieldNewTaskID, textFieldEditTaskID, textFieldDeleteTaskID;
    @FXML
    public DatePicker datePickerNewTaskDeadline, datePickerEditTaskDeadline;
    @FXML
    public TextField textFieldNewTaskPriority, textFieldEditTaskPriority;
    @FXML
    public TextField textFieldNewTaskEmployee, textFieldEditTaskEmployee;
    @FXML
    public TextField textFieldNewTaskDescription, textFieldEditTaskDescription;
    @FXML
    public TextField textFieldNewTaskComment, textFieldEditTaskComment;
    @FXML
    public Button buttonNewTask, buttonEditTask, buttonDeleteTask;
    @FXMl
    public MenuButton statusMenuButton;
    @FXML
    public MenuItem toDoMenuItem, inProgressMenuItem, doneMenuItem, discontinuedMenuItem;

    public ArrayList<Task> listTasks = new ArrayList<>();


    public void initialize() {
        projectIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("ProjectID"));
        projectNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("ProjectName"));
        projectDeadlineTableColumn.setCellValueFactory(new PropertyValueFactory<>("Deadline"));
        projectTableView.setItems(projectList);

        // MenuItem toDoMenuItem = new MenuItem("To Do");
        // MenuItem inProgressMenuItem = new MenuItem("In Progress");
        // MenuItem doneMenuItem = new MenuItem("Done");
        // MenuItem discontinuedMenuItem = new MenuItem("Discontinued");
        // statusMenuButton.getItems().addAll(toDoMenuItem, inProgressMenuItem, doneMenuItem, discontinuedMenuItem);

        UpdateProjectInfo();
        UpdateTaskList();
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
            newProjectButton.setTitle("New project");
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
            editProjectButton.setTitle("Edit project");
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
            // DeleteProjectViewController controller = fxmlLoader.getController();
            // controller.setProjectManagementViewController(this);
            deleteProjectButton.setTitle("Delete project");
            deleteProjectButton.setScene(new Scene(root));
            deleteProjectButton.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void onButtonNewTaskClick() {
        String projectIDText = textFieldNewProjectID.getText();
        int projectIDInt = Integer.parseInt(projectIDText);
        String taskIDText = textFieldNewTaskID.getText();
        int taskIDInt = Integer.parseInt(taskIDText);
        String priorityText = textFieldNewTaskPriority.getText();
        int priorityInt = Integer.parseInt(priorityText);
        String statusText = "To Do";
        Date deadlineDate = Date.valueOf(datePickerNewTaskDeadline.getValue());
        String commentText = textFieldNewTaskComment.getText();
        String descriptionText = textFieldNewTaskDescription.getText();
        String selectedEmployeeIDText = textFieldNewTaskEmployee.getText();
        int selectedEmployeeIDInt = Integer.parseInt(selectedEmployeeIDText);

        String url = "jdbc:sqlite:mydatabase.db";
        String sql = "INSERT INTO Tasks(TaskID, Priority, Status, Deadline, Comment, Description, ProjectID, EmployeeID) VALUES(?, ?, ?, ?, ?, ?, (SELECT ProjectID FROM Projects WHERE ProjectID = ?), (SELECT EmployeeID FROM Employees WHERE EmployeeID = ?))";
        Boolean isUniqueID = true;
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, taskIDInt); 
            pstmt.setInt(2, priorityInt);
            pstmt.setString(3, statusText);
            pstmt.setDate(4, deadlineDate);
            pstmt.setString(5, commentText);
            pstmt.setString(6, descriptionText);
            pstmt.setInt(7, projectIDInt);
            pstmt.setInt(8, selectedEmployeeIDInt);
            pstmt.executeUpdate();
            System.out.println("Data inserted.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            if (e.getMessage().contains("UNIQUE constraint failed")) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Task ID already exists.");
                a.show();
                isUniqueID = false;
            }
        }

        if (isUniqueID) {
            UpdateTaskList();
        }
    }


    @FXML
    public void onButtonEditTaskClick() {
        String projectIDText = textFieldEditProjectID.getText();
        int projectIDInt = Integer.parseInt(projectIDText);
        String taskIDText = textFieldEditTaskID.getText();
        int taskIDInt = Integer.parseInt(taskIDText);
        String priorityText = textFieldEditTaskPriority.getText();
        int priorityInt = Integer.parseInt(priorityText);
        Date deadlineDate = Date.valueOf(datePickerEditTaskDeadline.getValue());
        String commentText = textFieldEditTaskComment.getText();
        String descriptionText = textFieldEditTaskDescription.getText();
        String selectedEmployeeIDText = textFieldEditTaskEmployee.getText();
        int selectedEmployeeIDInt = Integer.parseInt(selectedEmployeeIDText);
        String statusText = "";
        toDoMenuItem.setOnAction(event -> statusText = "To Do");
        inProgressMenuItem.setOnAction(event -> statusText = "In Progress");
        doneMenuItem.setOnAction(event -> statusText = "Done");
        discontinuedMenuItem.setOnAction(event -> statusText = "Discontinued");

        String url = "jdbc:sqlite:mydatabase.db";
        String sql = "DELETE FROM Tasks WHERE TaskID = ?";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, taskIDInt);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        sql = "INSERT INTO Tasks(TaskID, Priority, Status, Deadline, Comment, Description, ProjectID, EmployeeID) VALUES(?, ?, ?, ?, ?, ?, (SELECT ProjectID FROM Projects WHERE ProjectID = ?), (SELECT EmployeeID FROM Employees WHERE EmployeeID = ?))";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, taskIDInt); 
            pstmt.setInt(2, priorityInt);
            pstmt.setString(3, statusText);
            pstmt.setDate(4, deadlineDate);
            pstmt.setString(5, commentText);
            pstmt.setString(6, descriptionText);
            pstmt.setInt(7, projectIDInt);
            pstmt.setInt(8, selectedEmployeeIDInt);
            pstmt.executeUpdate();
            System.out.println("Data updated.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        UpdateTaskList();
    }


    @FXML
    public void onButtonDeleteTaskClick() {
        String taskIDText = textFieldDeleteTaskID.getText();
        int taskIDInt = Integer.parseInt(taskIDText);

        String url = "jdbc:sqlite:mydatabase.db";
        String sql = "DELETE FROM Tasks WHERE TaskID = (?);";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, taskIDInt);
            pstmt.executeUpdate();
            System.out.println("Task Deleted.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        UpdateTaskList();
    }


    @FXML
    public void UpdateTaskList() {
        listTasks.clear();
        String url = "jdbc:sqlite:mydatabase.db";
        String sql = "SELECT TaskID, Priority, Status, Deadline, Comment, Description, ProjectID, EmployeeID FROM Tasks";
        try (Connection conn = DriverManager.getConnection(url);
             Statement pstmt = conn.createStatement();
             ResultSet rs =  pstmt.executeQuery(sql)){
            while (rs.next()) {
                int taskIDTemp = rs.getInt("TaskID");
                int priorityTemp = rs.getInt("Priority");
                String statusTemp = rs.getString("Status");
                Date deadlineTemp = rs.getDate("Deadline");
                String commentTemp = rs.getString("Comment");
                String descriptionTemp = rs.getString("Description");
                int projectIDTemp = rs.getInt("ProjectID");
                int employeeIDTemp = rs.getInt("EmployeeID");
                Task task = new Task(taskIDTemp, priorityTemp, statusTemp, deadlineTemp, commentTemp, descriptionTemp, projectIDTemp, employeeIDTemp);
                listTasks.add(task);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        displayTasks(listTasks);
    }

    @FXML
    public void displayTasks(ArrayList<Task> listTasks) {
        todoVBox.getChildren().clear();
        inProgressVBox.getChildren().clear();
        doneVBox.getChildren().clear();
        discontinuedVBox.getChildren().clear();
        for (Task task : listTasks) {
            Button taskDescriptionButton = new Button(task.getDescription());
            taskDescriptionButton.setOnMouseClicked(event -> displayTaskDetails(task));
            switch (task.getStatus()) {
                case "To Do":
                    todoVBox.getChildren().add(taskDescriptionButton);
                    break;
                case "In Progress":
                    inProgressVBox.getChildren().add(taskDescriptionButton);
                    break;
                case "Done":
                    doneVBox.getChildren().add(taskDescriptionButton);
                    break;
                case "Discontinued":
                    discontinuedVBox.getChildren().add(taskDescriptionButton);
                    break;
            }
        }
    }

    private void displayTaskDetails(Task task) {
        textFieldEditProjectID.setText(String.valueOf(task.getProjectID()));
        textFieldEditTaskID.setText(String.valueOf(task.getTaskID()));
        datePickerEditTaskDeadline.setValue(task.getDueDate().toLocalDate());
        textFieldEditTaskPriority.setText(String.valueOf(task.getPriority()));
        labelEditTaskStatus.setText(task.getStatus());
        textFieldEditTaskComment.setText(task.getComment());
        textFieldEditTaskDescription.setText(task.getDescription());
        textFieldEditTaskEmployee.setText(String.valueOf(task.getEmployeeID()));

        textFieldDeleteProjectID.setText(String.valueOf(task.getProjectID()));
        textFieldDeleteTaskID.setText(String.valueOf(task.getTaskID()));
    }

    @FXML
    public void onCreateTaskViewClick() {
        textFieldNewProjectID.clear();
        textFieldNewTaskID.clear();
        datePickerNewTaskDeadline.setValue(null);
        textFieldNewTaskPriority.clear();
        textFieldNewTaskComment.clear();
        textFieldNewTaskDescription.clear();
        textFieldNewTaskEmployee.clear();
    }

    @FXML
    public void onEditTaskViewClick() {
        textFieldEditProjectID.clear();
        textFieldEditTaskID.clear();
        datePickerEditTaskDeadline.setValue(null);
        textFieldEditTaskPriority.clear();
        labelEditTaskStatus.setText("");
        textFieldEditTaskComment.clear();
        textFieldEditTaskDescription.clear();
        textFieldEditTaskEmployee.clear();
    }

    @FXML
    public void onDeleteTaskViewClick() {
        textFieldDeleteProjectID.clear();
        textFieldDeleteTaskID.clear();
    }
}
