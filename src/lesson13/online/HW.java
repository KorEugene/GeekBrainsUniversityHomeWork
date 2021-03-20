package lesson13.online;

import lesson13.online.boxes.Box;
import lesson13.online.fruits.Apple;
import lesson13.online.fruits.Orange;

import java.util.Arrays;
import java.util.List;

public class HW {

    public static void main(String[] args) {

        String[] strings1 = {"1", "2", "3", "a", "b", "c"};
        System.out.println("Init array: " + Arrays.toString(strings1));
        Utilities.swapTwoElements(strings1, 1, 4);
        System.out.println("Array with swapped elements: " + Arrays.toString(strings1) + "\n");

        String[] strings2 = {"1", "2", "3", "a", "b", "c"};
        System.out.println("Init array: " + Arrays.toString(strings2));
        Utilities.swapTwoElements(strings2);
        System.out.println("Array with swapped elements randomly: " + Arrays.toString(strings2) + "\n");

        Integer[] numbers = {10, 12, 14, 16, 18, 20};
        System.out.println("Init array: " + Arrays.toString(numbers));
        List<Integer> listNumbers = Utilities.convertArrayToList(numbers);
        System.out.println("Converted array is: " + listNumbers.getClass().getName() + " with elements: " + listNumbers + "\n");

        /*
        3. Большая задача:
        a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
        b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
        c. Для хранения фруктов внутри коробки можете использовать ArrayList;
        d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
        e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
        f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
        g. Не забываем про метод добавления фрукта в коробку.
        */
        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        System.out.println("Orange box: " + orangeBox.getFruits());
        System.out.println("Orange box weight: " + orangeBox.getWeight() + "\n");

        Box<Apple> appleBox = new Box<>();
        Apple[] apples = {new Apple(), new Apple(), new Apple(), new Apple()};
        appleBox.addFruit(apples);
        System.out.println("Apple box: " + appleBox.getFruits());
        System.out.println("Apple box weight: " + appleBox.getWeight() + "\n");

        System.out.println("Orange box has the same weight as apple box: " + orangeBox.compare(appleBox) + "\n");

        orangeBox.addFruit(new Orange[]{new Orange(), new Orange()});
        System.out.println("Orange box: " + orangeBox.getFruits());
        System.out.println("Orange box weight: " + orangeBox.getWeight() + "\n");

        appleBox.addFruit(new Apple[]{new Apple(), new Apple()});
        System.out.println("Apple box: " + appleBox.getFruits());
        System.out.println("Apple box weight: " + appleBox.getWeight() + "\n");

        System.out.println("Orange box has the same weight as apple box: " + orangeBox.compare(appleBox) + "\n");

        System.out.println("First apple box before transfer: " + appleBox.getFruits());
        System.out.println("First apple box weight before transfer: " + appleBox.getWeight());
        Box<Apple> appleBox1 = new Box<>();
        appleBox1.addFruit(new Apple());
        System.out.println("Second apple box before transfer: " + appleBox1.getFruits());
        System.out.println("Second apple box weight before transfer: " + appleBox1.getWeight() + "\n");

        appleBox.transferFruits(appleBox1);
        System.out.println("First apple box after transfer: " + appleBox.getFruits());
        System.out.println("First apple box weight after transfer: " + appleBox.getWeight());
        System.out.println("Second apple box after transfer: " + appleBox1.getFruits());
        System.out.println("Second apple box weight after transfer: " + appleBox1.getWeight());
    }
}
