package com.mycompany.arrays_parallelbmi;
import java.util.*;

public class Arrays_parallelbmi {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user to enter the number of people
        System.out.print("Enter the number of people: ");
        int numPeople = scanner.nextInt();
        
        // Initialize arrays to store weights, heights, and BMIs for each person
        double[] weights = new double[numPeople];
        double[] heights = new double[numPeople];
        double[] BMIs = new double[numPeople];
        
        // Input weights and heights for each person
        for (int i = 0; i < numPeople; i++) {
            System.out.println("\nPerson " + (i + 1) + ":"); // Getting each person on a new line
            weights[i] = getValidWeight(scanner); // Call method to get valid weight
            heights[i] = getValidHeight(scanner); // Call method to get valid height
        }
        
        // Calculate BMI for each person
        for (int i = 0; i < numPeople; i++) {
            BMIs[i] = calculateBMI(weights[i], heights[i]);
        }
        
        // Display BMI results for each person
        System.out.println("\nBMI Results:");
        for (int i = 0; i < numPeople; i++) {
            System.out.printf("Person %d: %.2f\n", (i + 1), BMIs[i]);
            
            // Categorize BMI and print the category
            if (BMIs[i] < 18.5) {
                System.out.println("Underweight");
            } else if (BMIs[i] < 25) {
                System.out.println("Normal Weight");
            } else if (BMIs[i] < 30) {
                System.out.println("Overweight"); 
            } else {
                System.out.println("Obese"); 
            }
        }
        scanner.close(); // Close the scanner
    }

    // Method to calculate BMI
    public static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    // Method to get valid weight from user
    public static double getValidWeight(Scanner scanner) {
        double weight;
        while (true) {
            System.out.print("Enter weight in kilograms: ");
            weight = scanner.nextDouble();
            if (weight > 0) {
                break;
            }
            System.out.println("Weight must be greater than zero. Please enter again.");
        }
        return weight;
    }

    // Method to get valid height from user
    public static double getValidHeight(Scanner scanner) {
        double height;
        while (true) {
            System.out.print("Enter height in meters: ");
            String heightInput = scanner.next();
            try {
                height = Double.parseDouble(heightInput);
                if (height > 0) {
                    break;
                }
                System.out.println("Height must be greater than zero. Please enter again.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Height must be a number.");
            }
        }
        return height;
    }
}
