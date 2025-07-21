/**
 * A program to find the minimum and maximum values from a user-specified number of marks.
 *
 * @author (your name)
 * @version (2025-07-21)
 */
import java.util.Scanner;

public class MinMaxValues {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = 0;

        // Enter the marks
        System.out.print("Enter number of marks: ");
        while (!input.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            System.out.print("Enter number of marks: ");
            input.next(); // Clear invalid input
        }
        n = input.nextInt();
        while (n <= 0) {
            System.out.println("Number of marks must be an integer.");
            System.out.print("Enter number of marks: ");
            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                System.out.print("Enter number of marks: ");
                input.next(); // Clear invalid input
            }
            n = input.nextInt();
        }

        double[] marks = new double[n];

        // Get valid marks
        for (int i = 0; i < n; i++) {
            System.out.print("Enter mark #" + (i + 1) + ": ");
            while (!input.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a number.");
                System.out.print("Enter mark #" + (i + 1) + ": ");
                input.next(); // Clear invalid input
            }
            double mark = input.nextDouble();
            while (mark < 0 || mark > 30) {
                System.out.println("Invalid mark. Please enter a value between 0 and 30.");
                System.out.print("Enter mark #" + (i + 1) + ": ");
                while (!input.hasNextDouble()) {
                    System.out.println("Invalid input. Please enter a number.");
                    System.out.print("Enter mark #" + (i + 1) + ": ");
                    input.next(); // Clear invalid input
                }
                mark = input.nextDouble();
            }
            marks[i] = mark;
        }

        double min = findMin(marks);
        double max = findMax(marks);

        // Output
        System.out.println("\nStatistics");
        System.out.printf("Minimum mark: %.2f\n", min);
        System.out.printf("Maximum mark: %.2f\n", max);
    }

    public static double findMin(double[] marks) {
        double min = marks[0];
        for (double mark : marks) {
            if (mark < min) min = mark;
        }
        return min;
    }

    public static double findMax(double[] marks) {
        double max = marks[0];
        for (double mark : marks) {
            if (mark > max) max = mark;
        }
        return max;
    }
}