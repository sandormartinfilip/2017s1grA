package entities;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, User> {

	@Override
	public void initialize(ValidEmail constraintAnnotation) {

	}

	@Override
	public boolean isValid(User value, ConstraintValidatorContext context) {
		return value.getEmail().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "msggroup.com)$");
	}

}
