package com.MyCourseApplication.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SsnValidator implements ConstraintValidator<Ssn, String> {

	public void initialize(Ssn paramA) {
	}

	public boolean isValid(String ssn, ConstraintValidatorContext ctx) {
		if (ssn == null) {
			return false;
		}
		if (ssn.matches("\\d{9}"))
			return true;
		else if (ssn.matches("\\d{3}-\\d{3}-\\d{4}"))
			return true;
		else
			return false;
	}
}
