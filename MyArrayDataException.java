package lesson2;

public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException() {
        super ("Error transforming to int");
    }
}