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
    //static Stack<Integer> stack = new Stack<>()
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

        String scell = a[Integer.parseInt(stack.substring(stack.length() - 1))][columNo(s.charAt(i))];

        String s1;
        
        while (true) {

            String cell = a[Integer.parseInt(stack.substring(stack.length() - 1))][columNo(s.charAt(i))];
            if (cell.startsWith("S")) {
                s1 = s.substring(0, 1);
                s = s.substring(1);
                stack = stack + s1;
                stack += cell.substring(1);

            } else if (cell==("acc")) {
                System.out.println("The statment id correct ");
                break;
            }
            else if( cell == e){
                System.out.println("NOT CORRECT !!!!");
                break;
            }
            else if( cell.startsWith("R")){
                
            }
        }
        System.out.println(stack);
        System.out.println(s);

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
