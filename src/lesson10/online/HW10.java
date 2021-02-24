package lesson10.online;

import java.util.*;

public class HW10 {
    /*
    1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
    Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
    Посчитать сколько раз встречается каждое слово.
    2. ...тестировать просто из метода main() прописывая add() и get().
    */
    public static void main(String[] args) {

        String[] wordsArray = {"hello", "java", "world", "peanut", "project", "java", "man", "world", "java", "duck", "hello", "car", "rifle", "java"};
        System.out.println("Unique words in array:");
        System.out.println(new HashSet<>(Arrays.asList(wordsArray)));

        Map<String, Integer> words = new HashMap<>();
        for (String word : wordsArray) {
            if (!words.containsKey(word)) {
                words.put(word, 1);
            } else {
                words.put(word, words.get(word) + 1);
            }
        }

        System.out.println("\n" + "Count repeats in array:");
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            System.out.println("Word = " + entry.getKey() + ", repeats = " + entry.getValue());
        }

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("79112222222", "Petrov");
        phoneBook.add("79213333333", "Suvorov");
        phoneBook.add("79314444444", "Petrov");
        phoneBook.add("79515555555", "Sedov");
        phoneBook.add("79116666666", "Pechkin");
        phoneBook.add("79217777777", "Pechkin");
        phoneBook.add("79318888888", "Petrov");

        System.out.println();
        System.out.println("Suvorov phone number: " + phoneBook.get("Suvorov"));
        System.out.println("Petrov phone number: " + phoneBook.get("Petrov"));
        System.out.println("Pechkin phone number: " + phoneBook.get("Pechkin"));
        System.out.println("Sedov phone number: " + phoneBook.get("Sedov"));
    }
}
