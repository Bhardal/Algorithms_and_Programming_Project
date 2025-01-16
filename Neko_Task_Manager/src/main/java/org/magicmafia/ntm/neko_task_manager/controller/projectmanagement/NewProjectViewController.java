package org.magicmafia.ntm.neko_task_manager.controller.projectmanagement;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class NewProjectViewController {
    @FXML
    public TextField projectID;
    @FXML
    public TextField projectName;
    @FXML
    public DatePicker projectDeadline;
    @FXML
    public Button closeButton;

    @FXML
    private void onOKButtonClick() {
        String projectIDText = projectID.getText();
        String projectNameText = projectName.getText();
//        LocalDateTime projectDeadlineConverter = projectDeadline;
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

            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
        }
    }
}
