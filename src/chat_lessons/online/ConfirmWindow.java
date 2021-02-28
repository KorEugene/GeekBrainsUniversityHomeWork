package chat_lessons.online;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class ConfirmWindow {

    private static final String FXML = "\\views\\ConfirmScene.fxml";
    private static final String CONFIRM_TITLE = "Confirmation";
    private static final String PATH_TO_CONFIRM_ICON = "\\resources\\confirm_icon.png";

    private static boolean answer;

    public static boolean display() throws IOException {

        Stage confirmWindow = new Stage();
        confirmWindow.initModality(Modality.APPLICATION_MODAL);
        confirmWindow.setTitle(CONFIRM_TITLE);

        InputStream chatIconStream = App.class.getResourceAsStream(PATH_TO_CONFIRM_ICON);
        Image chatIcon = new Image(chatIconStream);
        confirmWindow.getIcons().add(chatIcon);

        FXMLLoader loader = new FXMLLoader(ConfirmWindow.class.getResource(FXML));
        Scene confirmScene = new Scene(loader.load(), 200, 80);

        confirmWindow.setScene(confirmScene);
        confirmWindow.setResizable(false);
        confirmWindow.showAndWait();

        return answer;
    }

    public static void setAnswer(boolean answer) {
        ConfirmWindow.answer = answer;
    }
}
