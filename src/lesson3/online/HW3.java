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
    public static int humanTurnX;
    public static int humanTurnY;

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
        humanTurnY = y;
        humanTurnX = x;
    }

    // *** Проработать базовый искусственный интеллект, чтобы он мог блокировать ходы игрока.
    public static void aiTurn() {
        int x;
        int y;
        int[] nextTurn = chooseNextTurn();
        if (nextTurn[0] == -1) {
            do {
                x = RANDOM.nextInt(mapSizeX);
                y = RANDOM.nextInt(mapSizeY);
            } while (!isEmptyCell(y, x));
        } else {
            x = nextTurn[1];
            y = nextTurn[0];
        }
        map[y][x] = AI_DOT;
    }

    public static int[] chooseNextTurn() {
        int[] nextTurn = {-1, -1};
        int[] maxDots = findMaxHumanDotsInLines();
        int max = -1;
        int indexOfMax = -1;
        for (int i = 0; i < maxDots.length; i++) {
            if (maxDots[i] > max) {
                max = maxDots[i];
                indexOfMax = i;
            }
        }

        for (int i = 1; i < mapSizeX - 1; i++) {
            if (indexOfMax == 0) {
                if (humanTurnX - i >= 0 && map[humanTurnY][humanTurnX - i] == EMPTY_DOT) {
                    nextTurn[0] = humanTurnY;
                    nextTurn[1] = humanTurnX - i;
                    break;
                }
                if (humanTurnX + i < mapSizeX && map[humanTurnY][humanTurnX + i] == EMPTY_DOT) {
                    nextTurn[0] = humanTurnY;
                    nextTurn[1] = humanTurnX + i;
                    break;
                }
            }
            if (indexOfMax == 1) {
                if (humanTurnY - i >= 0 && map[humanTurnY - i][humanTurnX] == EMPTY_DOT) {
                    nextTurn[1] = humanTurnX;
                    nextTurn[0] = humanTurnY - i;
                    break;
                }
                if (humanTurnY + i < mapSizeY && map[humanTurnY + i][humanTurnX] == EMPTY_DOT) {
                    nextTurn[1] = humanTurnX;
                    nextTurn[0] = humanTurnY + i;
                    break;
                }
            }
            if (indexOfMax == 2) {
                if (humanTurnY - i >= 0 && humanTurnX - i >= 0 && map[humanTurnY - i][humanTurnX - i] == EMPTY_DOT) {
                    nextTurn[0] = humanTurnY - i;
                    nextTurn[1] = humanTurnX - i;
                    break;
                }
                if (humanTurnY + i < mapSizeY && humanTurnX + i < mapSizeX && map[humanTurnY + i][humanTurnX + i] == EMPTY_DOT) {
                    nextTurn[0] = humanTurnY + i;
                    nextTurn[1] = humanTurnX + i;
                    break;
                }
            }
            if (indexOfMax == 3) {
                if (humanTurnY - i >= 0 && humanTurnX + i < mapSizeX && map[humanTurnY - i][humanTurnX + i] == EMPTY_DOT) {
                    nextTurn[0] = humanTurnY - i;
                    nextTurn[1] = humanTurnX + i;
                    break;
                }
                if (humanTurnY + i < mapSizeY && humanTurnX - i >= 0 && map[humanTurnY + i][humanTurnX - i] == EMPTY_DOT) {
                    nextTurn[0] = humanTurnY + i;
                    nextTurn[1] = humanTurnX - i;
                    break;
                }
            }
        }
        return nextTurn;
    }

    public static int[] findMaxHumanDotsInLines() {
        int[] maxDots = new int[4];
        int horizontalDots = 0;
        for (int x = 0; x < mapSizeX; x++) {
            if (map[humanTurnY][x] == HUMAN_DOT) {
                horizontalDots++;
            }
        }
        maxDots[0] = horizontalDots;
        int verticalDots = 0;
        for (int y = 0; y < mapSizeY; y++) {
            if (map[y][humanTurnX] == HUMAN_DOT) {
                verticalDots++;
            }
        }
        maxDots[1] = verticalDots;
        boolean toRightFlag = false;
        int toRight = 0;
        boolean toLeftFlag = false;
        int toLeft = 0;
        for (int y = 0; y + lineLengthToWin <= mapSizeY; y++) {
            for (int x = 0; x + lineLengthToWin <= mapSizeX; x++) {
                if (toRightFlag || toLeftFlag) break;
                toRight = 0;
                toLeft = 0;
                int toRightCurrY = y;
                int toRightCurrX = x;
                int toLeftCurrX = mapSizeX - 1 - x;
                while (toRightCurrY < mapSizeY && toRightCurrX < mapSizeX && toLeftCurrX >= 0) {
                    if (map[toRightCurrY][toRightCurrX] == HUMAN_DOT) {
                        toRight++;
                        if (toRightCurrX == humanTurnX && toRightCurrY == humanTurnY) {
                            toRightFlag = true;
                        }
                    }
                    if (map[toRightCurrY][toLeftCurrX] == HUMAN_DOT) {
                        toLeft++;
                        if (toLeftCurrX == humanTurnX && toRightCurrY == humanTurnY) {
                            toLeftFlag = true;
                        }
                    }
                    toRightCurrY++;
                    toRightCurrX++;
                    toLeftCurrX--;
                }

            }
        }
        maxDots[2] = toRight;
        maxDots[3] = toLeft;
        return maxDots;
    }


    // * Усовершенствовать метод проверки победы (через циклы).
    public static boolean checkWinPlayer(char dotPlayer) {
        int horizontalCounter;
        for (int y = 0; y < mapSizeY; y++) {
            horizontalCounter = 0;
            for (int x = 0; x < mapSizeX; x++) {
                if (map[y][x] == dotPlayer) {
                    horizontalCounter++;
                    if (horizontalCounter == lineLengthToWin) return true;
                } else {
                    horizontalCounter = 0;
                }
            }
        }
        int verticalCounter;
        int counter = 0;
        while (counter < mapSizeX) {
            verticalCounter = 0;
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
        int toRightCounter;
        int toLeftCounter;
        for (int y = 0; y + lineLengthToWin <= mapSizeY; y++) {
            for (int x = 0; x + lineLengthToWin <= mapSizeX; x++) {
                toRightCounter = 0;
                toLeftCounter = 0;
                int toRightCurrY = y;
                int toRightCurrX = x;
                int toLeftCurrX = mapSizeX - 1 - x;
                while (toRightCurrY < mapSizeY && toRightCurrX < mapSizeX && toLeftCurrX >= 0) {
                    if (map[toRightCurrY][toRightCurrX] == dotPlayer) {
                        toRightCounter++;
                        if (toRightCounter == lineLengthToWin) return true;
                    } else {
                        toRightCounter = 0;
                    }
                    if (map[toRightCurrY][toLeftCurrX] == dotPlayer) {
                        toLeftCounter++;
                        if (toLeftCounter == lineLengthToWin) return true;
                    } else {
                        toLeftCounter = 0;
                    }
                    toRightCurrY++;
                    toRightCurrX++;
                    toLeftCurrX--;
                }
            }
        }
        return false;
    }

    public static boolean isEmptyCell(int y, int x) {
        return map[y][x] == EMPTY_DOT;
    }

    public static boolean isValidCell(int y, int x) {
        return x >= 0 && x < mapSizeX && y >= 0 && y < mapSizeY;
    }

    public static boolean isFullMap() {
        return turnsMade == maxTurns;
    }
}
