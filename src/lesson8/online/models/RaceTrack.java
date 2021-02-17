package lesson8.online.models;

public class RaceTrack extends Obstacle {

    public RaceTrack(int limit) {
        super(limit);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ", length=" + limit;
    }
}
