package lesson2;

/**
 * Java 2. Home work 2.
 *
 * @author Azarova Iuliia
 * @version 12.04.2022
 */

/*
    1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
    При подаче массива другого размера необходимо бросить исключение MyArraySizeException.

    2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
    Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
    должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.

    3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException и вывести результат расчета.
 */
import java.util.Random;

public class Main {
    public static void main(String[] args) throws MyArraySizeException {
        int arraySize = 4;
        String [][] testArray1 = new String[][] {{"0", "1", "2"}, {"3", "4", "5"}};
        String [][] testArray2 = new String[][] {{"0", "1", "7", "0"}, {"1", "6", "test", "3"} ,
                {"1", "2", "3", "3"}, {"1", "2", "3", "3"}};
        String [][] testArrayTrue = new String[][] {{"0", "0", "0", "0"}, {"1", "1", "1", "1"}, {"2", "2", "2", "2"}, {"0", "0", "0", "0"}};

        ArraySumInt result = new ArraySumInt();

        //некорректный размер массива
        result.transformAndSum(testArray1);

        //некорректный тип данных
        result.transformAndSum(testArray2);

        //сумма = 12
        result.transformAndSum(testArrayTrue);
    }
}
