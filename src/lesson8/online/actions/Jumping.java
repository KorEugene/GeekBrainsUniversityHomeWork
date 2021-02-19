package lesson8.online.actions;

public interface Jumping {

    boolean tryJump(int limit);

    void jump(int limit);

    void notJump(int limit);
}
