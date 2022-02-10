package lesson1;

public class MyJavaApp {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }
    
    
    /*
     * 2. �������� ����� printThreeWords(), ������� ��� ������ ������ ���������� � ������� ��� �����: Orange, Banana, Apple.
     */
      public static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    
      
    /*
     * 3. �������� ����� checkSumSign(), � ���� �������� �������� ��� int ���������� a � b, � ��������������� �� ������ ����������, �������� ��������. 
     * ����� ����� ������ �������������� ��� ����������, � ���� �� ����� ������ ��� ����� 0, �� ������� � ������� ��������� ������ ��������������, 
     * � ��������� ������ - ������ ��������������;
     */
        public static void checkSumSign(){
            int a, b;
            a = -21;
            b = 17;
            String sumResult =  ((a + b) >= 0) ? "Good result! Positive amount!" : "Good result! Negative amount!";
            System.out.println(sumResult);            
    }
    
    
    /*
     * 4. �������� ����� printColor() � ���� �������� ������� int ���������� value � ��������������� �� ����� ���������. 
     * ���� value ������ 0 (0 ������������), �� � ������� ����� ������ ������� ��������� ��������, ���� ����� � �������� �� 0 (0 �������������) �� 100 (100 ������������), 
     * �� �������, ���� ������ 100 (100 �������������) - ��������;
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
     * 5. �������� ����� compareNumbers(), � ���� �������� �������� ��� int ���������� a � b, � ��������������� �� ������ ����������, �������� ��������. 
     * ���� a ������ ��� ����� b, �� ���������� ������� � ������� ��������� �a >= b�, � ��������� ������ �a < b�;
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