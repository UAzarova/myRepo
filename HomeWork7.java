/**
 * Java 1. Home work 7.
 * 
 * @author Azarova Iuliia
 * @version 28.02.2022
 */


package lesson7;


class HomeWork7 {

    public static void main(String[] args) {      
        
        Cat[] cats = {
                new Cat("pushok1", 2),
                new Cat("pushok2", 4),
                new Cat("pushok3", 6),
        };
        
        Plate plate = new Plate(0);
        
        for (int i = 0; i < 2; i++) {
            plate.addFood(10);
            for (Cat cat : cats) {
                System.out.println(plate);
                cat.eat(plate);
                System.out.print(cat);
                System.out.println(plate);
                System.out.println();
            }
        }
    }
}


class Cat {
    private String name;
    private int appetite;
    private boolean fullness;
    
    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        fullness = false;
    }
    
    void eat(Plate plate) {
        if (!fullness) {
            fullness = plate.decreeseFood(appetite);
        }
        else
            System.out.println("This cat don't want to eat!");
    }
    
    boolean getFullness() {
        return fullness;
    }
    
    @Override
    public String toString() {
        return name + ", appetite: " + appetite + ", fullness " + fullness + "\n";
    }
}

class Plate {
    private int food;
    
    Plate(int food) {
        this.food = food;
    }
    
    boolean decreeseFood(int food) {
        if (food <= this.food) {
            this.food -= food;
            System.out.println("Yumm..eating");
            return true;
        }
        else {
            System.out.println("Sorry, not enough food for this cat");
            return false;
        }
    }
    
    void addFood(int food) {
        if (food < 0)
            System.out.println("Sorry, can't add food");
        else
            this.food += food;
    }

    
    @Override
    public String toString() {
        return "In plate now: " + food;
    }
}