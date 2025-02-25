package org.magicmafia.ntm.neko_task_manager.controller.employeemanagement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditEmployeeViewController {
    @FXML
    public TextField textFieldOldEmployeeID;
    @FXML
    public Button OKButton;

    private EmployeeManagementViewController employeeManagementViewController;

    @FXML
    private void onOKButtonClick() {
        String oldEmployeeIDText = textFieldOldEmployeeID.getText();
        if (oldEmployeeIDText.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please enter a correct employee ID.");
            a.show();
        }else {
            int OldEmployeeIDInt = Integer.parseInt(oldEmployeeIDText);
            try {
                EditEmployeeView2Controller.OldEmployeeIDInt = OldEmployeeIDInt;
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/magicmafia/ntm/neko_task_manager/employee-management-view/edit-employee-2-view.fxml"));
                Parent root = fxmlLoader.load();

                EditEmployeeView2Controller controller = fxmlLoader.getController();
                controller.setEditEmployeeViewController(this);
                controller.setOldEmployeeIDInt(Integer.parseInt(oldEmployeeIDText));

                Stage editEmployeeView = new Stage();
                editEmployeeView.setScene(new Scene(root));
                editEmployeeView.setTitle("Edit Employee");
                editEmployeeView.show();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            Stage stage = (Stage) OKButton.getScene().getWindow();
            stage.close();
        }

    }

    public void setEmployeeManagementViewController(EmployeeManagementViewController employeeManagementViewController) {
        this.employeeManagementViewController = employeeManagementViewController;
    }

    public void UpdateEmployeeInfo() {
        employeeManagementViewController.UpdateEmployeeInfo();
    }
}
