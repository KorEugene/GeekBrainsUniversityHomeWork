package lesson12.online;

import java.util.Arrays;

public class Main {

    private static final int SIZE = 10000000;
    private static final int H = SIZE / 2;

    private static float[] resultOne;
    private static float[] resultTwo;

    public static void main(String[] args) {
        mainThreadedCalculation();
        twoThreadedCalculation();
        System.out.println("Arrays after recalculation equals: " + Arrays.equals(resultOne, resultTwo));
    }

    /*
    Так как формула перерасчета элементов массива зависима от переменной i
    добавили переменную counter, чтобы при перерасчете массива в двух потоках результирующий массив был как и при
    перерасчете в одном потоке.
    */
    static void recalculateArrayElements(float[] arr, int counter) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (counter + i) / 5.0) * Math.cos(0.2f + (counter + i) / 5.0) * Math.cos(0.4f + (counter + i) / 2.0));
        }
    }

    private static void mainThreadedCalculation() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

        long start = System.currentTimeMillis();
        recalculateArrayElements(arr, 0);
        System.out.println("Single-threaded calculation done in: " + (System.currentTimeMillis() - start) + "\n");
        resultOne = arr;
    }

    private static void twoThreadedCalculation() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

        long start = System.currentTimeMillis();
        float[] a1 = new float[H];
        float[] a2 = new float[H];
        System.arraycopy(arr, 0, a1, 0, H);
        System.arraycopy(arr, H, a2, 0, H);
        System.out.println("Array was split!");

        CalculationThread one = new CalculationThread(a1, 0, "one");
        CalculationThread two = new CalculationThread(a2, H, "two");
        one.start();
        two.start();

        try {
            one.join();
            two.join();
        } catch (InterruptedException e) {
            System.out.println("Calculation problem: " + e.getMessage());
        }

        System.arraycopy(a1, 0, arr, 0, H);
        System.arraycopy(a2, 0, arr, H, H);
        System.out.println("Arrays were glued!" + "\n");
        System.out.println("Two-threaded calculation done in: " + (System.currentTimeMillis() - start) + "\n");
        resultTwo = arr;
    }
}
