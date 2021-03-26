package lesson13.online.boxes;

import lesson13.online.Utilities;
import lesson13.online.fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    private final List<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public void addFruit(T[] fruits) {
        this.fruits.addAll(Utilities.convertArrayToList(fruits)); // вместо Arrays.asList() используем нашу функцию, - не зря же мы её писали;
    }

    public float getWeight() {
        float weight = 0.0f;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public List<T> getFruits() {
        return fruits;
    }

    public boolean compare(Box<? extends Fruit> box) {
//        return Float.compare(this.getWeight(), box.getWeight()) == 0;
        return Math.abs(this.getWeight() - box.getWeight()) < 0.0001;
    }

    public void transferFruits(Box<? super T> box) {
        if (this == box) return;
        box.fruits.addAll(this.fruits);
        this.fruits.clear();
    }
}
