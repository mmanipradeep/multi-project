package com.learnings.manipradeep.learnings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapMulti {

    public static List<String> processWords(List<String> words) {
        return words.stream()
                .<String>mapMulti((word, downstream) -> {
                    if (word.contains("Java")) {
                        downstream.accept(word.toUpperCase()); // YELLING IN JAVA
                    }
                })
                .collect(Collectors.toList());
    }

//    public static void main(String[] args) {
//        List<String> inputWords = Arrays.asList(
//                "hello Java", // lower case
//                "Java IS FUN", // upper case
//                "myJavaApp" // mixed case
//        );
//
//        List<String> result = processWords(inputWords);
//
//        System.out.println("Original words: " + inputWords);
//        System.out.println("Processed words: " + result);
//    }
}
