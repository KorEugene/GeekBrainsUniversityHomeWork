package lesson2.online;

public class HW2 {
    public static void main(String[] args) {

        /*
         1 Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
         */
        int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.print("Array with swapped \"0\" and \"1\": ");
        printOneDimensionalArray(replaceNumbers(array1));

        /*
         2 Задать пустой целочисленный массив размером 8. Написать метод, который c помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;
         */
        int[] array2 = new int[8];
        System.out.print("\n" + "Filled array: ");
        printOneDimensionalArray(fillArray(array2));

        /*
         3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
         */
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.print("\n" + "Multiplied array: ");
        printOneDimensionalArray(multiplyArray(array3));

        /*
         4 Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
         */
        int[] array4 = {2, 10, 6, 4, 11, 8, 10, 4, 8, 8, 9, 2};
        System.out.print("\n" + "Minimum number in array: " + findMinNumInArray(array4));
        System.out.print("\n" + "Maximum number in array: " + findMaxNumInArray(array4));

        /*
         5 * Создать квадратный целочисленный массив (количество строк и столбцов одинаковое), заполнить его диагональные элементы единицами, используя цикл(ы);
         */
        int[][] array5 = new int[5][5];
        System.out.println("\n" + "Cross in array: ");
        printTwoDimensionalArray(fillTwoDimensionalArray(array5));

        /*
         6 ** Написать метод, которому на вход подаётся одномерный массив и число n (может быть положительным, или отрицательным),
          при этом метод должен циклически сместить все элементы массива на n позиций.
          [1,2,3,4,5], -2 => [3,4,5,1,2]
          [1,2,3,4,5], 2 => [4,5,1,2,3]
         7 **** Не пользоваться вспомогательным массивом при решении задачи 6.
         */
        int[] array6 = {1, 2, 3, 4, 5};
        int offset = -7;
        System.out.print("\n" + "Array with offset and without additional array: ");
        printOneDimensionalArray(offsetElements(array6, offset));
        int offset2 = 7;
        int[] array7 = {1, 2, 3, 4, 5};
        System.out.print("\n" + "Array with offset and without additional array: ");
        printOneDimensionalArray(offsetElements(array7, offset2));
    }

    // Вспомогательный метод, распечатывающий массив в консоль, для избежания дублирования кода
    private static void printOneDimensionalArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i + 1 != array.length) {
                System.out.print(", ");
            }
        }
    }

    // Вспомогательный метод, распечатывающий массив в консоль
    private static void printTwoDimensionalArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }

    /*
    1 Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
     */
    public static int[] replaceNumbers(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 1) ? 0 : 1;
        }
        return array;
    }

    /*
     2 Задать пустой целочисленный массив размером 8. Написать метод, который c помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;
     */
    public static int[] fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 3 + 1;
        }
        return array;
    }

    /*
     3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
     */
    public static int[] multiplyArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        return array;
    }

    /*
     4 Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
     */
    public static int findMinNumInArray(int[] array) {
        int minimum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minimum) {
                minimum = array[i];
            }
        }
        return minimum;
    }

    public static int findMaxNumInArray(int[] array) {
        int maximum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maximum) {
                maximum = array[i];
            }
        }
        return maximum;
    }

    /*
     5 * Создать квадратный целочисленный массив (количество строк и столбцов одинаковое), заполнить его диагональные элементы единицами, используя цикл(ы);
     */
    public static int[][] fillTwoDimensionalArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j == i || j == array.length - 1 - i) {
                    array[i][j] = 1;
                } else {
                    array[i][j] = 0;
                }
            }
        }
        return array;
    }

    /*
    6 ** Написать метод, которому на вход подаётся одномерный массив и число n (может быть положительным, или отрицательным),
     при этом метод должен циклически сместить все элементы массива на n позиций.
     [1,2,3,4,5], -2 => [3,4,5,1,2]
     [1,2,3,4,5], 2 => [4,5,1,2,3]
    7 **** Не пользоваться вспомогательным массивом при решении задачи 6.
     */
    public static int[] offsetElements(int[] array, int offset) {
        while (offset != 0) {
            int tmp;
            if (offset > 0) {
                tmp = array[array.length - 1];
                for (int i = array.length - 1; i > 0; i--) {
                    array[i] = array[i - 1];
                }
                array[0] = tmp;
                offset--;
            } else {
                tmp = array[0];
                for (int i = 0; i < array.length - 1; i++) {
                    array[i] = array[i + 1];
                }
                array[array.length - 1] = tmp;
                offset++;
            }
        }
        return array;
    }
}
