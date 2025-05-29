package com.learnings.manipradeep.learnings;


import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MultiMapTest {

    @Test
    void testProcessWords_basicCase() {
        List<String> inputWords = Arrays.asList(
                "Hello Java",
                "Python is cool",
                "Learn Java Programming",
                "C++ is powerful"
        );
        List<String> expected = Arrays.asList("HELLO JAVA", "LEARN JAVA PROGRAMMING");
        List<String> result = MapMulti.processWords(inputWords);

        assertNotNull(result, "Result list should not be null");
        assertEquals(expected.size(), result.size(), "Result list size should match expected");
        assertTrue(result.containsAll(expected) && expected.containsAll(result), "Result list should contain all expected elements");
    }

    @Test
    void testProcessWords_noJavaWords() {
        List<String> inputWords = Arrays.asList(
                "Go Lang",
                "Rust is fast",
                "Scala features",
                "Kotlin is modern"
        );
        List<String> expected = List.of(); // Expect an empty list
        List<String> result = MapMulti.processWords(inputWords);

        assertNotNull(result, "Result list should not be null");
        assertTrue(result.isEmpty(), "Result list should be empty when no 'Java' words are present");
        assertEquals(expected, result, "Result list should be empty and equal to expected");
    }

    @Test
    void testProcessWords_emptyInput() {
        List<String> inputWords = List.of(); // Empty input list
        List<String> expected = List.of(); // Expect an empty list
        List<String> result = MapMulti.processWords(inputWords);

        assertNotNull(result, "Result list should not be null");
        assertTrue(result.isEmpty(), "Result list should be empty for empty input");
        assertEquals(expected, result, "Result list should be empty and equal to expected");
    }

    @Test
    void testProcessWords_allJavaWords() {
        List<String> inputWords = Arrays.asList(
                "Java 1",
                "Java 2",
                "Java 3"
        );
        List<String> expected = Arrays.asList("JAVA 1", "JAVA 2", "JAVA 3");
        List<String> result = MapMulti.processWords(inputWords);

        assertNotNull(result, "Result list should not be null");
        assertEquals(expected.size(), result.size(), "Result list size should match expected");
        assertTrue(result.containsAll(expected) && expected.containsAll(result), "Result list should contain all expected elements");
    }

    @Test
    void testProcessWords_caseInsensitivityOfContains() {
        List<String> inputWords = Arrays.asList(
                "hello Java", // lower case
                "Java IS FUN", // upper case
                "myJavaApp" // mixed case
        );
        // The contains("Java") check is case-sensitive, so "hello java" will not match "Java"
        List<String> expected = Arrays.asList("HELLO JAVA", "JAVA IS FUN", "MYJAVAAPP");
        List<String> result = MapMulti.processWords(inputWords);

        assertNotNull(result, "Result list should not be null");
        assertEquals(expected.size(), result.size(), "Result list size should match expected");
        assertTrue(result.containsAll(expected) && expected.containsAll(result), "Result list should contain all expected elements, respecting case sensitivity of 'contains'");
    }
}
