package lesson8.online.models;

public abstract class Obstacle {

    protected int limit;

    protected Obstacle(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }
}
