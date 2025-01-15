package org.magicmafia.ntm.neko_task_manager.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CreateEmployeeViewController {
    @FXML
    public TextField textFieldEmployeeID;
    @FXML
    private TextField textFieldEmployeeName;

    @FXML
    private void onOKButtonClick() {
        String employeeIDText = textFieldEmployeeID.getText();
        String employeeNameText = textFieldEmployeeName.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/magicmafia/ntm/neko_task_manager/employee-management-view.fxml"));

        EmployeeManagementViewController employeeInfo = loader.getController();
        employeeInfo.setEmployeeInfo(employeeIDText, employeeNameText);

    }
}
