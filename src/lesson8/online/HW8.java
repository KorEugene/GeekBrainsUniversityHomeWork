package lesson8.online;

import lesson8.online.actions.Moving;
import lesson8.online.models.*;

import java.util.Random;

public class HW8 {

    private static final Random RANDOM = new Random();

    /*
    1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь бегать и прыгать
    (методы просто выводят информацию о действии в консоль).
    2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять соответствующие действия (бежать или прыгать),
    результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.). У препятствий есть длина (для дорожки) или высота (для стены),
    а участников ограничения на бег и прыжки.
    3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
    Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.
    */
    public static void main(String[] args) {

        System.out.println("Obstacles:");
        Obstacle[] track = new Obstacle[10];
        for (int i = 0; i < track.length; i++) {
            track[i] = isEven(i) ? new RaceTrack(RANDOM.nextInt(20)) : new Wall(RANDOM.nextInt(5));
        }
        for (Obstacle obstacle : track) {
            System.out.println(obstacle);
        }

        System.out.println("\n" + "Participants:");
        Moving[] participants = {
                new Human(RANDOM.nextInt(75), RANDOM.nextInt(15)),
                new Cat(RANDOM.nextInt(50), RANDOM.nextInt(10)),
                new Robot(RANDOM.nextInt(100), RANDOM.nextInt(20))
        };
        for (Moving participant : participants) {
            System.out.println(participant);
        }

        System.out.println("\n" + "Let's go to track!");
        for (Moving participant : participants) {
            for (Obstacle obstacle : track) {
                if (obstacle instanceof RaceTrack) {
                    if (!participant.tryRun(obstacle.getLimit())) break;
                } else {
                    if (!participant.tryJump(obstacle.getLimit())) break;
                }
            }
        }
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
