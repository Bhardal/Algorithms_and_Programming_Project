package org.magicmafia.ntm.neko_task_manager.controller.employeemanagement;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditEmployeeViewController {
    @FXML
    public TextField textFieldOldEmployeeID;
    @FXML
    public TextField textFieldNewEmployeeID;
    @FXML
    public TextField textFieldNewEmployeeName;
    @FXML
    public Button closeButton;

    private EmployeeManagementViewController employeeManagementViewController;

    @FXML
    private void onOKButtonClick() {
        String oldEmployeeIDText = textFieldOldEmployeeID.getText();
        String newEmployeeIDText = textFieldNewEmployeeID.getText();
        String newEmployeeNameText = textFieldNewEmployeeName.getText();
        if (oldEmployeeIDText.isEmpty() && newEmployeeIDText.isEmpty() && newEmployeeNameText.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Please enter correct employee information.");
            a.show();
        }else if (oldEmployeeIDText.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please enter a correct employee ID.");
            a.show();
        }else if (newEmployeeIDText.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please enter a correct employee ID.");
            a.show();
        }else if (newEmployeeNameText.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please enter a correct employee Name.");
            a.show();
        }else {
            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
        }
    }

    public void setEmployeeManagementViewController(EmployeeManagementViewController employeeManagementViewController) {
        this.employeeManagementViewController = employeeManagementViewController;
    }
}
