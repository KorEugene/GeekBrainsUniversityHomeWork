package lesson7.online;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private final int WIN_WIDTH = 500;
    private final int WIN_HEIGHT = 550;
    private final int WIN_POS_X = 450;
    private final int WIN_POS_Y = 100;

    private SettingsWindow settingsWindow;
    private GameMap gameMap;

    GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setLocation(WIN_POS_X, WIN_POS_Y);
        setTitle("The Game");
        setResizable(false);

        settingsWindow = new SettingsWindow(this);
        gameMap = new GameMap();

        JButton btnStartGame = new JButton("Start New Game");
        btnStartGame.addActionListener(e -> settingsWindow.setVisible(true));

        JButton btnExitGame = new JButton("Exit");
        btnExitGame.addActionListener(e -> System.exit(0));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(btnStartGame);
        buttonPanel.add(btnExitGame);

        add(buttonPanel, BorderLayout.SOUTH);
        add(gameMap);
        setVisible(true);
    }

    void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
//        gameMap.removeAll();
        gameMap.start(gameMode, fieldSizeX, fieldSizeY, winLength);
    }
}
