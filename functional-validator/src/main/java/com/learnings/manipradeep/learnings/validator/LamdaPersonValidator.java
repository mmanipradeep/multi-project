package com.learnings.manipradeep.learnings.validator;

import com.learnings.manipradeep.learnings.model.Person;

import static com.learnings.manipradeep.learnings.validations.helpers.IntegerValidationHelpers.intBetween;
import static com.learnings.manipradeep.learnings.validations.helpers.StringValidationHelpers.*;

public class LamdaPersonValidator implements PersonValidator {
    public void validate(Person person) {
        notNull.and(between(2, 12)).test(person.getFirstName()).throwIfInvalid("firstname");
        notNull.and(between(4, 30)).test(person.getLastName()).throwIfInvalid("secondname");
        notNull.and(between(3, 50)).and(contains("@")).test(person.getEmail()).throwIfInvalid("email");
        intBetween(0, 110).test(person.getAge()).throwIfInvalid("age");
    }
}
