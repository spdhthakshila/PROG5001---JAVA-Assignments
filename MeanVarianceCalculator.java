/**
 * Write a description of class MeanVarianceCalculator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class MeanVarianceCalculator
{
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
                // System.out.println("Invalid input. Please enter an integer.");
                System.out.print("Enter number of marks: ");
                input.next(); // Clear invalid input
            }
            n = input.nextInt();
        }
        double[] marks = new double[n];

        // Get valid marks
        for (int i = 0; i < n; i++) {
            System.out.print("Enter mark # " + (i + 1) +" :" );
            double mark = input.nextDouble();
            while (mark < 0 || mark > 30) {
                System.out.println("Invalid mark. Please enter a value between 0 and 30.");
                System.out.print("Enter mark # :" + (i + 1)+" :");
                mark = input.nextDouble();
            }
            marks[i] = mark;
        }
        
        double mean = findMean(marks);
        double variance = findVariance(marks, mean);

        // Output
        System.out.println("\n  Statistics   ");
        System.out.println("Mean: " + mean);
        System.out.println("Variance: " + variance);
    }

    public static double findMean(double[] marks) {
        double sum = 0;
        for (double mark : marks) {
            sum += mark;
        }
        return sum / marks.length;
    }

    public static double findVariance(double[] marks, double mean) {
        double sum = 0;
        for (double mark : marks) {
            sum += (mark - mean) * (mark - mean);
        }
        return sum / marks.length;
    }
}