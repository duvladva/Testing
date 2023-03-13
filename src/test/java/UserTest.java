import org.example.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.Assert.assertThrows;
import static org.testng.AssertJUnit.assertNull;

class UserTest {

    public static final String VALID_LOGIN = "Ivan";
    public static final String INVALID_LOGIN_1 = null;
    public static final String INVALID_LOGIN_2 = "";
    public static final String INVALID_LOGIN_3 = " ";
    public static final String VALID_EMAIL = "ivan@mail.ru";
    public static final String INVALID_EMAIL_1 = null;
    public static final String INVALID_EMAIL_2 = "";
    public static final String INVALID_EMAIL_3 = " ";
    public static final String INVALID_EMAIL_4 = "ivan.mail.ru";
    public static final String INVALID_EMAIL_5 = "ivan@mailru";

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

        assertThrows(IllegalArgumentException.class, () -> new User(INVALID_LOGIN_1, VALID_EMAIL));
        assertThrows(IllegalArgumentException.class, () -> new User(INVALID_LOGIN_2, VALID_EMAIL));
        assertThrows(IllegalArgumentException.class, () -> new User(INVALID_LOGIN_3, VALID_EMAIL));
    }

    @Test
    @DisplayName("Проверка ошибки при создании объекта с некорректной почтой")
    void creatingUserWithNotValidEmail() {

        assertThrows(IllegalArgumentException.class, () -> new User(VALID_LOGIN, INVALID_EMAIL_1));
        assertThrows(IllegalArgumentException.class, () -> new User(VALID_LOGIN, INVALID_EMAIL_2));
        assertThrows(IllegalArgumentException.class, () -> new User(VALID_LOGIN, INVALID_EMAIL_3));
        assertThrows(IllegalArgumentException.class, () -> new User(VALID_LOGIN, INVALID_EMAIL_4));
        assertThrows(IllegalArgumentException.class, () -> new User(VALID_LOGIN, INVALID_EMAIL_5));
    }

//    @Test
//    @DisplayName("проверка ошибки при установке некорректного логина")
//    void settingLoginEqualEmail() {
//        User user = new User(VALID_LOGIN, VALID_EMAIL);
//        user.setUserLogin(INVALID_LOGIN);
//        assertEquals(INVALID_LOGIN,user.getUserLogin());
//    }
//    @Test
//    @DisplayName("Проверка ошибки при установке некорректного email")
//    void settingInvalidEmail() {
//        User user = new User(VALID_LOGIN, VALID_EMAIL);
//        user.setUserEmail(INVALID_EMAIL);
//        assertEquals(INVALID_EMAIL,user.getUserEmail());
//    }

}
