package lesson8.online.models;

public class Wall extends Obstacle {

    public Wall(int limit) {
        super(limit);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ", height=" + limit;
    }
}
