package lesson18.online;

public class ArrayContentUtils {

    /*
      2. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
      Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
      идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
      иначе в методе необходимо выбросить RuntimeException. Написать набор тестов для этого метода
      (по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
      3. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы,
      то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
     */

    public static int[] getArrayTailOrThrowException(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4) return getTail(arr, i);
        }
        throw new RuntimeException();
    }

    private static int[] getTail(int[] arr, int index) {
        if (index == arr.length - 1) return new int[0];
        int tailLength = arr.length - 1 - index;
        int[] result = new int[tailLength];
        System.arraycopy(arr, index + 1, result, 0, tailLength);
        return result;
    }

    public static boolean checkArrayContent(int[] arr) {
        int counterOne = 0;
        int counterFour = 0;
        for (int element : arr) {
            if (element == 1) {
                counterOne++;
            } else {
                counterFour++;
            }
        }
        return counterOne != 0 && counterFour != 0;
    }
}
