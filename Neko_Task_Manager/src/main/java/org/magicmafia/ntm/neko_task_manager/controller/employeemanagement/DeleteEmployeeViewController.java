package org.magicmafia.ntm.neko_task_manager.controller.employeemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DeleteEmployeeViewController {
    @FXML
    public TextField textFieldEmployeeID;
    @FXML
    public Button closeButton;

    private EmployeeManagementViewController employeeManagementViewController;


    @FXML
    public void onOKButtonClick() {
        String employeeIDText = textFieldEmployeeID.getText();
        if (employeeIDText.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please enter a correct employee ID.");
            a.show();
        }else {
            int employeeIDInt = Integer.parseInt(employeeIDText);

            String url = "jdbc:sqlite:mydatabase.db";
            String sql = "DELETE FROM Employees WHERE EmployeeID = (?);";
            try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, employeeIDInt);
                pstmt.executeUpdate();
                System.out.println("Employee Deleted.... \nDamn that was dark.");
                employeeManagementViewController.UpdateEmployeeInfo();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
        }
    }

    public void setEmployeeManagementViewController(EmployeeManagementViewController employeeManagementViewController) {
        this.employeeManagementViewController = employeeManagementViewController;
    }
}
