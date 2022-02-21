/**
 * Java 1. Home work 4.
 * 
 * @author Azarova Iuliia
 * @version 21.02.2022
 */

package lesson4;

import java.util.Random;
import java.util.Scanner;


class TicTacToe {
    
    Random random;
    Scanner scanner;
    char[][] table;
    int tableSize = 3;
    
    public static void main(String[] args) {
        
        new TicTacToe().game();
	}
    
    TicTacToe () {
        random = new Random();
        scanner = new Scanner (System.in);
        table = new char [tableSize][tableSize];
    }
    
    
    
    void game() {
        initTable();
        printTable();
        
        while (true) {
            turnHuman();
            if (checkWin('x')) {
                System.out.println("Congradulation! You won!");
                break;
            }
            if (checkTableFull()) {
                System.out.println("Oh no! Draw!");
                break;
            }
            turnAI();
            printTable();
            
            if (checkWin('o')) {
                System.out.println("AI won!");
                break;
            }
            if (checkTableFull()) {
                System.out.println("Oh no! Draw!");
                break;
            }
        }
        System.out.println("Game over!");
        printTable();
    }
    
    void initTable() {
        for (int y = 0; y< tableSize; y++) {
            for (int x = 0; x < tableSize; x++) {
                table [x][y] = '.';
            }    
        }
    }
    
    void printTable(){
        for (int y = 0; y< tableSize; y++) {
            for (int x = 0; x < tableSize; x++) {
                System.out.print(table [x][y] + " ");
            }
            System.out.println();
        }
    }
    
    void turnHuman () {
        int x, y;
        do {
            System.out.println("Input x y [1..3]: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!checkCellValid(x, y));
        table[x][y] = 'x';
    }
    
    void turnAI () {
        int x, y;
        do {
            x = random.nextInt(tableSize);
            y = random.nextInt(tableSize);
        } while (!checkCellValid(x, y));
        table[x][y] = 'o';
    }
    
    boolean checkCellValid (int x, int y) {
        if (x < 0 || y < 0 || x > (tableSize - 1) || y > (tableSize - 1)) 
            return false;
        return table[x][y] == '.';
    }
    
    boolean checkWin (char input) {
        for (int i = 0; i < (tableSize - 1); i ++) {
            if (table[i][0] == input && table [i][1] == input && table[i][2] == input) 
                return true;
            if (table[0][i] == input && table [1][i] == input && table[2][i] == input) 
                return true;    
        }
        
        if (table[0][0] == input && table [1][1] == input && table[2][2] == input)
            return true;
        if (table[2][0] == input && table [1][1] == input && table[0][2] == input)
            return true;
        
        return false;
    }
    
    boolean checkTableFull () {
        for (int y = 0; y < tableSize; y++ ) {
            for (int x = 0; x < tableSize; x++) {
                if (table[x][y] == '.')
                    return false;
            }
        }
        return true;
    }
}
