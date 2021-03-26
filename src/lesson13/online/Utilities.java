package lesson13.online;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utilities {

    private static final Random RANDOM = new Random();

    // 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
    public static <T> void swapTwoElements(T[] array, int firstIndex, int secondIndex) {
        T temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    public static <T> void swapTwoElements(T[] array) {
        swapTwoElements(array, RANDOM.nextInt(array.length), RANDOM.nextInt(array.length));
    }

    // 2. Написать метод, который преобразует массив в ArrayList;
    public static <T> List<T> convertArrayToList(T[] array) {
//        return Arrays.asList(array);
        return Stream.of(array).collect(Collectors.toCollection(ArrayList::new));
    }
}
