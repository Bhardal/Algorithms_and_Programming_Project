package org.magicmafia.ntm.neko_task_manager.controller.employeemanagement;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.*;

public class DeleteEmployeeViewController {
    @FXML
    public TextField textFieldEmployeeID;
    @FXML
    public Button closeButton;

    private EmployeeManagementViewController employeeManagementViewController;

    public void setEmployeeManagementViewController(EmployeeManagementViewController employeeManagementViewController) {
        this.employeeManagementViewController = employeeManagementViewController;
    }


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
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
        }
    }
}
