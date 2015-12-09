package ua.com.itquiz.services;

import ua.com.itquiz.entities.Account;
import ua.com.itquiz.exceptions.InvalidUserInputException;
import ua.com.itquiz.forms.AdminUserForm;

import java.util.List;

/**
 * @author Artur Meshcheriakov
 */
public interface AdminService {

    int accountCount();

    List<Account> getAccounts(int offset, int count);

    void addUser(AdminUserForm form) throws InvalidUserInputException;

    void editUser(int idAccount, AdminUserForm form) throws InvalidUserInputException;

    void removeAccount(int accountId) throws InvalidUserInputException;

}
