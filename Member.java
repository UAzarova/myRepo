package lesson1;

public class Member implements IRun, ISwim {
    private String name;
    private int runDistance, swimDistance;

    Member (String name, int runDistance, int swimDistance) {
        setName(name);
        setRunDistance(runDistance);
        setSwimDistance(swimDistance);
    }

    public String getName () {
        return this.name;
    }

    public int getRunDistance () {
        return this.runDistance;
    }

    public int getSwimDistance () {
        return this.swimDistance;
    }

    public void setName (String name) {
        if (name != null)
            this.name = name;
        else
            return;
    }

    public void setRunDistance (int runDistance) {
        if (runDistance >= 0)
            this.runDistance = runDistance;
        else
            return;
    }

    public void setSwimDistance (int swimDistance) {
        if (swimDistance >= 0)
            this.swimDistance = swimDistance;
        else
            return;
    }

    public boolean run(Stadium stadium) {
        return this.runDistance >= stadium.getLength();
    }

    public boolean swim(Pool pool) {
        return this.swimDistance >= pool.getLength();
    }

    @Override
    public String toString() {
        return String.format("Member name: %s\nrunDistance: %s\nswimDistance: %s\n",name,runDistance,swimDistance);
    }

}

