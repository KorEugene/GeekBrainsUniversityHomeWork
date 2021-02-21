package lesson8.online.models;

import lesson8.online.actions.Moving;

public class Cat implements Moving {

    private final int MAX_RUN;
    private final int MAX_JUMP;

    public Cat(int maxRun, int maxJump) {
        this.MAX_RUN = maxRun;
        this.MAX_JUMP = maxJump;
    }

    @Override
    public boolean tryJump(int limit) {
        if (isOverLimit(MAX_JUMP, limit)) {
            notJump(limit);
            return false;
        }
        jump(limit);
        return true;
    }

    @Override
    public boolean tryRun(int limit) {
        if (isOverLimit(MAX_RUN, limit)) {
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
        return Participants.CAT.getTitle() + ", maxRun=" + MAX_RUN + ", maxJump=" + MAX_JUMP;
    }

    private boolean isOverLimit(int opportunity, int limit) {
        return limit > opportunity;
    }
}
