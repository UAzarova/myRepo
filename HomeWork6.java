/**
 * Java 1. Home work 6.
 * 
 * @author Azarova Iuliia
 * @version 28.02.2022
 */


package lesson6;

public class HomeWork6 {

    public static void main(String[] args) {
        
        IAnimal[] animals = {
                new Cat("pushok"),
                new Dog("bobik")
        };
        
        for (IAnimal animal : animals) {
            System.out.println("Run distance is: " + -5 + ",   " + animal.run(-5));
            System.out.println("Run distance is: " + 5 + ",    " + animal.run(5));
            System.out.println("Run distance is: " + 600 + ",  " + animal.run(600));
            System.out.println("Swim distance is: " + -5 + ",  " + animal.swim(-5));
            System.out.println("Swim distance is: " + 5 + ",   " + animal.swim(5));
            System.out.println("Swim distance is: " + 600 + ", " + animal.swim(600));
            System.out.println();
        }
    }
}