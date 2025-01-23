package org.magicmafia.ntm.neko_task_manager.controller.projectmanagement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditProjectViewController {
    @FXML
    public TextField textFieldOldProjectID;
    @FXML
    public Button OKButton;

    private ProjectManagementViewController projectManagementViewController;

    @FXML
    public void onOKButtonClick() {
        String oldProjectIDText = textFieldOldProjectID.getText();
        if (oldProjectIDText.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please enter a correct project ID.");
            a.show();
        }else {
            int oldProjectIDInt = Integer.parseInt(oldProjectIDText);
            try {
                EditProjectView2Controller.OldProjectIDInt = oldProjectIDInt;
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/magicmafia/ntm/neko_task_manager/project-management-view/edit-project-2-view.fxml"));
                Parent root = fxmlLoader.load();

                EditProjectView2Controller controller = fxmlLoader.getController();
                controller.setEditProjectViewController(this);
                controller.setOldProjectIDInt(Integer.parseInt(oldProjectIDText));

                Stage editProjectView = new Stage();
                editProjectView.setScene(new Scene(root));
                editProjectView.setTitle("Edit Project");
                editProjectView.show();


            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public void setProjectManagementViewController(ProjectManagementViewController projectManagementViewController) {
        this.projectManagementViewController = projectManagementViewController;
    }

    public void UpdateProjectInfo() {
        projectManagementViewController.UpdateProjectInfo();
    }

}
