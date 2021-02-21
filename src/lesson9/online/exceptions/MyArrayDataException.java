package lesson9.online.exceptions;

public class MyArrayDataException extends NumberFormatException {

    private static final String MESSAGE = "Item in a cell[%d][%d] is not a digit!";

    public MyArrayDataException(int y, int x) {
        super(String.format(MESSAGE, y, x));
    }
}
