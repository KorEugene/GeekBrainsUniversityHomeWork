package lesson9.online;

import lesson9.online.exceptions.MyArrayDataException;
import lesson9.online.exceptions.MySizeArrayException;

public class HW9 {

    private static final int CORRECT_DIMENSION_OF_ARRAY = 4;

    public static void main(String[] args) {
        String[][] array1 = new String[5][4];
        String[][] array2 = {{"1", "2", "3", "4"}, {"5", "6", "a", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        String[][] array3 = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        try {
            System.out.println("Sum of elements in array: " + sumElements(array1)); // throw MySizeArrayException
        } catch (MySizeArrayException | MyArrayDataException exception) {
            System.out.println(exception.getMessage());
        }
        try {
            System.out.println("Sum of elements in array: " + sumElements(array2)); // throw MyArrayDataException
        } catch (MySizeArrayException | MyArrayDataException exception) {
            System.out.println(exception.getMessage());
        }
        try {
            System.out.println("Sum of elements in array: " + sumElements(array3)); // this should be fine
        } catch (MySizeArrayException | MyArrayDataException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void checkArrayDimensions(String[][] array) throws MySizeArrayException {
        int rows = array.length;
        int columns = array[0].length;
        if (rows != CORRECT_DIMENSION_OF_ARRAY || columns != CORRECT_DIMENSION_OF_ARRAY)
            throw new MySizeArrayException();
    }

    private static int sumElements(String[][] array) throws MySizeArrayException, MyArrayDataException {
        int sum = 0;
        checkArrayDimensions(array);
        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array[y].length; x++) {
                try {
                    sum += Integer.parseInt(array[y][x]);
                } catch (NumberFormatException exception) {
                    throw new MyArrayDataException(y, x);
                }
            }
        }
        return sum;
    }
}
