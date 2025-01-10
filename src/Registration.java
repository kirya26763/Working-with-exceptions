import Exceptions.WrongLoginException;
import Exceptions.WrongPasswordException;

import java.util.regex.Pattern;

public class Registration {
    private static Pattern PATTERN_LOGIN = Pattern.compile("[_a-zA-Z0-9]{1,20}");

    public static void entrance(String login, String password, String confirmPassword) {
        try {
            entranceLogin(login);
            entrancePassword(password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Вход завершён");
        }
    }

    private static void entrancePassword(String password, String confirmPassword) throws WrongPasswordException {
        if (!PATTERN_LOGIN.matcher(password).matches() || !password.equals(confirmPassword)) {
            throw new WrongPasswordException("Не коректно введен пароль");
        }
    }

    private static void entranceLogin(String login) throws WrongLoginException {
        if (!PATTERN_LOGIN.matcher(login).matches()) {
            {
                throw new WrongLoginException("Не коректно введён логин.");
            }
        }
    }
}
