package org.magicmafia.ntm.neko_task_manager.controller.projectmanagement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditProjectView2Controller {
    @FXML
    public TextField textFieldNewProjectName;
    @FXML
    public DatePicker datePickerNewProjectDeadline;
    @FXML
    public TextField textFieldNewProjectEmployees;
    @FXML
    public Button closeButton;
    
    public static int OldProjectIDInt;
    private EditProjectViewController editProjectViewController;

    @FXML
    private void onOKButtonClick() {
        String newProjectNameText = textFieldNewProjectName.getText();
        LocalDate newProjectDeadline = datePickerNewProjectDeadline.getValue();
        if (newProjectNameText.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please enter a correct project Name.");
            a.show();
        }else {
            String url = "jdbc:sqlite:mydatabase.db";
            String sql = "DELETE FROM Projects WHERE ProjectID = (?)";
            try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, OldProjectIDInt);
                pstmt.executeUpdate();
                } catch (SQLException e) {
                System.out.println(e.getMessage());
                }
            sql = "INSERT INTO Projects (ProjectName, ProjectID, Deadline) VALUES (?, ?, ?)";
            try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, newProjectNameText);
                pstmt.setInt(2, OldProjectIDInt);
                pstmt.setDate(3, Date.valueOf(newProjectDeadline));
                pstmt.executeUpdate();
                System.out.println("Data updated.");
                editProjectViewController.UpdateProjectInfo();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
        }
    }

    public void setEditProjectViewController(EditProjectViewController editProjectViewController) {
        this.editProjectViewController = editProjectViewController;
    }

    public void setOldProjectIDInt(int oldProjectIDInt) {
        this.OldProjectIDInt = oldProjectIDInt;
    }

    public void initialize() {
        String url = "jdbc:sqlite:mydatabase.db";
        String sql = "SELECT ProjectName, Deadline FROM Projects WHERE ProjectID = "+this.OldProjectIDInt+";";
        String projectName = "";
        Date deadline = null;
        try (Connection conn = DriverManager.getConnection(url);
            Statement pstmt = conn.createStatement();
            ResultSet rs = pstmt.executeQuery(sql)) {
                projectName = rs.getString("ProjectName");
                deadline = rs.getDate("Deadline");
                System.out.println("Project name: "+projectName);
                System.out.println("Deadline: "+deadline);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if (deadline != null) {
            datePickerNewProjectDeadline.setValue(deadline.toLocalDate());
        }
        textFieldNewProjectName.setText(projectName);
    }
}
