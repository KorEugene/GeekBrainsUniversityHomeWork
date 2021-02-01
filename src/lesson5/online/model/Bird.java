package lesson5.online.model;

public class Bird extends Animal {

    public Bird(String name) {
        super(name);
    }

    @Override
    public String swim(double distance) {
        return "Sorry, but birds can't swim!";
    }
}
