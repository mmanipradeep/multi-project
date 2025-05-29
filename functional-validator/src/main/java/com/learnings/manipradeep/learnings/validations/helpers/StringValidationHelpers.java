package com.learnings.manipradeep.learnings.validations.helpers;

import com.learnings.manipradeep.learnings.validations.SimpleValidation;
import com.learnings.manipradeep.learnings.validations.Validation;

import java.util.Objects;

import static java.lang.String.format;

public class StringValidationHelpers {

    public static Validation<String> notNull = SimpleValidation.from(Objects::nonNull, "must not be null.");

    public static Validation<String> moreThan(int size){
        return SimpleValidation.from((s) -> s.length() >= size, format("must have more than %s chars.", size));
    }

    public static Validation<String> lessThan(int size){
        return SimpleValidation.from((s) -> s.length() <= size, format("must have less than %s chars.", size));
    }

    public static Validation<String> between(int minSize, int maxSize){
        return moreThan(minSize).and(lessThan(maxSize));
    }

    public static Validation<String> contains(String c){
        return SimpleValidation.from((s) -> s.contains(c), format("must contain %s", c));
    }
}


