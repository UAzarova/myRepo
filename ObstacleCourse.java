package lesson1;

/*
Добавить класс Course (полоса препятствий), в котором будут находиться:
массив препятствий;
метод, который будет просить команду пройти всю полосу.

В данном дз для корректности названий будет использоваться класс ObstacleCourse.
 */

class ObstacleCourse {
    private int swimDistance;
    private int runDistance;
    private boolean isDistancePassed;           //пройдена ли дистанция
    Stadium stadium = new Stadium();
    Pool pool = new Pool();


    public ObstacleCourse(Stadium stadium, Pool pool) {
          this.stadium = stadium;
          this.pool = pool;
    }

    public boolean doIt(Team team) {
        for (int i = 0; i < team.getNumberOfMembers(); i++) {
            isDistancePassed = (team.getMember(i).run(this.stadium) && team.getMember(i).swim(this.pool));
            if (isDistancePassed == false) {
                String.format("Oh no... Team %s failed!", team.getName());
                break;
            }
        }
        String.format("Congratulations! Team %s passed!", team.getName());
        return isDistancePassed;
    }
}
