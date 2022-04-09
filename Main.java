package lesson1;

/**
 * Java 2. Home work 1.
 *
 * @author Azarova Iuliia
 * @version 09.04.2022
 */

/*
    Course c = new Course(...); // Создаем полосу препятствий (а данном дз - ObstacleCourse)
    Team team = new Team(...); // Создаем команду
     c.doIt(team); // Просим команду пройти полосу
     team.showResults(); // Показываем результаты
 */

public class Main {
    public static void main(String[] args) {

        Stadium stadium1 = new Stadium (2);
        Stadium stadium2 = new Stadium (100);
        Pool pool1 = new Pool (2);
        Pool pool2 = new Pool (100);
        ObstacleCourse obstacleCourse1 = new ObstacleCourse (stadium1, pool1);
        ObstacleCourse obstacleCourse2 = new ObstacleCourse (stadium2, pool2);

        Member[] members = {
                new Member("Member1", 10, 7),
                new Member("Member2", 100, 70),
                new Member("Member3", 1000, 8),
                new Member("Member4", 20, 333),
        };


        Team team = new Team("new Team");
        team.addMember(members[0], 0);
        team.addMember(members[1], 1);
        team.addMember(members[2], 2);
        team.addMember(members[3], 3);

        System.out.println(team);

        System.out.println("First try...\n");
        obstacleCourse1.doIt(team);
        System.out.println("Second try...\n");
        obstacleCourse2.doIt(team);

    }
}