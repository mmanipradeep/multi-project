package com.manipradeep.learnings;

import com.manipradeep.learnings.validator.OldFashionedPersonValidator;
import com.manipradeep.learnings.validator.PersonValidator;

public class OldFashionedPersonValidatorTest extends AbstractPersonValidatorsTest {

    protected PersonValidator getValidatorInstance() {
        return new OldFashionedPersonValidator();
    }


}

