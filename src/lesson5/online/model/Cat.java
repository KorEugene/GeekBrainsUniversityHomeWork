package lesson5.online.model;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void swim(double distance) {
        System.out.println("Sorry, but cats can't swim!");
    }
}
