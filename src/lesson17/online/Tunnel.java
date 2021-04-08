package lesson17.online;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    private final Semaphore FREE_LINE = new Semaphore(MainClass.CARS_COUNT / 2);

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                FREE_LINE.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                FREE_LINE.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
