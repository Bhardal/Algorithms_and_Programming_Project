package org.magicmafia.ntm.neko_task_manager.controller.employeemanagement;

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
            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
        }
    }
}
