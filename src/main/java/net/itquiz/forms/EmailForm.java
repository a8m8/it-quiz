package net.itquiz.forms;

import net.itquiz.exceptions.InvalidUserInputException;
import net.itquiz.forms.utils.EmailValidator;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * @author Artur Meshcheriakov
 */
public class EmailForm implements IForm {

    private static final long serialVersionUID = -4089527274880027630L;

    protected String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void validate(MessageSource messageSource) throws InvalidUserInputException {
        if (StringUtils.isBlank(email)) {
            throw new InvalidUserInputException(
                    messageSource.getMessage("email.required", new Object[]{}, LocaleContextHolder.getLocale()));
        }
        if (!EmailValidator.isValid(email)) {
            throw new InvalidUserInputException(
                    messageSource.getMessage("email.invalid", new Object[]{}, LocaleContextHolder.getLocale()));
        }
        if (email.length() > 60) {
            throw new InvalidUserInputException(
                    messageSource.getMessage("email.invalid", new Object[]{}, LocaleContextHolder.getLocale()));
        }
    }

}
