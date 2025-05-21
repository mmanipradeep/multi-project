package com.manipradeep.learnings;

import com.manipradeep.learnings.validator.LamdaPersonValidator;
import com.manipradeep.learnings.validator.PersonValidator;

public class LamdaPersonValidatorTest extends AbstractPersonValidatorsTest{

    protected PersonValidator getValidatorInstance() {
        return new LamdaPersonValidator();
    }
}
