//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        double firstNumber = 0;
        double secondNumber = 0;
        char operator = ' ';

        while (true) {
            String input = userInput.nextLine();

            if (input.equals("exit")) {
                break;
            }
            if (input.equals("+") || input.equals("-") ||
                    input.equals("*") || input.equals("/")) {

                operator = input.charAt(0);
            } else if (input.equals("=")) {

                if (operator == '+') {
                    firstNumber = firstNumber + secondNumber;
                } else if (operator == '-') {
                    firstNumber = firstNumber - secondNumber;
                } else if (operator == '*') {
                    firstNumber = firstNumber * secondNumber;
                } else if (operator == '/') {
                    firstNumber = firstNumber / secondNumber;
                }

                System.out.println(firstNumber);
            } else {

                secondNumber = Double.parseDouble(input);

                if (operator == ' ') {
                    firstNumber = secondNumber;
                }

                System.out.println(secondNumber);
            }
        }
    }
}