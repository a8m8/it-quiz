package ua.com.itquiz.forms.admin;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import ua.com.itquiz.entities.Account;
import ua.com.itquiz.exceptions.InvalidUserInputException;
import ua.com.itquiz.forms.Copyable;

/**
 * @author Artur Meshcheriakov
 */

public class SignUpForm extends AccountInfoForm implements Copyable<Account> {

    private static final long serialVersionUID = 2155252411443776689L;

    protected String password;
    protected String passwordConfirmed;
    protected Boolean active = Boolean.TRUE;
    protected Boolean confirmed = Boolean.FALSE;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmed() {
        return passwordConfirmed;
    }

    public void setPasswordConfirmed(String passwordConfirmed) {
        this.passwordConfirmed = passwordConfirmed;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    @Override
    public void validate(MessageSource messageSource) throws InvalidUserInputException {
        super.validate(messageSource);
        if (StringUtils.isBlank(password)) {
            throw new InvalidUserInputException(
                    messageSource.getMessage("passwords.required", new Object[]{}, LocaleContextHolder.getLocale()));
        }
        if (password.length() > 60) {
            throw new InvalidUserInputException(
                    messageSource.getMessage("volume.exceed", new Object[]{}, LocaleContextHolder.getLocale()));
        }
        if (!StringUtils.equals(password, passwordConfirmed)) {
            throw new InvalidUserInputException(
                    messageSource.getMessage("passwords.not.match", new Object[]{}, LocaleContextHolder.getLocale()));
        }
    }

    @Override
    public void copyFieldsTo(Account account) {
        account.setEmail(email);
        account.setLogin(login);
        account.setPassword(password);
        account.setFio(fio);
        account.setConfirmed(confirmed);
        account.setActive(active);
    }

}