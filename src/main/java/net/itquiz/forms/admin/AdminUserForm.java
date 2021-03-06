package net.itquiz.forms.admin;

import net.itquiz.exceptions.InvalidUserInputException;
import net.itquiz.forms.AccountInfoForm;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * @author Artur Meshcheriakov
 */
public class AdminUserForm extends AccountInfoForm {

    private static final long serialVersionUID = -3393569577509014603L;

    protected Boolean active;
    protected Boolean confirmed;
    protected Boolean student;
    protected Boolean administrator;
    protected Boolean tutor;
    protected Boolean advancedTutor;

    public AdminUserForm() {
        super();
        this.active = Boolean.FALSE;
        this.confirmed = Boolean.FALSE;
        this.student = Boolean.FALSE;
        this.administrator = Boolean.FALSE;
        this.tutor = Boolean.FALSE;
        this.advancedTutor = Boolean.FALSE;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getStudent() {
        return student;
    }

    public void setStudent(Boolean student) {
        this.student = student;
    }

    public Boolean getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Boolean administrator) {
        this.administrator = administrator;
    }

    public Boolean getTutor() {
        return tutor;
    }

    public void setTutor(Boolean tutor) {
        this.tutor = tutor;
    }

    public Boolean getAdvancedTutor() {
        return advancedTutor;
    }

    public void setAdvancedTutor(Boolean advancedTutor) {
        this.advancedTutor = advancedTutor;
    }

    @Override
    public void validate(MessageSource messageSource) throws InvalidUserInputException {
        super.validate(messageSource);
        if (!administrator && !advancedTutor && !tutor && !student) {
            throw new InvalidUserInputException(messageSource.getMessage("roles.without.roles",
                    new Object[]{}, LocaleContextHolder.getLocale()));
        }
    }
}
