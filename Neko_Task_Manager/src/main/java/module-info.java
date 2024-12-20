module org.magicmafia.ntm.neko_task_manager {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.magicmafia.ntm.neko_task_manager to javafx.fxml;
    exports org.magicmafia.ntm.neko_task_manager;
}