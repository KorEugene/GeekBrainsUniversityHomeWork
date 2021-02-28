package chat_lessons.online;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class App extends Application {

    private static final GraphicsDevice DEFAULT_SCREEN_DEVICE = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    private static final int DEFAULT_SCREEN_WIDTH = DEFAULT_SCREEN_DEVICE.getDisplayMode().getWidth();
    private static final int DEFAULT_SCREEN_HEIGHT = DEFAULT_SCREEN_DEVICE.getDisplayMode().getHeight();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainWindow.display(primaryStage, DEFAULT_SCREEN_WIDTH, DEFAULT_SCREEN_HEIGHT);
    }

    public static void closeProgram() {
        boolean answer = false;
        try {
            answer = ConfirmWindow.display();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        if (answer) Platform.exit();
    }
}
