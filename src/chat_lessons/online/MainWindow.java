package chat_lessons.online;

import chat_lessons.online.utility.Utility;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class MainWindow {

    private static final String MAIN_SCENE_FXML = "\\views\\MainScene.fxml";
    private static final String LOGIN_SCENE_FXML = "\\views\\LoginScene.fxml";
    private static final String LOGIN_TITLE = "Login";
    private static final String MAIN_TITLE = "Just Java Chat";
    private static final String PATH_TO_MAIN_ICON = "\\resources\\chat_icon.png";

    private static Stage window;
    private static int defScreenWidth;
    private static int defScreenHeight;

    public static void displayLoginWindow(Stage primaryStage, int defaultScreenWidth, int defaultScreenHeight) throws IOException {

        defScreenWidth = defaultScreenWidth;
        defScreenHeight = defaultScreenHeight;

        window = primaryStage;
        window.setOnCloseRequest(e -> {
            e.consume();
            App.closeProgram();
        });
        window.setTitle(LOGIN_TITLE);

        InputStream chatIconStream = MainWindow.class.getResourceAsStream(PATH_TO_MAIN_ICON);
        Image chatIcon = new Image(chatIconStream);
        window.getIcons().add(chatIcon);

        FXMLLoader loginLoader = new FXMLLoader(MainWindow.class.getResource(LOGIN_SCENE_FXML));
        double windowWidth = defScreenWidth / 6.0;
        double windowHeight = defScreenHeight / 7.0;
        Scene loginScene = new Scene(loginLoader.load(), windowWidth, windowHeight);

        Utility.centerStage(window, windowWidth, windowHeight);
        window.setResizable(false);
        window.setScene(loginScene);
        window.show();
    }

    public static void displayMainWindow(String login) throws IOException {

        double windowWidth = defScreenWidth / 2.0;
        double windowHeight = defScreenHeight / 2.0;
        FXMLLoader loader = new FXMLLoader(MainWindow.class.getResource(MAIN_SCENE_FXML));
        Scene mainScene = new Scene(loader.load(), windowWidth, windowHeight);

        Utility.centerStage(window, windowWidth, windowHeight);
        window.setTitle(MAIN_TITLE + String.format(" (Logged in as: %s)", login));
        window.setScene(mainScene);
        window.show();
    }
}
