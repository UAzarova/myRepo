package lesson2;

public class ArraySumInt {

    private int arraySize = 4;
    private int sum = 0;

    void transformAndSum(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if ((array.length != arraySize) && (array[0].length != arraySize)) throw new MyArraySizeException();
        else {
            for (int i = 0; i < arraySize; i++) {
                for (int j = 0; j < arraySize; j++) {
                    try {
                        int tmp = Integer.parseInt(array[i][j]);
                        sum += tmp;
                    } catch (NumberFormatException e) {
                        System.out.println("An error has occurred with element " + i + ", " + j);
                        throw new MyArrayDataException();
                    }
                }
            }
        }
        System.out.println("Sum is: " + sum);
        sum = 0;
    }
}
