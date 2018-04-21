
package com.educationit.java.standard.integrator.service.impl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.educationit.java.standard.integrator.beans.User;
import com.educationit.java.standard.integrator.service.AbstractSecurity;
import com.educationit.java.standard.integrator.service.SecutiryException;


public class JDBCSecurityService extends AbstractSecurity {


    public JDBCSecurityService () throws Exception {

        super ();

        Class.forName ("com.mysql.jdbc.Driver").newInstance();
    }


    private Connection getConnection () throws Exception {

        return DriverManager.getConnection ("jdbc:mysql://localhost/educationit", "root", "");
    }


    @Override
    protected void doCheckUsername (User user) throws SecutiryException {

        Connection cnn = null;
        try {

            cnn = this.getConnection ();
            boolean found = false;

            Statement st = cnn.createStatement ();
            ResultSet rs = st.executeQuery (String.format ("select email from user where email='%s'", user.getLogin ()));

            while (rs.next()) {
                found = true;
                break;
            }

            if (!found) {
                throw new SecutiryException (String.format ("User %s not found", user.getLogin ()));
            }

        } catch (SecutiryException e) {

            throw e;

        } catch (Exception e) {

            throw new SecutiryException (e);

        }  finally {

            try {
                cnn.close ();
            } catch (Exception e) {}
        }
    }

    @Override
    protected void doCheckUserIsEnabled (User user) throws SecutiryException {

        Connection cnn = null;
        try {

            cnn = this.getConnection ();
            boolean found = false;

            Statement st = cnn.createStatement ();
            ResultSet rs = st.executeQuery (String.format ("select enabled from user where email='%s'", user.getLogin ()));

            while (rs.next ()) {

                found = (rs.getInt ("enabled") == 1);
                break;
            }

            if (!found) {
                throw new SecutiryException (String.format ("User %s not enabled", user.getLogin ()));
            }

        } catch (SecutiryException e) {

            throw e;

        } catch (Exception e) {

            throw new SecutiryException (e);

        }  finally {

            try {
                cnn.close ();
            } catch (Exception e) {}
        }
    }

    @Override
    protected void doCheckPassword(User user) throws SecutiryException {

        Connection cnn = null;
        try {

            cnn = this.getConnection ();
            boolean found = false;

            Statement st = cnn.createStatement ();
            ResultSet rs = st.executeQuery (String.format ("select email from user where email='%s' and password='%s'",
                    user.getLogin (), user.getPassword ()));

            while (rs.next()) {
                found = true;
                break;
            }

            if (!found) {
                throw new SecutiryException (String.format ("User %s not found", user.getLogin ()));
            }

        } catch (SecutiryException e) {

            throw e;

        } catch (Exception e) {

            throw new SecutiryException (e);

        }  finally {

            try {
                cnn.close ();
            } catch (Exception e) {}
        }
    }
}