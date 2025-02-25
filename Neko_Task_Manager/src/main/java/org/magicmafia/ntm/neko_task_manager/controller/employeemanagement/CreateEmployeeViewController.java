package org.magicmafia.ntm.neko_task_manager.controller.employeemanagement;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.*;

public class CreateEmployeeViewController {
    @FXML
    public TextField textFieldEmployeeID;
    @FXML
    public TextField textFieldEmployeeName;
    @FXML
    public Button closeButton;

    private EmployeeManagementViewController employeeManagementViewController;

    @FXML
    private void onOKButtonClick() {
        String employeeIDText = textFieldEmployeeID.getText();
        String employeeNameText = textFieldEmployeeName.getText();
        if (employeeIDText.isEmpty() && employeeNameText.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Please enter correct employee information.");
            a.show();
        }else if (employeeIDText.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please enter a correct employee ID.");
            a.show();
        } else if (employeeNameText.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please enter a correct employee name.");
            a.show();
        }else {
            Boolean isInt = true;
            try {
                int employeeIDInt = Integer.parseInt(employeeIDText);
            }
            catch (Exception e) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Please enter a correct employee ID.");
                a.show();
                isInt = false;
            }
            if (isInt) {
                int employeeIDInt = Integer.parseInt(employeeIDText);

                String url = "jdbc:sqlite:mydatabase.db";
                String sql = "INSERT INTO Employees(name, EmployeeID) VALUES(?, ?)";
                Boolean isUniqueID = true;
                try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, employeeNameText);
                    pstmt.setInt(2, employeeIDInt);
                    pstmt.executeUpdate();
                    System.out.println("Data inserted.");
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    if (e.getMessage().contains("UNIQUE constraint failed")) {
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setContentText("Employee ID already exists.");
                        a.show();
                        isUniqueID = false;
                    }
                }
                if (isUniqueID) {
                    employeeManagementViewController.UpdateEmployeeInfo();

                    Stage stage = (Stage) closeButton.getScene().getWindow();
                    stage.close();
                }
            }
        }
    }

    public void setEmployeeManagementViewController(EmployeeManagementViewController employeeManagementViewController) {
        this.employeeManagementViewController = employeeManagementViewController;
    }
}
