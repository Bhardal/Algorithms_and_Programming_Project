package org.magicmafia.ntm.neko_task_manager.controller.projectmanagement;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.*;
import java.time.LocalDate;

public class NewProjectViewController {
    @FXML
    public TextField projectID;
    @FXML
    public TextField projectName;
    @FXML
    public DatePicker projectDeadline;
    @FXML
    public Button closeButton;

    private ProjectManagementViewController projectManagementViewController;

    public void setprojectManagementViewController(ProjectManagementViewController projectManagementViewController) {
        this.projectManagementViewController = projectManagementViewController;
    }

    @FXML
    private void onOKButtonClick() {
        String projectIDText = projectID.getText();
        String projectNameText = projectName.getText();
        LocalDate deadlineDate = projectDeadline.getValue();
        if (projectIDText.isEmpty() && projectNameText.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Please enter correct project information.");
            a.show();
        }else if (projectIDText.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please enter a correct project ID.");
            a.show();
        } else if (projectNameText.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please enter a correct project name.");
            a.show();
        }else {
            int projectIDInt = Integer.parseInt(projectIDText);

            String url = "jdbc:sqlite:mydatabase.db";
            String sql = "INSERT INTO Projects(ProjectName, ProjectID, Deadline) VALUES(?, ?, ?, ?, ?)";
            try (Connection conn = DriverManager.getConnection(url);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, projectNameText);
                pstmt.setInt(2, projectIDInt);
                pstmt.setDate(3, Date.valueOf(deadlineDate));
                pstmt.executeUpdate();
                System.out.println("Data inserted.");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            projectManagementViewController.updateProjectTable();
            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
        }
    }
}
