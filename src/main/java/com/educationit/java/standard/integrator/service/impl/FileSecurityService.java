
package com.educationit.java.standard.integrator.service.impl;

import com.educationit.java.standard.integrator.beans.User;
import com.educationit.java.standard.integrator.service.AbstractSecurity;
import com.educationit.java.standard.integrator.service.SecutiryException;


public class FileSecurityService extends AbstractSecurity {


    public FileSecurityService () {

        super ();
    }


    @Override
    protected void doCheckUsername (User user) throws SecutiryException {

    }

    @Override
    protected void doCheckUserIsEnabled (User user) throws SecutiryException {

    }

    @Override
    protected void doCheckPassword(User user) throws SecutiryException {

    }
}
