package lesson4;

import java.util.*;

/**
 * Java 2. Home work 4.
 *
 * @author Azarova Iuliia
 * @version 20.04.2022
 */

/*
    1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
    Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
    Посчитать, сколько раз встречается каждое слово.

    2. Написать простой класс «Телефонный Справочник», который хранит в себе список фамилий и телефонных номеров.
    В этот телефонный справочник с помощью метода add() можно добавлять записи,
    а с помощью метода get() искать номер телефона по фамилии.
    Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
    Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес), взаимодействие с пользователем через консоль и т.д).
    Консоль использовать только для вывода результатов проверки телефонного справочника.
 */

public class Main {
    public static void main(String[] args) {

        //Task1
        String[] words = new String[12];
        for (int i = 0; i < words.length; i++) {
            words[i] = "test" + i % 5;
        }
        System.out.println("_Task 1_");
        System.out.println("My array is: \n" + Arrays.toString(words));

        Map uniqWords = new LinkedHashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            uniqWords.put(words[i], 0);
        }

        Iterator iter = uniqWords.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            entry.setValue(CalcUniqElement((String)entry.getKey(), words));
        }

        System.out.println("My uniq array is: \n" + uniqWords);


        //Task2

        Phonebook phonebook = new Phonebook();

        System.out.println("\n_Task 2_");
        System.out.println(phonebook);
        System.out.println("Trying to add some people..");

        phonebook.add("Ivanov", "999-99-9");
        phonebook.add("Ivanov", "999-99-10");
        phonebook.add("Ivanov1", "999-99-12");
        phonebook.add("Alex", "999-99-12");

        System.out.println(phonebook);

        System.out.println("Trying to get some phones..");
        System.out.println("Phones of Ivanov: " + phonebook.get("Ivanov"));
        System.out.println("Phones of Alex: " + phonebook.get("Alex"));
        System.out.println("Phones of Max: " + phonebook.get("Max"));
    }

    static int CalcUniqElement(String searchingWord, String[] wordsArray) {
        int res = 0;
        for (String s : wordsArray) {
            if (searchingWord.equals(s))
                res++;
        }
        return res;
    }
}

