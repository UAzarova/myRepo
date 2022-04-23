package lesson5;


import java.io.IOException;
import java.util.*;

/**
 * Java 2. Home work 5.
 *
 * @author Azarova Iuliia
 * @version 23.04.2022
 */

/*
    1. Реализовать сохранение данных в csv файл;
    2. Реализовать загрузку данных из csv файла. Файл читается целиком.

    Структура csv файла:
    | Строка заголовок с набором столбцов |
    | Набор строк с целочисленными значениями |
    | * Разделитель между столбцами - символ точка с запятой (;) |

    Пример:
    Value 1;Value 2;Value 3
    100;200;123
    300,400,500
    Для хранения данных использовать класс вида:
    public class AppData {
        private String[] header;
        private int[][] data;
        // ...
    }
 */

public class Main {
    public static void main(String[] args) throws IOException {
        AppData appData = new AppData();
        appData.loadFile("inputFile.csv");

        System.out.println(appData.toString());

        appData.saveFile("outputFile.csv");
    }
}
