import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

public class Calculators {
    public static int multiply(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    public static int divide(int firstNumber, int secondNumber) {
        if (secondNumber == 0) {
            System.out.println("Error: Division by zero");
            return 0;
        }
        return firstNumber / secondNumber;
    }

    public static int addition(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public static int subtract(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    public static void saveNumbers(int firstNumber, int secondNumber) throws Exception{
        PrintWriter fileWriter = new PrintWriter("user.data");

        fileWriter.printf("%d %d",firstNumber,secondNumber);
        fileWriter.flush();
        fileWriter.close();
    }

    public static int readNumber(Scanner fileScanner) throws Exception {
        return fileScanner.nextInt();
    }

    public static void main(String[] args) throws Exception {
        File userDataFile = new File("user.data");

        if (!userDataFile.exists()) {
            PrintWriter writer = new PrintWriter(userDataFile);
            writer.printf("0 0");
            writer.close();
        }

        Scanner systemInScanner = new Scanner(System.in);

        System.out.printf("Enter a number: ");
        int firstNumber = systemInScanner.nextInt();

        System.out.printf("Enter the second number: ");
        int secondNumber = systemInScanner.nextInt();

        systemInScanner.close();

        saveNumbers(firstNumber, secondNumber);

        Scanner fileScanner = new Scanner(userDataFile);
        int firstFileNumber = readNumber(fileScanner);
        int secondFileNumber = readNumber(fileScanner);
        fileScanner.close();

        System.out.println("From User Input");
        System.out.printf("%d * %d = %d\n", firstNumber, secondNumber, multiply(firstNumber, secondNumber));
        System.out.printf("%d / %d = %d\n", firstNumber, secondNumber, divide(firstNumber, secondNumber));
        System.out.printf("%d + %d = %d\n", firstNumber, secondNumber, addition(firstNumber,secondNumber));
        System.out.printf("%d - %d = %d\n", firstNumber, secondNumber, subtract(firstNumber, secondNumber));

        System.out.println("From File");
        System.out.printf("%d * %d = %d\n", firstFileNumber, secondFileNumber, multiply(firstFileNumber, secondFileNumber));
        System.out.printf("%d / %d = %d\n", firstFileNumber, secondFileNumber, divide(firstFileNumber, secondFileNumber));
        System.out.printf("%d + %d = %d\n", firstFileNumber, secondFileNumber, addition(firstFileNumber,secondFileNumber));
        System.out.printf("%d - %d = %d\n", firstFileNumber, secondFileNumber, subtract(firstFileNumber, secondFileNumber));
    }
}
