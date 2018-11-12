package pl.pawelfrydrych.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("authorValidator")
public class AuthorValidator implements Validator {
	@Override
	public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
		String val = (String) o;
		String[] vals = val.split(" ");

		boolean valid = false;
		for (String s : vals) {
			if (s.startsWith("A")) {
				valid = true;
			}
		}

		if (!valid) {
			throw new ValidatorException(new FacesMessage("Value is invalid!"));
		}
	}
}
