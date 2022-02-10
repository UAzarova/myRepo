package lesson1;

public class MyJavaApp {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }
    
    
    /*
     * 2. —оздайте метод printThreeWords(), который при вызове должен отпечатать в столбец три слова: Orange, Banana, Apple.
     */
      public static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    
      
    /*
     * 3. —оздайте метод checkSumSign(), в теле которого объ€вите две int переменные a и b, и инициализируйте их любыми значени€ми, которыми захотите. 
     * ƒалее метод должен просуммировать эти переменные, и если их сумма больше или равна 0, то вывести в консоль сообщение У—умма положительна€Ф, 
     * в противном случае - У—умма отрицательна€Ф;
     */
        public static void checkSumSign(){
            int a, b;
            a = -21;
            b = 17;
            String sumResult =  ((a + b) >= 0) ? "Good result! Positive amount!" : "Good result! Negative amount!";
            System.out.println(sumResult);            
    }
    
    
    /*
     * 4. —оздайте метод printColor() в теле которого задайте int переменную value и инициализируйте ее любым значением. 
     * ≈сли value меньше 0 (0 включительно), то в консоль метод должен вывести сообщение У расныйФ, если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно), 
     * то У∆елтыйФ, если больше 100 (100 исключительно) - У«еленыйФ;
     */   
    
    public static void printColor(){
        int value = 567890;
        if (value <= 0)
            System.out.println("It is Red! Beautiful choice!");      
        if (value > 0 && value <= 100)
            System.out.println("It is Yellow! Woohoo!");   
        if (value > 100)
            System.out.println("It is Green! Congradulations!");
    }
    
    
    /*
     * 5. —оздайте метод compareNumbers(), в теле которого объ€вите две int переменные a и b, и инициализируйте их любыми значени€ми, которыми захотите. 
     * ≈сли a больше или равно b, то необходимо вывести в консоль сообщение Уa >= bФ, в противном случае Уa < bФ;
     */
        public static void compareNumbers(){
            int a, b;
            a = 4567;
            b = 82;
            if (a >= b)
                System.out.println("a >= b");
            else
                System.out.println("a < b");

    }
}