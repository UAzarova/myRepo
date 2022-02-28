package lesson6;

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }
    
    @Override
    public String run(int length) {
        if (length < 0)
            length = 0;
        if (length > 500)
            length = 500;
        return name + " ran " + length + " m.";
    }
    
    public String swim(int length) {
        if (length < 0)
            length = 0;
        if (length > 10)
            length = 10;
        return name + " swam " + length + " m.";
    }
}