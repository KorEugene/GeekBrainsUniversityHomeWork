package lesson9.online.exceptions;

public class MySizeArrayException extends Exception {

    private static final String MESSAGE = "Dimensions of array are incorrect!";

    public MySizeArrayException() {
        super(MESSAGE);
    }
}
