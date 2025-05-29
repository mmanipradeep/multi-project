package com.learnings.manipradeep.learnings;

import com.learnings.manipradeep.learnings.model.Person;
import com.learnings.manipradeep.learnings.validator.PersonValidator;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractPersonValidatorsTest {

    // children must provide a specific validator to be tested
    protected abstract PersonValidator getValidatorInstance();

    @Test
    public void person_isComplete_validationSucceed() {
        getValidatorInstance().validate(
                new Person("bill", "clinton", "bill@gmail.com", 60)
        );
    }

    @Test
    public void person_withoutFirstName_validationFail() {
        try {
            getValidatorInstance().validate(
                    new Person(null, "clinton", "bill@gmail.com", 60)
            );
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("firstname"));
        }
    }


    @Test
    public void person_shortFirstName_validationFail() {
        // Use assertThrows to check for the exception
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> getValidatorInstance().validate(
                        new Person("b", "clinton", "bill@gmail.com", 60)
                ),
                "Expected IllegalArgumentException to be thrown for short first name" // Optional message
        );

        // Assert that the exception message contains "firstname"
        assertTrue(thrown.getMessage().contains("firstname"),
                "Exception message should contain 'firstname'");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when first name is null")
    public void validate_personWithoutFirstName_throwsIllegalArgumentException() {
        Person personWithNullFirstName = new Person(null, "Clinton", "bill@gmail.com", 60);

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> getValidatorInstance().validate(personWithNullFirstName),
                "Expected IllegalArgumentException for null first name"
        );

        assertTrue(thrown.getMessage().contains("firstname"),
                "Exception message should contain 'firstname'");
    }
    @Test
    public void person_wrongEmail_validationFail() {
        try {
            getValidatorInstance().validate(
                    new Person("bill", "clinton", "bill_gmail.com", 60)
            );
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("email"));
        }
    }

    @Test
    public void person_didntBorn_validationFail() {
        try {
            getValidatorInstance().validate(
                    new Person("bill", "clinton", "bill@gmail.com", -10)
            );
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("age"));
        }
    }

    @Test
    public void person_isDeath_validationFail() {
        try {
            getValidatorInstance().validate(
                    new Person("bill", "clinton", "bill@gmail.com", 100000)
            );
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("age"));
        }
    }

}
