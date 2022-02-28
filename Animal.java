package lesson6;

abstract class Animal implements IAnimal {
    protected int runLength;
    protected int swimLength;
    protected String name;
    
    Animal(String name) {
        this.name = name;
    }
    
    public void setName(String name) {
        if (name != null)
            this.name = name;
    }
    
    public void setRunLength(int runLength) {
        if (runLength < 0)
            this.runLength = 0;
        else
            this.runLength = runLength;
    }
     
    public void setSwimLength(int swimLength) {
        if (swimLength < 0)
            this.swimLength = 0;
        else
            this.swimLength = swimLength;
    }
    
    public String getName() {
        return name;
    }
    
    public int getRunLength() {
        return runLength;
    }
    
    public int getSwimLength() {
        return swimLength;
    }
    
     
    @Override
    public String toString() {
        return "Ran " + runLength + "m." + "\n" + "Swam " + swimLength + "m.";
    }
}