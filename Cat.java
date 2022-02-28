package lesson6;

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }
    
    @Override
    public String run(int length) {
        if (length < 0)
            length = 0;
        if (length > 200)
            length = 200;
        return name + " ran " + length + " m.";
    }
    
    public String swim(int length) {
        return "Sorry, cats can't swim";
    }
}