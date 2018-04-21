/*
 * @(#AbstractSecurity.java 04/21/2018
 * Copyright 2018 Educacion IT, Inc. All rights reserved.
 * Educacion IT/CONFIDENTIAL
 * */

package com.educationit.java.standard.integrator.service;


import com.educationit.java.standard.integrator.beans.User;

import static org.apache.commons.lang3.StringUtils.isEmpty;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;


/**
 *
 *  <p>The class <code>com.educationit.java.standard.integrator.service.AbstractSecurity</code>
 *
 *
 *  @author  Raul Geomar Pena (raul.pena@gmail.com)
 *  @version 1.0.0
 *  @since   jdk 1.8
 *  @since   04/21/2018
 * */
public abstract class AbstractSecurity {


    private final static Logger logger = LogManager.getLogger (AbstractSecurity.class);


    public AbstractSecurity () {

        super ();
    }


    private void doCheckFormatUsername (User user) throws BadDataException {

        if (user == null || isEmpty (user.getLogin ())) {

            throw new BadDataException ("User info is empty !!!");
        }

        if (!user.getLogin ().contains ("@")) {

            throw new BadDataException (String.format ("User email [%s] is invalid !!!", user.getLogin ()));
        }
    }


    protected abstract void doCheckUsername (User user) throws SecutiryException;

    protected abstract void doCheckUserIsEnabled (User user) throws SecutiryException;


    /**
     *
     *  <p>Method that execute the login task.
     *
     *  @param user User object
     * @throws SecutiryException
     * @throws BadDataException
     * */
    public final void signIn (User user) throws BadDataException, SecutiryException {

        logger.debug (String.format ("Calling doCheckFormatUsername method with %s...", user.toString ()));
        this.doCheckFormatUsername (user);

        logger.debug (String.format ("Calling doCheckUsername method with %s...", user.toString ()));
        this.doCheckUsername (user);

        logger.debug (String.format ("Calling doCheckUserIsEnabled method with %s...", user.toString ()));
        this.doCheckUserIsEnabled (user);
    }
}