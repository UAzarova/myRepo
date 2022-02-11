package lesson2;
/**
 * Java 1. Home work 2.
 * 
 * @author Azarova Iuliia
 * @verion 11.02.2022
 */


public class HomeWork2 {

    public static void main(String[] args) {
        int positiveNum, negativeNum, zero;
        positiveNum = 7;
        negativeNum = -3;
        zero = 0;
        String testString = "This is my test string for homework";
        int[] year = {1, 4, 100, 400, 1500, 1600, 27, 6754345, 620, 128};
    
        
        //1
        System.out.println("1. Test of 'checkSum' method:\n");
        System.out.println ("first num is: " + positiveNum + "\nsecond num is: " + negativeNum + "\nsum is: " + (positiveNum+negativeNum) + "\nresult is between 10 and 20: " + checkSum (positiveNum, negativeNum) + "\n");
        System.out.println ("first num is: " + negativeNum + "\nsecond num is: " + negativeNum + "\nsum is: " + (negativeNum+negativeNum) + "\nresult is between 10 and 20: " + checkSum (negativeNum, negativeNum) + "\n");
        System.out.println ("first num is: " + positiveNum + "\nsecond num is: " + positiveNum + "\nsum is: " + (positiveNum+positiveNum) + "\nresult is between 10 and 20: " + checkSum (positiveNum, positiveNum) + "\n");
        System.out.println ("first num is: " + zero + "\nsecond num is: " + zero + "\nsum is: " + (zero+zero) + "\nResult is between 10 and 20: " + checkSum (zero, zero) + "\n");

        
        //2
        System.out.println("\n\n2. Test of 'checkNumSign' method:\n");
        System.out.println ("Your number is: " + positiveNum);
        printNumSign (positiveNum);
        System.out.println ("Your number is: " + negativeNum);
        printNumSign (negativeNum);
        System.out.println ("Your number is: " + zero);
        printNumSign (zero);
        
        
        //3
        System.out.println("\n3. Test of 'returnNumSign' method:\n" + "(true if negative; false if positive)\n");
        System.out.println ("Your number is: " + positiveNum + " " + returnNumSignInversion (positiveNum));
        System.out.println ("Your number is: " + negativeNum + " " + returnNumSignInversion (negativeNum));
        System.out.println ("Your number is: " + zero + " " + returnNumSignInversion (zero));
        
        
        //4
        System.out.println("\n\n4. Test of 'printStringNTimes' method:\n" + "Your count is: " + positiveNum);
        printStringNTimes (testString, positiveNum);

        
        //5
        System.out.println("\n\n5. Test of 'checkLeapYear' method:\n");
        for (int i = 0; i < year.length; i++)
            System.out.println("Is " + year[i] + " a leap year?\t" + checkLeapYear(year[i]));       
        }
    
    
    /*
     * 1. метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно), 
     * если да – вернуть true, в противном случае – false.
     */
    static boolean checkSum (int firstNum, int secondNum) {
        return (((firstNum + secondNum) >= 10) && ((firstNum + secondNum) <= 20) ? true : false);
        }
     
    /* 
     * 2. метод, которому в качестве параметра передается целое число, 
     * метод должен напечатать в консоль, положительное ли число передали или отрицательное. 
     * Замечание: ноль считаем положительным числом.
     */
    static void printNumSign (int num) {
        System.out.println(num < 0 ? "Input number is negative!\n" : "Positive result!\n");
    }
     
    /*
     * 3. метод, которому в качестве параметра передается целое число.
     * Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
     */
    static boolean returnNumSignInversion (int num) {
        return(num < 0 ? true : false);
    }
     
    /*
     * 4. метод, которому в качестве аргументов передается строка и число, 
     * метод должен отпечатать в консоль указанную строку, указанное количество раз;
     */
    static void printStringNTimes (String text, int counter) {
        for (int i = 0; i < counter; i++)
            System.out.println((i+1) + ") " + text);
    }
    
    /*
     * 5. * метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true, не високосный - false). 
     * Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
     */
    static boolean checkLeapYear (int year) {
        return ((((year % 4) == 0) && (((year % 100) != 0) || ((year % 400) == 0))) ? true : false);
    }
}