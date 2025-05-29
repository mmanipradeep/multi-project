package com.learnings.manipradeep.learnings;

import com.learnings.manipradeep.learnings.validator.OldFashionedPersonValidator;
import com.learnings.manipradeep.learnings.validator.PersonValidator;

public class OldFashionedPersonValidatorTest extends AbstractPersonValidatorsTest {

    protected PersonValidator getValidatorInstance() {
        return new OldFashionedPersonValidator();
    }


}

