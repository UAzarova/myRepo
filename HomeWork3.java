/**
 * Java 1. Home work 3.
 * 
 * @author Azarova Iuliia
 * @verion 15.02.2022
 */

package lesson3;

import java.util.Arrays;
import java.util.Random;

public class HomeWork3 {

    public static void main(String[] args) {
        
        int min, max, randomInt;
        Random random = new Random();
        int arrayLength = random.nextInt(15)+1;
        int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        int[] array2 = new int[100];
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[][] array4 = new int [arrayLength][arrayLength];
        int[] array6 = new int [arrayLength];
        int[] array7 = new int [arrayLength];
        int[] arrayZero = new int [0];
        int[] balanceArray1 = {2, 2, 2, 1, 2, 2, 10, 1};
        int[] balanceArray2 = {1, 1, 1, 2, 1};
        int[] balanceArray3 = {10, 1, 9};
        int[] balanceArray4 = {1, 2, 3, 4, 10};
        int[] balanceArray5 = {5, 5};
        int[] balanceArray6 = {-10, 0, -8, 6, -24};
        int[] array8 = new int [arrayLength];
        int[] array81 = {1};
        int[] array82 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
        int[] array83 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int[] array84 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22};


        for (int i=0; i < array7.length; i++)
            array7[i] = random.nextInt(10);
        
        for (int i=0; i < array8.length; i++)
            array8[i] = random.nextInt();
        
        /*
         * 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. 
         * С помощью цикла и условия заменить 0 на 1, 1 на 0
         * array1     
         */
        
        System.out.println("Task 1");
        System.out.println("Test array is:\t" + Arrays.toString(array1));
        
        for (int i = 0; i < array1.length; i++)       
            array1[i] = (byte) (array1[i] == 1 ? 0 : 1);
        
        System.out.println("New array is:\t" + Arrays.toString(array1));

        
        /*
         * 2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100
         * array2
         */
        
        System.out.println("\nTask 2");

        for (int i = 0; i < array2.length; i++)
            array2[i] = i+1;

        System.out.println("Test array is:\t" + Arrays.toString(array2));

        
        /*
         * 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2
         * array3
         */
        
        System.out.println("\nTask 3");
        System.out.println("Test array is:\t" + Arrays.toString(array3));

        for (int i = 0; i < array3.length; i++)
            array3[i] = array3[i] < 6 ? array3[i] *= 2 : array3[i];

        System.out.println("New array is:\t" + Arrays.toString(array3));
        
        
        /*
         * 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
         * и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
         * Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n]
         * array4
         */
        
        System.out.println("\nTask 4");
        System.out.println("ArrayLength is: " + arrayLength);
        
        for (int i=0; i<arrayLength; i++) {
            array4[i][i] = 1;
            array4[arrayLength - i - 1][i] = 1;
        }
        
        for (int i=0; i<array4.length; i++)
            System.out.println(Arrays.toString(array4[i]));

        
        /*
         * 5. Написать метод, принимающий на вход два аргумента: len и initialValue,
         * и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue
         */
        
        System.out.println("\nTask 5");
        System.out.println("Test array is:\t" + Arrays.toString(createArray (random.nextInt(30), random.nextInt(30))));
        System.out.println("Test array is:\t" + Arrays.toString(createArray (10, -11)));
        System.out.println("Test array is:\t" + Arrays.toString(createArray (-2, 27)));

        
        /*
         * 6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы
         */
        
        System.out.println("\nTask 6");
        
        //initialization
        for (int i=0; i < array6.length; i++)
            array6[i] = random.nextInt(15);
        
        System.out.println("Test array is:\t" + Arrays.toString(array6));

        //find min & max 
        min = max = array6[0];
        for (int i=0; i < array6.length; i++) {
            if (array6[i] < min)
                min = array6[i];
            if (array6[i] > max)
                max = array6[i];
        }

        System.out.println("Min element is:\t" + min);
        System.out.println("Max element is:\t" + max);

        
        /*
         * 7. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место,
         * в котором сумма левой и правой части массива равны.
         * 
         * **Примеры:
         * checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
         * checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1
         * 
         * граница показана символами |||, эти символы в массив не входят и не имеют никакого отношения к ИЛИ.
         */
        
        System.out.println("\nTask 7");
          
        System.out.println("Test array is:\t" + Arrays.toString(array7));
        System.out.println("Is there a balance of the amount?\t" + checkBalance(array7) + "\n");
        
        System.out.println("Test array is:\t" + Arrays.toString(arrayZero));
        System.out.println("Is there a balance of the amount?\t" + checkBalance(arrayZero) + "\n");
        
        System.out.println("Test array is:\t" + Arrays.toString(balanceArray1));
        System.out.println("Is there a balance of the amount?\t" + checkBalance(balanceArray1) + "\n");
        
        System.out.println("Test array is:\t" + Arrays.toString(balanceArray2));
        System.out.println("Is there a balance of the amount?\t" + checkBalance(balanceArray2) + "\n");
        
        System.out.println("Test array is:\t" + Arrays.toString(balanceArray3));
        System.out.println("Is there a balance of the amount?\t" + checkBalance(balanceArray3) + "\n");
        
        System.out.println("Test array is:\t" + Arrays.toString(balanceArray4));
        System.out.println("Is there a balance of the amount?\t" + checkBalance(balanceArray4) + "\n");
        
        System.out.println("Test array is:\t" + Arrays.toString(balanceArray5));
        System.out.println("Is there a balance of the amount?\t" + checkBalance(balanceArray5) + "\n");
        
        System.out.println("Test array is:\t" + Arrays.toString(balanceArray6));
        System.out.println("Is there a balance of the amount?\t" + checkBalance(balanceArray6) + "\n");
        
        
        /*
         * 8 *** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
         * при этом метод должен сместить все элементы массива на n позиций.
         * Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
         * Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
         * При каком n в какую сторону сдвиг можете выбирать сами.
         * n > 0 - сдвиг влево
         * n < 0 - сдвиг вправо  
         */

        
        System.out.println("\nTask 8");
        
        System.out.println("Test array is:\t\t" + Arrays.toString(array8) + " length is " + array8.length);
        randomInt = random.nextInt(10);
        System.out.println("New array (shift is " + randomInt + ")\t" + Arrays.toString(arrayShift(array8.clone(), randomInt)) + "\n");
        
        System.out.println("Test array is:\t\t" + Arrays.toString(array81) + " length is " + array81.length);
        System.out.println("New array (shift " + 1 + ")\t" + Arrays.toString(arrayShift(array81.clone(), 1)) + "\n");
        
        System.out.println("Test array is:\t\t" + Arrays.toString(array82) + " length is " + array82.length);
        System.out.println("New array (shift " + 2 + ")\t" + Arrays.toString(arrayShift(array82.clone(), 2)) + "\n");
        
        System.out.println("Test array is:\t\t" + Arrays.toString(array82) + " length is " + array82.length);
        System.out.println("New array (shift " + 4 + ")\t" + Arrays.toString(arrayShift(array82.clone(), 4)) + "\n");
        
        System.out.println("Test array is:\t\t" + Arrays.toString(array83) + " length is " + array83.length);
        System.out.println("New array (shift " + -3 + ")\t" + Arrays.toString(arrayShift(array83.clone(), -3)) + "\n");
        
        System.out.println("Test array is:\t\t" + Arrays.toString(array84) + " length is " + array84.length);
        System.out.println("New array (shift " + 4 + ")\t" + Arrays.toString(arrayShift(array84.clone(), 4)) + "\n");
        
        System.out.println("Test array is:\t\t" + Arrays.toString(array84) + " length is " + array84.length);
        System.out.println("New array (shift " + -143 + ")\t" + Arrays.toString(arrayShift(array84.clone(), -143)) + "\n");
        
        System.out.println("Test array is:\t\t" + Arrays.toString(array84) + " length is " + array84.length);
        System.out.println("New array (shift " + (106) + ")\t" + Arrays.toString(arrayShift(array84.clone(), 106)) + "\n");
    }
    
    

    static int[] createArray (int len, int initialValue) {
        if (len <= 0)
        {
            System.out.println("Please, input positive length only!");
            return null;
        }
        else
        {
            int[] array = new int [len];
            
            for (int i = 0; i < len; i++)
                array[i] = initialValue;
                
            return array;
        }
    }
    
    
    static boolean checkBalance (int[] array) {
        if (array.length <= 1){
            System.out.println("Need more elements!!");
            return false;
        }
        
        int leftSum = 0;
        int rightSum = 0;
        
        for (int i = 0; i < array.length-1; i++) {
            leftSum += array[i];
            rightSum = 0;
            for (int j = i+1; j < array.length; j++)
                rightSum += array[j];
            if (leftSum == rightSum)
                return true;
        }
        return false;
    }
    
    static int[] arrayShift (int[] array, int n) {
        // n > 0 - shift left
        // n < 0 - shift right

        //if shift more than length of array
        n = (n % array.length);

        //no shift
        if (n == 0)
            return array;
        
        //transform right shift to left
        if (n < 0)
            n = array.length + n; 
        
        System.out.println("real n is " + n);


        int tmp = 0;
        int count = 0;

        for (int i = 0;  (count + i) < array.length; i++) {
            tmp = array[i];
            for (int j = 0; (((n * (j + 1))%array.length != 0) && (count < array.length)); j++, count++) {
                array[(n * j + i) % (array.length)] = array[(n * (j + 1) + i) % (array.length)];
                array[(n * (j + 1) + i) % (array.length)] = tmp;
            }
        }  
        
        return array;
    }
}