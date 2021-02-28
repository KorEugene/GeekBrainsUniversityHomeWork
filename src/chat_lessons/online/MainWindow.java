package chat_lessons.online;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class MainWindow {

    private static final String FXML = "\\views\\MainScene.fxml";
    private static final String MAIN_TITLE = "Just Java Chat";
    private static final String PATH_TO_MAIN_ICON = "\\resources\\chat_icon.png";

    public static void display(Stage primaryStage, int defaultScreenWidth, int defaultScreenHeight) throws IOException {

        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            App.closeProgram();
        });
        primaryStage.setTitle(MAIN_TITLE);

        InputStream chatIconStream = MainWindow.class.getResourceAsStream(PATH_TO_MAIN_ICON);
        Image chatIcon = new Image(chatIconStream);
        primaryStage.getIcons().add(chatIcon);

        FXMLLoader loader = new FXMLLoader(App.class.getResource(FXML));
        Scene mainScene = new Scene(loader.load(), (defaultScreenWidth / 2.0), (defaultScreenHeight / 2.0));

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
}
