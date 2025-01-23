package org.magicmafia.ntm.neko_task_manager.controller.projectmanagement;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NewTaskViewController {
    @FXML
    public TextField textFieldTaskID;
    @FXML
    public TextField textFieldTaskName;
    @FXML
    public TextField textFieldTaskDescription;
    @FXML
    public TextField textFieldTaskDeadline;
    @FXML
    public TextField textFieldTaskPriority;
    @FXML
    public TextField textFieldTaskStatus;
    @FXML
    public TextField textFieldTaskComment;

    private ProjectManagementViewController projectManagementViewController;

    // @FXML
    // private void 


    public void setProjectManagementViewController(ProjectManagementViewController projectManagementViewController) {
        this.projectManagementViewController = projectManagementViewController;
    }
}
