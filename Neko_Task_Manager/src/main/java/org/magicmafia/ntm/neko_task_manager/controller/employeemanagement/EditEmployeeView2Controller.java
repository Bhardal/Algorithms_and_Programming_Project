package org.magicmafia.ntm.neko_task_manager.controller.employeemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditEmployeeView2Controller{
    @FXML
    public TextField textFieldNewEmployeeName;
    @FXML
    public ObservableList<String> projectList;
    @FXML
    public Button closeButton;
    public static int OldEmployeeIDInt;

    private EditEmployeeViewController editEmployeeViewController;

    @FXML
    private void onOKButtonClick() {
        String newEmployeeNameText = textFieldNewEmployeeName.getText();
        if (newEmployeeNameText.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please enter a correct employee Name.");
            a.show();
        }else {
//            String ProjectList = String.join(",", projectList);
            String url = "jdbc:sqlite:mydatabase.db";
            String sql = "DELETE FROM employees WHERE EmployeeID = (?)";
            try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, OldEmployeeIDInt);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            sql = "INSERT INTO Employees(name, EmployeeID) VALUES(?, ?)";
            try (Connection conn = DriverManager.getConnection(url);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, newEmployeeNameText);
                pstmt.setInt(2, OldEmployeeIDInt);
//                pstmt.setString(4, ProjectList);
                pstmt.executeUpdate();
                System.out.println("Data updated.");
                editEmployeeViewController.UpdateEmployeeInfo();
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


    public void initialize() {
        String url = "jdbc:sqlite:mydatabase.db";
        String sql = "SELECT Name, EmployeeID FROM Employees WHERE EmployeeID = "+this.OldEmployeeIDInt+";";
        String name = "this is the name of the person";
        try (Connection conn = DriverManager.getConnection(url);
             Statement pstmt = conn.createStatement()    ;
             ResultSet rs =  pstmt.executeQuery(sql)){
            name = rs.getString("Name");
            System.out.println(name);
            System.out.println(this.OldEmployeeIDInt);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        textFieldNewEmployeeName.setText(name);
    }
}
