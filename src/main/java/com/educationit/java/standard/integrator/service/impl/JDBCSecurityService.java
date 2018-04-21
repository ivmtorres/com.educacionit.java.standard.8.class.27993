
package com.educationit.java.standard.integrator.service.impl;


import com.educationit.java.standard.integrator.beans.User;
import com.educationit.java.standard.integrator.service.AbstractSecurity;
import com.educationit.java.standard.integrator.service.BadDataException;
import com.educationit.java.standard.integrator.service.SecutiryException;


public class JDBCSecurityService extends AbstractSecurity {


    public JDBCSecurityService () {

        super ();
    }


    @Override
    protected void doCheckUsername (User user) throws SecutiryException {

    }

    @Override
    protected void doCheckUserIsEnabled (User user) throws SecutiryException {

    }
}