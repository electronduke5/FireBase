package com.example.firebase2;

import org.junit.Assert;
import org.junit.Test;

import java.util.StringJoiner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void testIsMailValid(){
        String testEmail = "g.qwe@mail.ru";
        Assert.assertThat(String.format("Email невалидный %s ", testEmail),
                Utilities.checkEmailForValidity(testEmail), is(true));
    }

    @Test
    public void testIsPasswordValid(){
        String testPassword = "qQ123@qwe";
        Assert.assertThat(String.format("Неверный формат пароля: %s", testPassword),
                Utilities.checkPasswordForValidity(testPassword), is(true));
    }

    @Test
    public void testIsPhoneNumberValid(){
        String testPhone = "+7(904)413-00-76";
        Assert.assertThat(String.format("Неверный формат номера: %s", testPhone),
                Utilities.checkPhoneNumberForValidity(testPhone), is(true));
    }

    @Test
    public void testIsPasswordEquals(){
        String password = "qQ@qwe123";
        String confirmPassword = "qQ@qwe123";

        Assert.assertThat(String.format("Пароли %s и %s не совпадают!", password, confirmPassword),
                Utilities.checkPasswordForEquals(password, confirmPassword), is(true));
    }
}