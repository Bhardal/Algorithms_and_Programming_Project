package org.magicmafia.ntm.neko_task_manager.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {
    @FXML
    public void onKanbanViewButtonClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/magicmafia/ntm/neko_task_manager/kanban-view.fxml"));
            Parent root = fxmlLoader.load();
            Stage kanbanView = new Stage();
            kanbanView.setScene(new Scene(root));
            kanbanView.setTitle("Calendar View");
            kanbanView.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onCalendarViewButtonClick() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/magicmafia/ntm/neko_task_manager/calendar-view.fxml"));
            Parent root = fxmlLoader.load();
            Stage calendarView = new Stage();
            calendarView.setScene(new Scene(root));
            calendarView.setTitle("Calendar View");
            calendarView.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
