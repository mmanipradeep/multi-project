package com.learnings.manipradeep.learnings.validations.helpers;

import com.learnings.manipradeep.learnings.validations.SimpleValidation;
import com.learnings.manipradeep.learnings.validations.Validation;

import static java.lang.String.format;

public class IntegerValidationHelpers {

    public static Validation<Integer> lowerThan(int max){
        return SimpleValidation.from((i) -> i < max, format("must be lower than %s.", max));
    }

    public static Validation<Integer> greaterThan(int min){
        return SimpleValidation.from((i) -> i > min, format("must be greater than %s.", min));
    }

    public static Validation<Integer> intBetween(int min, int max){
        return greaterThan(min).and(lowerThan(max));
    }
}
