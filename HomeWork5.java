/**
 * Java 1. Home work 4.
 * 
 * @author Azarova Iuliia
 * @version 21.02.2022
 */


package lesson5;

class HomeWork5 {

    public static void main(String[] args) {

        System.out.println("Test user: ");
        Employee test = new Employee(null, null, null, null, 0, 0);
        System.out.print(test);
        
        Employee[] employeeArray = new Employee[5];
        employeeArray[0] = new Employee("Romashkin Alexey", "loafer", "no e-mail", "+7 999-999-99-99", 5, 27);
        employeeArray[1] = new Employee("Lastochkina Alisa", "painter", "queen-of-planet@peace.ru", "+7 999-999-99-98", 999999, 78);
        employeeArray[2] = new Employee("Abujaev Bilbirbek", "somebody", "ab@mail.ru", "+7 912-345-67-89", 5000, 41);
        employeeArray[3] = new Employee("Petrov Emil", "product manager", "bestproduct@mail.ru", "921-12-12", 800000, 31);
        employeeArray[4] = new Employee("Dotsenko Alexandr", "strange person", "mail@mail.ru", "000", 333, 13);
        
        for (int i = 0; i < 5; i++) {
            if (employeeArray[i].getAge() > 40) {
                System.out.println();
                System.out.print(employeeArray[i]);
            }
        }
    }
}
