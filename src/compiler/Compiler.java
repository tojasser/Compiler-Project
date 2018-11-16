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
    static Stack<String> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner read = new Scanner(System.in);
        String input = read.next();
        input = input.concat("$");

        stack.push("0");
        String e = "empty";
        String[][] table = {
            {"S5", "S4", e, e, "1", "2", "3"},//state 0
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
        input = input.replaceAll("id", "x");
        String cell = table[Integer.parseInt(stack.peek())][Coulmno(String.valueOf(input.charAt(0)))];

        while (true) {

            if (cell.startsWith("S")) {
                String ns = input.substring(0, 1);
                stack.push(ns);
                input = input.substring(1, input.length());
                stack.push(cell = cell.substring(1, cell.length()));
            }

            if (cell == e) {
                System.out.println("WRONG WORD!!, TRY AGIN");
                break;
            }
            if (cell == "acc") {

                System.out.println("Word is correct ,Willdone!!");
                break;
            }

            if (cell.startsWith("R")) {
                stack.push(reduce(Integer.parseInt(cell.substring(1, cell.length()))));
                String p1 = stack.pop();
                String p2 = stack.pop();

                String p3 = (table[Integer.parseInt(p2)][(Coulmno(p1))]);
                stack.push(p2);
                stack.push(p1);
                stack.push(p3);

            }

            cell = table[Integer.parseInt(stack.peek())][Coulmno(String.valueOf(input.charAt(0)))];

        }

    }

    public static String reduce(int x) {
        switch (x) {
            case 1:
                drop(6);
                return "S";
            case 2:
                drop(2);
                return "S";
            case 3:
                drop(4);
                return "L";
            case 4:
                drop(2);
                return "L";
            case 5:
                drop(2);
                return "R";

        }
        return "";
    }

    public static void drop(int x) {
        for (int i = 0; i < x; i++) {
            stack.pop();

        }
    }

    public static int Coulmno(String a) {
        return "x*=$SLR".indexOf(a);
    }
}
