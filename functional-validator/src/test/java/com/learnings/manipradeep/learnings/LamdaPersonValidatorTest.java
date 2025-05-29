package com.learnings.manipradeep.learnings;

import com.learnings.manipradeep.learnings.validator.LamdaPersonValidator;
import com.learnings.manipradeep.learnings.validator.PersonValidator;

public class LamdaPersonValidatorTest extends AbstractPersonValidatorsTest{

    protected PersonValidator getValidatorInstance() {
        return new LamdaPersonValidator();
    }
}
