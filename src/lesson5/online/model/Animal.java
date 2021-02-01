package lesson5.online.model;

import java.util.Random;

public abstract class Animal {

    private static final Random RANDOM = new Random();
    private static final String RUN = "run";
    private static final String SWIM = "swim";
    private static final String JUMP = "jump";

    protected String name;
    protected double maxRun;
    protected double maxSwim;
    protected double maxJump;

    protected Animal(String name) {
        this.name = name;
        this.maxRun = RANDOM.nextDouble() * 1000;
        this.maxSwim = RANDOM.nextDouble() * 100;
        this.maxJump = RANDOM.nextDouble() * 10;
    }

    public String run(double distance) {
        return calculateAction(RUN, maxRun, distance);
    }

    public String swim(double distance) {
        return calculateAction(SWIM, maxSwim, distance);
    }

    public String jump(double distance) {
        return calculateAction(JUMP, maxJump, distance);
    }

    private String calculateAction(String action, double limit, double distance) {
        if (allowableDistance(limit, distance)) {
            return name + " " + action + " " + distance + " m!";
        }
        return distance + "m - is too far for the " + name + " to " + action + "!";
    }

    private boolean allowableDistance(double limit, double distance) {
        return limit >= distance;
    }
}
