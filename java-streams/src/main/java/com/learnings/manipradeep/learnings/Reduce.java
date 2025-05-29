package com.learnings.manipradeep.learnings;

import java.util.Arrays;
import java.util.List;

public class Reduce {

    public int sumNumbers(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Input list cannot be null.");
        }
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        Reduce calculator = new Reduce();

        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        int total1 = calculator.sumNumbers(numbers1);
        System.out.println("Sum of " + numbers1 + " = " + total1); // Expected: 15

        List<Integer> numbers2 = Arrays.asList(10, 20, 30);
        int total2 = calculator.sumNumbers(numbers2);
        System.out.println("Sum of " + numbers2 + " = " + total2); // Expected: 60

        List<Integer> emptyList = List.of();
        int total3 = calculator.sumNumbers(emptyList);
        System.out.println("Sum of " + emptyList + " = " + total3); // Expected: 0

        List<Integer> singleElementList = List.of(99);
        int total4 = calculator.sumNumbers(singleElementList);
        System.out.println("Sum of " + singleElementList + " = " + total4); // Expected: 99

        // Example of handling null input (will throw IllegalArgumentException)
        try {
            calculator.sumNumbers(null);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
