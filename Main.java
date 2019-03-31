import java.util.Scanner;

public class Main {
    private static RegEx regEx = new RegEx();
    private static String regularExpression;
    private static int choice;

    private static Scanner readRegex = new Scanner(System.in);
    private static Scanner readChoice = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("choose 1 to convert from Regular Expression to NFA -> DFA \n -your choice: ");
        choice = readChoice.nextInt();
        switch (choice){
            case 1:
                RegexToNFA();
                break;

            default:
                System.out.println("undefined choice!!");
                System.exit(1);
        }


    }

    private static void RegexToNFA() {
        System.out.println("Enter the desired regular expression : ");
        regularExpression = readRegex.next();
        readRegex.close();

        NFA nfa = RegEx.generateNFA(regularExpression);
        nfa.printNFA();

    }
}

