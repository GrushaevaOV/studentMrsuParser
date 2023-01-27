package FloorExeption;

public class ParserException extends Exception {
    private int number;

    public ParserException(String message, int num) {
        super(message);
        number = num;
    }

    public int getNumber() {
        return number;
    }
}
