
package com.educationit.java.standard.integrator.test;


import org.junit.jupiter.api.*;

import com.educationit.java.standard.integrator.beans.User;
import com.educationit.java.standard.integrator.service.AbstractSecurity;
import com.educationit.java.standard.integrator.service.impl.JDBCSecurityService;
import com.educationit.java.standard.integrator.service.BadDataException;
import com.educationit.java.standard.integrator.service.SecutiryException;


public class JDBCLoginTest {


    private static AbstractSecurity security;


    @BeforeAll
    public static void setup () throws Exception {

        security = new JDBCSecurityService();
    }

    @AfterAll
    public static void destroy () {

        security = null;
    }

    @Test
    @DisplayName ("Check User name [OK]")
    public void checkUserNameOK () {

        try {

            User user = new User ("raul.pena@gmail.com", "123");

            security.signIn (user);
            Assertions.assertTrue (Boolean.TRUE);

        } catch (Exception ex) {

            Assertions.assertFalse (Boolean.TRUE, "Problems executing the test!");
        }
    }

    @Test
    @DisplayName ("Check User name [KO]")
    public void checkUserNameKO () {

        try {

            User user = new User ("raul.pena2@gmail.com", "123");

            Assertions.assertThrows (SecutiryException.class, ()-> security.signIn (user));

        } catch (Exception ex) {

            Assertions.assertFalse (Boolean.TRUE, "Problems executing the test!");
        }
    }

    @Test
    @DisplayName ("Check User Enabled [KO]")
    public void checkUserEnabledKO () {

        try {

            User user = new User ("raul.pena@hotmail.com", "123");

            Assertions.assertThrows (SecutiryException.class, ()-> security.signIn (user));

        } catch (Exception ex) {

            Assertions.assertFalse (Boolean.TRUE, "Problems executing the test!");
        }
    }

    @Test
    @DisplayName ("Check User Correct Format [KO]")
    public void checkUserCorrectFormat () {

        try {

            User user = new User ("raul.pena.hotmail.com", "123");

            Assertions.assertThrows (BadDataException.class, ()-> security.signIn (user));

        } catch (Exception ex) {

            Assertions.assertFalse (Boolean.TRUE, "Problems executing the test!");
        }
    }

    @Test
    @DisplayName ("Check User Invalid Password")
    public void checkUserInvalidPassword () {

        try {

            User user = new User ("raul.pena@yahoo.com", "123");

            Assertions.assertThrows (SecutiryException.class, ()-> security.signIn (user));

        } catch (Exception ex) {

            Assertions.assertFalse (Boolean.TRUE, "Problems executing the test!");
        }
    }
}