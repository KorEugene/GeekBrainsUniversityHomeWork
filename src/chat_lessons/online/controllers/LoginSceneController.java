package chat_lessons.online.controllers;

import chat_lessons.online.AlertWindow;
import chat_lessons.online.App;
import chat_lessons.online.MainWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginSceneController {

    @FXML
    private TextField labLogin;
    @FXML
    private TextField labPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnCancel;

    @FXML
    private void btnLogin(ActionEvent actionEvent) throws IOException {
        // some logic for check credentials in DB
        if (labLogin.getLength() > 0) {
            MainWindow.displayMainWindow(labLogin.getText());
        } else {
            AlertWindow.display();
        }
    }

    @FXML
    private void btnCancel(ActionEvent actionEvent) {
        App.closeProgram();
    }
}
