package com.MyCourseApplication.validations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = SsnValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)

public @interface Ssn {

	String message() default "The SSN number format is incorrect";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
