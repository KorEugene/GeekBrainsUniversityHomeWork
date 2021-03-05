package lesson12.online;

public class CalculationThread extends Thread {

    private final float[] ARRAY_FOR_CALCULATION;
    private final int counter;

    CalculationThread(float[] arrayForCalculation, int counter, String name) {
        this.ARRAY_FOR_CALCULATION = arrayForCalculation;
        this.counter = counter;
        this.setName(name);
    }

    @Override
    public void run() {
        Main.recalculateArrayElements(ARRAY_FOR_CALCULATION, counter);
        System.out.println(String.format("Thread %s finished the job!", getName()));
    }
}
