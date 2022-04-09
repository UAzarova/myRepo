package lesson1;

/*
Добавить класс Team, который будет содержать:
название команды;
массив из четырех участников — в конструкторе можно сразу всех участников указывать);
метод для вывода информации о членах команды, прошедших дистанцию;
метод вывода информации обо всех членах команды.
 */

public class Team {
    private String name;                                        //имя команды
    private static int numberOfMembers = 4;                     //количество участников
    private boolean isDistancePassed;                           //пройдена ли дистанция
    private int countMemberPassed;                              //счетчик количсетва участников, прошедших препятствия
    private lesson1.Member [] members = new Member [numberOfMembers];

    Team (String name) {
        setName(name);
        this.isDistancePassed = false;
        this.countMemberPassed = 0;
    }

    public String getName () {
        return this.name;
    }

    public boolean getIsDistancePassed () {
        return this.isDistancePassed;
    }

    public int getNumberOfMembers () {
        return this.numberOfMembers;
    }

    public Member getMember (int numMember) {
        return this.members[numMember];
    }

    public void setName (String name) {
        if (name != null)
            this.name = name;
        else
            return;
    }

    public void addMember(Member member, int numberInTeam) {
        if (numberInTeam < numberOfMembers) {
            this.members[numberInTeam] = member;
        }
    }

    public String showResults() {
        return String.format("Name of team: %s\nDistance passed: %s\nMembers:\n %s, %s, %s, %s", name, isDistancePassed, members[0], members[1], members[2], members[3]);
    }

    @Override
    public String toString() {
        return String.format("Name of team: %s\nMembers:\n%s %s %s %s", name, members[0], members[1], members[2], members[3]);
    }
}
