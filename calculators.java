/**
 * A simple calculator program that performs basic arithmetic operations
 * and saves/reads numbers from a file.
 * Author: James
 * Date: 21st July 2023
 * Update: 2nd Noveember 2025
 */

import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

/**
 * Calculators class containing methods for arithmetic operations
 * and file handling.
 */
public class Calculators {
    /**
     * Multiplies two integers.
     */
    public static int multiply(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }
    /**
     * Divides two integers, handling division by zero.
     */
    public static String divide(int firstNumber, int secondNumber) {
        if (secondNumber == 0) {
            System.out.println("Error: Division by zero");
            return "undefined";
        }
        double result = (double) firstNumber / secondNumber;
        return String.format("%.2f", result);
    }
    /**
     * Adds two integers.
     */
    public static int addition(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }
    /**
     * Subtracts the second integer from the first.
     */
    public static int subtract(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    /**
     * Saves two integers to a file.
     */
    public static void saveNumbers(int firstNumber, int secondNumber) throws Exception{
        PrintWriter fileWriter = new PrintWriter("user.data");

        fileWriter.printf("%d %d",firstNumber,secondNumber);
        fileWriter.flush();
        fileWriter.close();
    }

    /**
     * Reads an integer from a file scanner.
     */
    public static int readNumber(Scanner fileScanner) throws Exception {
        return fileScanner.nextInt();
    }

    /**
     * Main method to execute the calculator program.
     */
    public static void main(String[] args) throws Exception {
        File userDataFile = new File("user.data");

        if (!userDataFile.exists()) {
            PrintWriter writer = new PrintWriter(userDataFile);
            writer.printf("0 0");
            writer.close();
        }

        Scanner systemInScanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Simple Calculator!");
        System.out.println("--------------------------------");

        System.out.printf("Enter the first number: ");
        int firstNumber = systemInScanner.nextInt();

        System.out.printf("Enter the second number: ");
        int secondNumber = systemInScanner.nextInt();

        systemInScanner.close();

        System.out.println("\nSaving numbers to file...");

        saveNumbers(firstNumber, secondNumber);

        System.out.println("Numbers saved to 'user.data'.\n");

        Scanner fileScanner = new Scanner(userDataFile);
        int firstFileNumber = readNumber(fileScanner);
        int secondFileNumber = readNumber(fileScanner);
        fileScanner.close();

        System.out.println();
        System.out.println("=== Results from User Input ===");
        System.out.printf("%d × %d = %d%n", firstNumber, secondNumber, multiply(firstNumber, secondNumber));
        System.out.printf("%d ÷ %d = %s%n", firstNumber, secondNumber, divide(firstNumber, secondNumber));
        System.out.printf("%d + %d = %d%n", firstNumber, secondNumber, addition(firstNumber,secondNumber));
        System.out.printf("%d - %d = %d%n", firstNumber, secondNumber, subtract(firstNumber, secondNumber));

        System.out.println();
        System.out.println("=== Results from File ===");
        System.out.printf("%d × %d = %d%n", firstFileNumber, secondFileNumber, multiply(firstFileNumber, secondFileNumber));
        System.out.printf("%d ÷ %d = %s%n", firstFileNumber, secondFileNumber, divide(firstFileNumber, secondFileNumber));
        System.out.printf("%d + %d = %d%n", firstFileNumber, secondFileNumber, addition(firstFileNumber,secondFileNumber));
        System.out.printf("%d - %d = %d%n", firstFileNumber, secondFileNumber, subtract(firstFileNumber, secondFileNumber));
    }
}
