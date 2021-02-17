package lesson8.online.models;

import lesson8.online.actions.Moving;

public class Cat implements Moving {

    private final int maxRun;
    private final int maxJump;

    public Cat(int maxRun, int maxJump) {
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    @Override
    public boolean tryJump(int limit) {
        if (isOverLimit(maxJump, limit)) {
            notJump(limit);
            return false;
        }
        jump(limit);
        return true;
    }

    @Override
    public boolean tryRun(int limit) {
        if (isOverLimit(maxRun, limit)) {
            notRun(limit);
            return false;
        }
        run(limit);
        return true;
    }

    @Override
    public void jump(int limit) {
        System.out.println(Participants.CAT.getTitle() + " jumped " + limit);
    }

    @Override
    public void notJump(int limit) {
        System.out.println(Participants.CAT.getTitle() + " can't jump " + limit + ", get out of the race!");
    }

    @Override
    public void run(int limit) {
        System.out.println(Participants.CAT.getTitle() + " ran " + limit);
    }

    @Override
    public void notRun(int limit) {
        System.out.println(Participants.CAT.getTitle() + " can't run so far " + limit + ", get out of the race!");
    }

    @Override
    public String toString() {
        return Participants.CAT.getTitle() + ", maxRun=" + maxRun + ", maxJump=" + maxJump;
    }

    private boolean isOverLimit(int opportunity, int limit) {
        return limit > opportunity;
    }
}
