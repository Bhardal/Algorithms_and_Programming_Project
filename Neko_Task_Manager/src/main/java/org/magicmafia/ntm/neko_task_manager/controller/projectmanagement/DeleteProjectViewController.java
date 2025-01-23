package org.magicmafia.ntm.neko_task_manager.controller.projectmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DeleteProjectViewController {
    @FXML
    public TextField textFieldProjectID;
    @FXML
    public Button closeButton;

    private ProjectManagementViewController projectManagementViewController;

    @FXML
    public void onOKButtonClick() {
        String projectIDText = textFieldProjectID.getText();
        if (projectIDText.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please enter a correct project ID.");
            a.show();
        } else {
            int projectIDInt = Integer.parseInt(projectIDText);

            String url = "jdbc:sqlite:mydatabase.db";
            String sql = "DELETE FROM Projects WHERE ProjectID = (?)";
            try (Connection conn = DriverManager.getConnection(url);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, projectIDInt);
                pstmt.executeUpdate();
                System.out.println("Project deleted.");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            projectManagementViewController.UpdateProjectInfo();

            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
        }
    }

    public void setProjectManagementViewController(ProjectManagementViewController projectManagementViewController) {
        this.projectManagementViewController = projectManagementViewController;
    }
}
