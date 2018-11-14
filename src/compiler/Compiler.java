/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author LENOVO
 */
public class Compiler {

    /**
     * @param args the command line arguments
     */
    static Stack<String> stackkk = new Stack<>();
    static String s = "";
    static int i = 0;
    static String stack = "0";
    static String e = "empty";
    static String[][] a = {{"S5", "S4", e, e, "1", "2", "3"},//state 0
    {e, e, e, "acc", e, e, e},//state1
    {e, e, "S6", "R5", e, e, e},//2
    {e, e, e, "R2", e, e, e},//3
    {"S5", "S4", e, e, e, "8", "7"},//4
    {e, e, "R4", "R4", e, e, e},//5
    {"S12", "S11", e, e, e, "10", "9"},//6
    {e, e, "R3", "R3", e, e, e},//7
    {e, e, "R5", "R5", e, e, e},//8
    {e, e, e, "R1", e, e, e},//9
    {e, e, e, "R5", e, e, e},//10
    {"S12", "S11", e, e, e, "10", "13"},//11
    {e, e, e, "R4", e, e, e},//12
    {e, e, e, "R3", e, e, e},//13
};

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        // BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Scanner read = new Scanner(System.in);
        s = read.next().toLowerCase().replaceAll("id", "x"); // don't forget to return ALL x to id !!

        s = s.concat("$");
        stackkk.push("0");

        String newcell = a[Integer.parseInt(stackkk.peek())][columNo(s.charAt(i))];

        String s1;

        while (true) {

            String cell = a[Integer.parseInt(stackkk.peek())][columNo(s.charAt(i))];
            if (cell.startsWith("S")) {
                stackkk.push(s.substring(1));
                stackkk.push(cell.substring(1));

//                
//                s1 = s.substring(0, 1);
//                s = s.substring(1);
//                stack = stack + s1;
//                stack += cell.substring(1);
            } else if (cell == ("acc")) {
                System.out.println("The statment id correct ");
                break;
            } else if (cell == e) {
                System.out.println("NOT CORRECT !!!!");
                break;
            } else if (cell.startsWith("R")) {
                int ss = Integer.parseInt(cell.substring(1));
                stackkk.push(reduce(ss));

                String push1 = stackkk.pop(); // F
                char n1 = push1.charAt(0);
                String push2 = stackkk.pop(); //0
                String cell2 = a[Integer.parseInt(stackkk.pop())][columNo(n1)];
                stackkk.push(push2);
                stackkk.push(push1);
                stackkk.push(cell2);

            }
        }
        s = read.next().toLowerCase().replaceAll("x", "id");

        System.out.println(stack);
        System.out.println(s);

    }

    public static String reduce(int x) {
        switch (x) {
            case 1:
                delete(6);
                return "S";
            case 2:
                delete(2);
                return "S";
            case 3:
                delete(4);
                return "L";
            case 4:
                delete(2);
                return "L";
            case 5:
                delete(2);
                return "R";

        }
        return "";
    }

    public static void delete(int x) {

        for (int i = 0; i < x; i++) {
            stackkk.pop();
            //stack=stack.substring(0,stack.length()-1);
        }

    }

    public static int columNo(char s) {
        switch (s) {
            case 'x':
                return 0;
            case '*':
                return 1;
            case '=':
                return 2;
            case '$':
                return 3;
            case 'S':
                return 4;
            case 'L':
                return 5;
            case 'R':
                return 6;

        }
        return -1;
    }
}
