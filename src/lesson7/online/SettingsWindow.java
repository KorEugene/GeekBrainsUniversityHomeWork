package lesson7.online;

import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JFrame {

    private final int WIN_WIDTH = 350;
    private final int WIN_HEIGHT = 300;

    private final int MIN_FIELD_SIZE = 3;
    private final int MAX_FIELD_SIZE = 10;

    private final int MIN_WIN_LENGTH = 3;

    private GameWindow gameWindow;

    private JRadioButton humanVsHuman;
    private JRadioButton humanVsAi;
    private JSlider sliderWinLength;
    private JSlider sliderFieldSize;
    private JButton btnStart;

    private final String FIELD_SIZE_PREFIX = "Размер поля: ";
    private final String WIN_LENGTH_PREFIX = "Выигрышная длина: ";

    SettingsWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setSize(WIN_WIDTH, WIN_HEIGHT);

        Rectangle gameWindowBounds = gameWindow.getBounds();
        int posX = (int) gameWindowBounds.getCenterX() - WIN_WIDTH / 2;
        int posY = (int) gameWindowBounds.getCenterY() - WIN_HEIGHT / 2;

        setLocation(posX, posY);
        setResizable(false);
        setTitle("Enter Your Settings New Game");

        setLayout(new GridLayout(10, 1));

        gameModeControl();
        fieldSizeAndWinControl();

        btnStart = new JButton("Start Game!");
        btnStart.addActionListener(e -> buttonClickMethod());

        add(btnStart);
    }

    private void gameModeControl() {
        add(new JLabel("Выберите режим игры"));
        humanVsHuman = new JRadioButton("Человек против человека", true);
        humanVsAi = new JRadioButton("Человек против ИИ");

        ButtonGroup gameMode = new ButtonGroup();
        gameMode.add(humanVsHuman);
        gameMode.add(humanVsAi);
        add(humanVsHuman);
        add(humanVsAi);
    }

    private void fieldSizeAndWinControl() {
        JLabel labelFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        JLabel labelWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);

        sliderFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        sliderFieldSize.addChangeListener(e -> {
            int currentValue = sliderFieldSize.getValue();
            labelFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
            sliderWinLength.setMaximum(currentValue);
        });

        sliderWinLength = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
        sliderWinLength.addChangeListener(e -> labelWinLength.setText(WIN_LENGTH_PREFIX + sliderWinLength.getValue()));

        add(new JLabel("Выберите размер поля:"));
        add(labelFieldSize);
        add(sliderFieldSize);

        add(new JLabel("Выберите длину выигрышной длины:"));
        add(labelWinLength);
        add(sliderWinLength);
    }

    private void buttonClickMethod() {
        int gameMode;

        if (humanVsHuman.isSelected()) {
//            gameMode = GameMap.GAME_MODE_HUMAN_VS_HUMAN;
            gameMode = GameMap.GAME_MODE_HVH;
        } else if (humanVsAi.isSelected()) {
//            gameMode = GameMap.GAME_MODE_HUMAN_VS_AI;
            gameMode = GameMap.GAME_MODE_HVA;
        } else {
            throw new RuntimeException("Неизвестный тип игры");
        }

        int fieldSize = sliderFieldSize.getValue();
        int winLength = sliderWinLength.getValue();

        gameWindow.startNewGame(gameMode, fieldSize, fieldSize, winLength);
        setVisible(false);
    }
}
