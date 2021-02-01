package lesson5.online;

import lesson5.online.model.Bird;
import lesson5.online.model.Cat;
import lesson5.online.model.Dog;
import lesson5.online.model.Horse;

public class HW5 {

    public static void main(String[] args) {

        // 1. Создать классы Собака, Лошадь, Птица и Кот с наследованием от класса Животное.
        // 2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
        // В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков).
        // 3. У каждого животного есть ограничения на действия
        // (бег: кот 200 м., собака 500 м., Лошадь 1500 м., Птица 5 м.,; прыжок: кот 2 м., собака 0.5 м., Лошадь 3 м., Птица 0.2 м. ;
        // плавание: кот и птица не умеет плавать, собака 10 м., лошадь 100 м.).
        // 4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат. (Например, dog1.run(150); -> результат: 'Пёсик пробежал!')
        // 5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.

        Dog dog1 = new Dog("Tuzik");
        Dog dog2 = new Dog("Sharik");
        Cat cat1 = new Cat("Barsik");
        Cat cat2 = new Cat("Potap");
        Bird bird1 = new Bird("Chirik");
        Bird bird2 = new Bird("Kesha");
        Horse horse1 = new Horse("Uragan");
        Horse horse2 = new Horse("Lightning");

        dog1.run(600);
        dog2.run(500);
        cat1.run(150);
        cat2.run(300);
        bird1.run(3);
        bird2.run(30);
        horse1.run(1000);
        horse2.run(1500);

        dog1.swim(10);
        dog2.swim(20);
        cat1.swim(5);
        bird1.swim(2);
        horse1.swim(50);
        horse2.swim(150);

        dog1.jump(0.2);
        dog2.jump(0.6);
        cat1.jump(1);
        cat2.jump(3);
        bird1.jump(0.1);
        bird2.jump(0.3);
        horse1.jump(2);
        horse2.jump(4);

    }
}
