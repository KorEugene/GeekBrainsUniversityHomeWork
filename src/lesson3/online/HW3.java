package lesson3.online;

import java.util.Random;
import java.util.Scanner;

public class HW3 {

    public static char[][] map;
    // ** Расширить поле до 5х5 и в качестве условий победы установить серию равной 4.
    public static int mapSizeX = 5;
    public static int mapSizeY = 5;
    public static int lineLengthToWin = 4;
    public static int maxTurns = mapSizeX * mapSizeY;
    public static int turnsMade;

    public static final char HUMAN_DOT = 'X';
    public static final char AI_DOT = 'O';
    public static final char EMPTY_DOT = '_';

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final Random RANDOM = new Random();

    public static void main(String[] args) {
        createMap();
        printMap();
        while (true) {
            humanTurn();
            turnsMade++;
            printMap();
            if (checkWinPlayer(HUMAN_DOT)) {
                System.out.println("Human won!");
                break;
            }
            if (isFullMap()) {
                System.out.println("Nobody won!");
                break;
            }
            aiTurn();
            turnsMade++;
            printMap();
            if (checkWinPlayer(AI_DOT)) {
                System.out.println("AI won!");
                break;
            }
            if (isFullMap()) {
                System.out.println("Nobody won!");
                break;
            }
        }
        System.out.println("End of the game!");
    }

    public static void createMap() {
        turnsMade = 0;
        map = new char[mapSizeY][mapSizeX];
        for (int y = 0; y < mapSizeY; y++) {
            for (int x = 0; x < mapSizeX; x++) {
                map[y][x] = EMPTY_DOT;
            }
        }
    }

    public static void printMap() {
        for (int y = 0; y < mapSizeY; y++) {
            for (int x = 0; x < mapSizeX; x++) {
                System.out.print(" | " + map[y][x]);
                if (x + 1 == mapSizeX) {
                    System.out.println(" | ");
                }
            }
        }
        System.out.println("\n" + "Current turn: " + turnsMade + "\n");
    }

    public static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Enter the coordinates(x,y) of your turn: ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(y, x) || !isEmptyCell(y, x));
        map[y][x] = HUMAN_DOT;
    }

    public static void aiTurn() {
        int x;
        int y;
        do {
            x = RANDOM.nextInt(mapSizeX);
            y = RANDOM.nextInt(mapSizeY);
        } while (!isEmptyCell(y, x));
        map[y][x] = AI_DOT;

    }

    public static boolean isEmptyCell(int y, int x) {
        return map[y][x] == EMPTY_DOT;
    }

    public static boolean isValidCell(int y, int x) {
        return x >= 0 && x < mapSizeX && y >= 0 && y < mapSizeY;
    }

    // * Усовершенствовать метод проверки победы (через циклы).
    public static boolean checkWinPlayer(char dotPlayer) {
        int horizontalCounter = 0;
        for (int y = 0; y < mapSizeY; y++) {
            for (int x = 0; x < mapSizeX; x++) {
                if (map[y][x] == dotPlayer) {
                    horizontalCounter++;
                    if (horizontalCounter == lineLengthToWin) return true;
                } else {
                    horizontalCounter = 0;
                }
            }
        }
        int verticalCounter = 0;
        int counter = 0;
        while (counter < mapSizeX) {
            for (int y = 0; y < mapSizeY; y++) {
                if (map[y][counter] == dotPlayer) {
                    verticalCounter++;
                    if (verticalCounter == lineLengthToWin) return true;
                } else {
                    verticalCounter = 0;
                }
            }
            counter++;
        }
        int toRightCounter = 0;
        int toLeftCounter = 0;
        for (int y = 0; y + lineLengthToWin <= mapSizeY; y++) {
            for (int x = 0; x + lineLengthToWin <= mapSizeX; x++) {
                int toRightCurrY = y;
                int toRightCurrX = x;
                while (toRightCurrY < mapSizeY && toRightCurrX < mapSizeX) {
                    if (map[toRightCurrY][toRightCurrX] == dotPlayer) {
                        toRightCounter++;
                        if (toRightCounter == lineLengthToWin) return true;
                    } else {
                        toRightCounter = 0;
                    }
                    toRightCurrY++;
                    toRightCurrX++;
                }
                int toLeftCurrY = y;
                int toLeftCurrX = mapSizeX - 1 - x;
                while (toLeftCurrY < mapSizeY && toLeftCurrX >= 0) {
                    if (map[toLeftCurrY][toLeftCurrX] == dotPlayer) {
                        toLeftCounter++;
                        if (toLeftCounter == lineLengthToWin) return true;
                    } else {
                        toLeftCounter = 0;
                    }
                    toLeftCurrX--;
                    toLeftCurrY++;
                }
            }
        }
        return false;
    }

    public static boolean isFullMap() {
        return turnsMade == maxTurns;
    }
}
