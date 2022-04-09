package lesson1;

public class Course {
    private int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (length >= 0) {
            this.length = length;
        }
        else
            return;
    }

    @Override
    public String toString() {
        return "Distance is: " + length + '\n';
    }
}
