import org.example.User;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    public static final String VALID_LOGIN = "Ivan";
    public static final String INVALID_LOGIN = "///";
    public static final String VALID_EMAIL = "ivan@mail.ru";
    public static final String INVALID_EMAIL = "ivan.mail.ru";

    @Test
    @DisplayName("проверка создания объекта без параметров")
    void creatingUserWithoutArguments() {
        User user = new User();
        assertNull(user.getUserLogin());
        assertNull(user.getUserEmail());
    }

    @Test
    @DisplayName("Проверка создания объекта с параметрами")
    void creatingUserWithAllArguments() {
        User user = new User(VALID_LOGIN, VALID_EMAIL);
        assertEquals(VALID_LOGIN,user.getUserLogin());
        assertEquals(VALID_EMAIL,user.getUserEmail());
    }

    @Test
    @DisplayName("Проверка ошибки при создании объекта с некорректным логином")
    void creatingUserWithNotValidLogin() {
        User user = new User(INVALID_LOGIN, VALID_EMAIL);
        assertEquals(INVALID_LOGIN, user.getUserLogin());
    }

    @Test
    @DisplayName("Проверка ошибки при создании объекта с некорректной почтой")
    void creatingUserWithNotValidEmail() {
        User user = new User(VALID_LOGIN, INVALID_EMAIL);
        assertEquals(INVALID_EMAIL, user.getUserEmail());
    }

    @Test
    @DisplayName("проверка ошибки при установке некорректного логина")
    void settingLoginEqualEmail() {
        User user = new User(VALID_LOGIN, VALID_EMAIL);
        user.setUserLogin(INVALID_LOGIN);
        assertEquals(INVALID_LOGIN,user.getUserLogin());
    }
    @Test
    @DisplayName("Проверка ошибки при установке некорректного email")
    void settingInvalidEmail() {
        User user = new User(VALID_LOGIN, VALID_EMAIL);
        user.setUserEmail(INVALID_EMAIL);
        assertEquals(INVALID_EMAIL,user.getUserEmail());
    }

}
