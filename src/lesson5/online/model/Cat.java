package lesson5.online.model;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public String swim(double distance) {
        return "Sorry, but cats can't swim!";
    }
}
