package lesson6.online;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class HW6 {

    /*
    1.	Создать 2 текстовых файла, примерно по 50-100 символов в каждом (особого значения не имеет);
    2.	Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
    3.	* Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле.
    4.  ** Написать метод, проверяющий, есть ли указанное слово в папке
    */
    public static void main(String[] args) {

        String jokeContentPart1 = "На днях, позвонили мне со старой работы:\n" +
                "- Тут проблема у нас. Переехали в новый офис, заменили всю технику. Довольны все, хорошо, удобно. Вот только секретарша плачет, требует вернуть ей старый Windows.\n" +
                "- А я тут причем?\n" +
                "- Она говорит, что ты ей такой хороший Windows поставил, что она столько лет на нем отработала. Я трубку новому айтишнику дам.\n" +
                "- Здравствуйте. Понимаете, мы ей поставили комп с \"десяткой\" и 27\" - монитором. Она плачет и говорит, что на этом уё..ще она работать не может. Тут всё не так, всё не красиво, тут даже пасьянсы страшные! Говорит, что у нее были красивые пасьянсы!\n" +
                "Когда парень сказал про \"красивые пасьянсы\", у меня в голове что-то щелкнуло и я вспомнил...\n" +
                "- Я понял! Сноси \"десятку\" и ставь ей Линукс с KDE.\n" +
                "Надо было слышать возмущение молодого айтишника:\n" +
                "- Линукс?! Бабке пенсионерке? Да она винду, как огня, боится!\n" +
                "- Не забивай голову, ставь Минт с КДЕ и не парься.\n";

        String jokeContentPart2 = "Через день он перезвонил.\n" +
                "- Я в шоке! Поставил линукс, бабка обрадовалась:\"Вот моя виндовс, а ту херню выкиньте\". Это вообще как?\n" +
                "Я поделился воспоминаниями.\n" +
                "Работал я в этой конторе админом и параллельно учился. Собрал компьютер, установил линукс, закачал на диск репы и учился. Надумал уходить на вольные хлеба, подал заявление. Осталось несколько дней отработать и тут вызывает директор и просит поставить комп секретарше, \" .. а то она одна печатает на машинке, мучается..\"\n" +
                "Я поставил системник с Линуксом, подключил принтер, показал как включать, вызывать редактор, и выводить на печать. Ну и заодно показал пасьянсы. Всех делов, это заняло три дня и я радостно распрощался с конторой.\n" +
                "Так вот, все эти годы секретарша работала и не догадывалась, что у нее не windows. А искренне считала, что у нее \"самая лучшая винда\" (каюсь: это я ей так сказал).";

        String firstFileName = "Joke_Part1.txt";
        String secondFileName = "Joke_Part2.txt";
        writeToFile(firstFileName, convertStringToByteArray(jokeContentPart1), false);
        writeToFile(secondFileName, convertStringToByteArray(jokeContentPart2), false);

        String mergedFileName = "Full_Joke.txt";
        concatFiles(firstFileName, secondFileName, mergedFileName);
        System.out.println(readFromFile(mergedFileName));

        // 3.	* Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле.
        // 4.  ** Написать метод, проверяющий, есть ли указанное слово в папке
        System.out.println("\n" + "Please enter one word without spaces which you want to find in the text: ");
        String userInput = getUserInput();
        String[] files = getFilesFromCurrentDirectory();
        for (String file : files) {
            if (isWordPresent(file, userInput)) {
                System.out.println("\n" + "Word: \"" + userInput + "\" - is present in the file: " + file);
            } else {
                System.out.println("\n" + "Word: \"" + userInput + "\" - is not present in the file: " + file);
            }
        }
    }

    private static byte[] convertStringToByteArray(String content) {
        return content.getBytes();
    }

    private static void writeToFile(String fileName, byte[] content, boolean append) {
        try (FileOutputStream fos = new FileOutputStream(fileName, append)) {
            fos.write(content);
            fos.flush();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static String readFromFile(String fileName) {
        StringBuilder resultString = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(fileName)) {
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8); // используем InputStreamReader с указанием кодировки, чтобы правильно считывать русские символы
            int output;
            while ((output = isr.read()) != -1) {
                resultString.append((char) output);
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        return resultString.toString().toLowerCase();
    }

    private static void deleteOldData(String fileName) {
        try {
            Files.deleteIfExists(Paths.get(fileName));
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void concatTwoFiles(String firstFileName, String secondFileName, String resultFileName) {
        String[] fileNames = {firstFileName, secondFileName};
        for (String fileName : fileNames) {
            writeToFile(resultFileName, convertStringToByteArray(readFromFile(fileName)), true);
        }
    }

    private static void concatFiles(String firstFileName, String secondFileName, String resultFileName) {
        deleteOldData(resultFileName);
        concatTwoFiles(firstFileName, secondFileName, resultFileName);
    }

    private static String getUserInput() {
        String input;
        try (Scanner scanner = new Scanner(new InputStreamReader(System.in, StandardCharsets.UTF_8))) { // используем InputStreamReader с указанием кодировки, чтобы правильно считывать ввод русских символов
            input = scanner.nextLine();
        }
        return input.toLowerCase();
    }

    private static boolean isWordPresent(String fileName, String userInput) {
        Scanner scanner = new Scanner(readFromFile(fileName));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(userInput)) return true;
        }
        return false;
    }

    private static String getCurrentDirectoryPath() {
        return Paths.get(".").toAbsolutePath().toString();
    }

    private static String[] getFilesFromCurrentDirectory() {
        File folder = new File(getCurrentDirectoryPath());
        FilenameFilter txtFileFilter = (dir, name) -> name.endsWith(".txt"); // выбираем файлы с расширением .txt (просто чтобы попрактиковаться)
        File[] files = folder.listFiles(txtFileFilter);
        String[] fileNames = new String[0];
        if (files != null) {
            fileNames = Arrays.stream(files)
                    .map(File::getName)
                    .toArray(String[]::new);
        }
        return fileNames;
    }

}
