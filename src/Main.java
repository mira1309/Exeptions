import exceptoins.WrongLoginException;
import exceptoins.WrongPasswordExceptoin;

import java.util.regex.Pattern;

public class Main {

    public static final String REQUIREMENTS = "Логин/пароль должен содержать только латинские буквы, цифры и знак подчеркивания";

    public static void main(String[] args) {
        String login = "Скай";
        String password = "Sky";
        String confirmPassword = "Sky";

        try {
            checkLoginAndPassword(login, password, confirmPassword);
        } catch (WrongPasswordExceptoin e) {
            System.out.println(e.getMessage());
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Проверка логина и пароля выполнена");
        }
    }
    public static void checkLoginAndPassword (String login, String password, String confirmPassword) throws WrongPasswordExceptoin, WrongLoginException {
        checkLogin(login);
        checkPassword(password, confirmPassword);

        }
        private static void checkLogin (String login) throws WrongLoginException{

           Pattern p = Pattern.compile("^[A-Za-z0-9_]{1,20}$");
           if(!p.matcher(login).matches()){
               throw new WrongLoginException(String.format("Логин %s не подходит под требования: %s", login, REQUIREMENTS));
           }
    }
        private static void checkPassword (String password, String confirmPassword) throws WrongPasswordExceptoin {

            Pattern p = Pattern.compile("^[A-Za-z0-9_]{1,20}$");
            if (!p.matcher(password).matches()) {
            throw new WrongPasswordExceptoin(String.format("Пароль не подходит под требования: %s", REQUIREMENTS ));
            }
            if (!password.equals(confirmPassword)) {
            throw new WrongPasswordExceptoin("Пароли не совпадают");
            }
        }
}