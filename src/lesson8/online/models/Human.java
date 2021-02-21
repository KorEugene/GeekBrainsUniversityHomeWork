package lesson8.online.models;

import lesson8.online.actions.Moving;

public class Human implements Moving {

    private final int MAX_RUN;
    private final int MAX_JUMP;

    public Human(int MAX_RUN, int MAX_JUMP) {
        this.MAX_RUN = MAX_RUN;
        this.MAX_JUMP = MAX_JUMP;
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
        System.out.println(Participants.HUMAN.getTitle() + " jumped! " + limit);
    }

    @Override
    public void notJump(int limit) {
        System.out.println(Participants.HUMAN.getTitle() + " can't jump " + limit + ", get out of the race!");
    }

    @Override
    public void run(int limit) {
        System.out.println(Participants.HUMAN.getTitle() + " ran! " + limit);
    }

    @Override
    public void notRun(int limit) {
        System.out.println(Participants.HUMAN.getTitle() + " can't run " + limit + ", get out of the race!");
    }

    @Override
    public String toString() {
        return Participants.HUMAN.getTitle() + ", maxRun=" + MAX_RUN + ", maxJump=" + MAX_JUMP;
    }

    private boolean isOverLimit(int opportunity, int limit) {
        return limit > opportunity;
    }
}
