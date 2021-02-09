package lesson7.online;

import javax.swing.*;
import java.awt.*;

/*
1. Полностью разобраться с кодом
(попробовать полностью самостоятельно переписать одно из окон)
2. Составить список вопросов и приложить в виде комментария к домашней работе
3. * Расчертить панель GameMap на поле для игры, согласно fieldSize
*/
public class GameMap extends JPanel {

    public static final int GAME_MODE_HUMAN_VS_HUMAN = 0;
    public static final int GAME_MODE_HUMAN_VS_AI = 1;

    GameMap() {
        setBackground(Color.YELLOW);
    }

    void start(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        setLayout(new GridLayout(fieldSizeY, fieldSizeX));
        for (int i = 0; i < fieldSizeX * fieldSizeY; i++) {
            JLabel label = new JLabel();
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            add(label);
        }
        validate();
    }
}
