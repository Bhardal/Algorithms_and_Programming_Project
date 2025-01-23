package org.magicmafia.ntm.neko_task_manager.controller.projectmanagement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

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
            String sql = "DELETE FROM Projects WHERE ProjectID = (?); INSERT INTO Projects (ProjectName, ProjectID, Deadline) VALUES(?, ?, ?)";
            try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, OldProjectIDInt);
                pstmt.setString(2, newProjectNameText);
                pstmt.setInt(3, OldProjectIDInt);
                pstmt.setDate(4, Date.valueOf(newProjectDeadline));
                pstmt.executeUpdate();
                System.out.println("Data updated.");
                editProjectViewController.updateProjectInfo();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void setEditProjectViewController(EditProjectViewController editProjectViewController) {
        this.editProjectViewController = editProjectViewController;
    }

    public void setOldProjectIDInt(int oldProjectIDInt) {
        this.OldProjectIDInt = oldProjectIDInt;
    }
}
