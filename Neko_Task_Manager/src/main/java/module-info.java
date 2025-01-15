module org.magicmafia.ntm.neko_task_manager {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.magicmafia.ntm.neko_task_manager.controller to javafx.fxml;
    exports org.magicmafia.ntm.neko_task_manager.controller to javafx.fxml;
    exports org.magicmafia.ntm.neko_task_manager.management;
    opens org.magicmafia.ntm.neko_task_manager.management to javafx.fxml;
    exports org.magicmafia.ntm.neko_task_manager;
    opens org.magicmafia.ntm.neko_task_manager to javafx.fxml;
}