package lesson5.online.model;

public class Bird extends Animal {

    public Bird(String name) {
        super(name);
    }

    @Override
    public void swim(double distance) {
        System.out.println("Sorry, but birds can't swim!");
    }
}
