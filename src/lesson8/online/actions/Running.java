package lesson8.online.actions;

public interface Running {

    boolean tryRun(int limit);

    void run(int limit);

    void notRun(int limit);
}
