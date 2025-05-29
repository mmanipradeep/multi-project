package com.learnings.manipradeep.learnings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReduceTest {

    private Reduce main; // Instance of the class under test

    @BeforeEach
    void setUp() {
        main = new Reduce(); // Initialize a new instance before each test
    }

    @Test
    void testSumNumbers_PositiveIntegers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int expectedSum = 15;
        int actualSum = main.sumNumbers(numbers);
        assertEquals(expectedSum, actualSum, "Sum of positive integers should be correct");
    }

    @Test
    void testSumNumbers_MixedIntegers() {
        List<Integer> numbers = Arrays.asList(-1, 0, 1, 10, -5);
        int expectedSum = 5; // -1 + 0 + 1 + 10 + -5 = 5
        int actualSum = main.sumNumbers(numbers);
        assertEquals(expectedSum, actualSum, "Sum of mixed integers should be correct");
    }

    @Test
    void testSumNumbers_EmptyList() {
        List<Integer> numbers = Collections.emptyList(); // Or Arrays.asList()
        int expectedSum = 0;
        int actualSum = main.sumNumbers(numbers);
        assertEquals(expectedSum, actualSum, "Sum of an empty list should be 0");
    }

    @Test
    void testSumNumbers_SingleElementList() {
        List<Integer> numbers = List.of(42);
        int expectedSum = 42;
        int actualSum = main.sumNumbers(numbers);
        assertEquals(expectedSum, actualSum, "Sum of a single-element list should be the element itself");
    }

    @Test
    void testSumNumbers_LargeNumbers() {
        List<Integer> numbers = Arrays.asList(1000000, 2000000, 3000000);
        int expectedSum = 6000000;
        int actualSum = main.sumNumbers(numbers);
        assertEquals(expectedSum, actualSum, "Sum of large numbers should be correct");
    }

    @Test
    void testSumNumbers_NullList() {
        // Using assertThrows to verify that an IllegalArgumentException is thrown
        // when the input list is null.
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> main.sumNumbers(null),
                "Expected IllegalArgumentException for null input list"
        );

        // Optionally, check the exception message
        assertTrue(thrown.getMessage().contains("null"),
                "Exception message should indicate null input");
    }
}
