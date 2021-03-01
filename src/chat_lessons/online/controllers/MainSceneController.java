package chat_lessons.online.controllers;

import chat_lessons.online.App;
import chat_lessons.online.MainWindow;
import chat_lessons.online.SettingsWindow;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainSceneController implements Initializable {

    private static final String URI_JAVAFX = "https://openjfx.io/";

    @FXML
    private TextArea chatArea;
    @FXML
    private ListView onlineUsers;
    @FXML
    private Button btnSendMessage;
    @FXML
    private TextArea input;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        onlineUsers.setItems(FXCollections.observableArrayList("Vasya", "Petya", "Kolya"));
    }

    @FXML
    private void logout(ActionEvent actionEvent) throws IOException {
        MainWindow.displayLoginWindow(App.getMainStage(), App.getDefaultScreenWidth(), App.getDefaultScreenHeight());
    }

    @FXML
    private void exit(ActionEvent actionEvent) {
        App.closeProgram();
    }

    @FXML
    private void aboutJavaFX(ActionEvent actionEvent) throws URISyntaxException, IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(new URI(URI_JAVAFX));
    }

    @FXML
    private void getSettings(ActionEvent actionEvent) throws IOException {
        SettingsWindow.display();
    }

    @FXML
    private void pressEnter(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER && keyEvent.isShiftDown()) {
            input.insertText(input.getCaretPosition(), "\n");
        } else if (keyEvent.getCode() == KeyCode.ENTER) {
            appendTextFromTF();
            keyEvent.consume();
        }
    }

    @FXML
    private void btnSend(ActionEvent actionEvent) {
        appendTextFromTF();
    }

    private void appendTextFromTF() {
        String msg = input.getText();
        if (msg.length() > 0) {
            chatArea.appendText(msg + System.lineSeparator());
            input.clear();
        }
    }
}
