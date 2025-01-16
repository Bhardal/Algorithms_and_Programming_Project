package org.magicmafia.ntm.neko_task_manager.controller.employeemanagement;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditEmployeeView2Controller implements Initializable {
    @FXML
    public TextField textFieldNewEmployeeName;
    @FXML
    public ObservableList<String> projectList;
    @FXML
    public Button closeButton;
    private int OldEmployeeIDInt;
    private EditEmployeeViewController editEmployeeViewController;

    @FXML
    private void onOKButtonClick() {
        String newEmployeeNameText = textFieldNewEmployeeName.getText();
        if (newEmployeeNameText.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please enter a correct employee Name.");
            a.show();
        }else {
            String url = "jdbc:sqlite:mydatabase.db";
            String sql = "DELETE FROM employees WHERE EmployeeID = (?); INSERT INTO Employees(name, EmployeeID, Projects) VALUES(?, ?, ?)";
            try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, OldEmployeeIDInt);
                pstmt.setString(2, newEmployeeNameText);
                pstmt.setInt(3, OldEmployeeIDInt);
                pstmt.setString(4, ProjectList);
                pstmt.executeUpdate();
                System.out.println("Data updated.");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
        }
    }


    public void setOldEmployeeIDInt(int oldEmployeeIDInt) {
        this.OldEmployeeIDInt = oldEmployeeIDInt;
    }

    public void setEditEmployeeViewController(EditEmployeeViewController editEmployeeViewController) {
        this.editEmployeeViewController = editEmployeeViewController;
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        String url = "jdbc:sqlite:mydatabase.db";
        String sql = "SELECT Name FROM employees WHERE EmployeeID = "+OldEmployeeIDInt+";";
        String name;
        try (Connection conn = DriverManager.getConnection(url);
             Statement pstmt = conn.createStatement()    ;
             ResultSet rs =  pstmt.executeQuery(sql)){
            name = rs.getString("name");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
