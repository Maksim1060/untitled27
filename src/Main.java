import exeptions.WrongLoginException;
import exeptions.WrongPasswordException;

import java.util.regex.Pattern;



public class Main {
    public static final String REQUIREMEENTS = "Логин/пароль должен содержать только латинские буквы, цифры и подчеркивания";


    public static void main(String[] args) {
        String login = "login";
        String password = "password";
        String confirmPassword = "pasword";
        try {
            checkLoginAndPassword(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Проверка логина и пароля выполнена");
        }


    }

    public static void checkLoginAndPassword(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        isLogin(login);
        isPasswordCorret(password,confirmPassword);

    }

    private static void isLogin(String login) throws WrongLoginException {
        int maxLoginLenght = 20;
        if (login.length() > maxLoginLenght) {
            throw new WrongLoginException(String.format("Длинна должна быть меньше " + maxLoginLenght));
        }
        Pattern p=Pattern.compile("^[A-Za-z0-9_-]{1,20}");
        if (!p.matcher(login).matches()) {
            throw new WrongLoginException(String.format("Логин не подходит под требования " )+REQUIREMEENTS);

        }

    }

    public static void onlyLatin(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((c >= '\u0041' && c <= '\u005a') || (c >= '\u0061' && c <= '\u007A') || (c == '\u007A')) {

            }

        }

    }
    private static boolean isPasswordCorret(String password, String confirmPassword) throws WrongPasswordException, WrongLoginException {
        Pattern p = Pattern.compile("^[A-Za-z0-9_-]{1,20}");
        if (!p.matcher(password).matches()) {
            throw new WrongLoginException(String.format("Пароль не подходит под требования ")+REQUIREMEENTS);
        }
     if (!password.equals(confirmPassword)){
         throw new WrongLoginException("Пароль не совпадает");
     }return true;
    }
}