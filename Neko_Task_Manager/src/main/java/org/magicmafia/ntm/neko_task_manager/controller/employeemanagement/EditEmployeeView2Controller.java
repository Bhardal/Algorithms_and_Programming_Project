package org.magicmafia.ntm.neko_task_manager.controller.employeemanagement;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditEmployeeView2Controller {
    @FXML
    public TextField textFieldNewEmployeeName;
    @FXML
    public ObservableList<String> projectList;
    @FXML
    public Button closeButton;

    private EditEmployeeViewController editEmployeeViewController;

    @FXML
    private void onOKButtonClick() {
        String newEmployeeNameText = textFieldNewEmployeeName.getText();
        if (newEmployeeNameText.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please enter a correct employee Name.");
            a.show();
        }else {
            //

            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
        }
    }

    public void setEditEmployeeViewController(EditEmployeeViewController editEmployeeViewController) {
        this.editEmployeeViewController = editEmployeeViewController;
    }
}
